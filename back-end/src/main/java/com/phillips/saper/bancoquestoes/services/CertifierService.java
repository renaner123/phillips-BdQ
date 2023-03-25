package com.phillips.saper.bancoquestoes.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.phillips.saper.bancoquestoes.dtos.CertifierRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.CertifierResponseDTO;
import com.phillips.saper.bancoquestoes.dtos.ClientRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.TeacherRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.TeacherResponseDTO;
import com.phillips.saper.bancoquestoes.enums.RoleNames;
import com.phillips.saper.bancoquestoes.exceptions.ConflictStoreException;
import com.phillips.saper.bancoquestoes.models.CertifierModel;
import com.phillips.saper.bancoquestoes.models.ClientModel;
import com.phillips.saper.bancoquestoes.models.RoleModel;
import com.phillips.saper.bancoquestoes.repositories.CertifierRepository;
import com.phillips.saper.bancoquestoes.repositories.ClientRepository;
import com.phillips.saper.bancoquestoes.repositories.RoleRepository;
import com.phillips.saper.bancoquestoes.repositories.StudentRepository;
import com.phillips.saper.bancoquestoes.repositories.TeacherRepository;

import jakarta.transaction.Transactional;

@Service
public class CertifierService {

    @Autowired
    CertifierRepository certifierRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    StudentRepository studentRepository;

    public List<CertifierModel> findAll() {
        return certifierRepository.findAll();
    }

    public ResponseEntity<CertifierResponseDTO> save(TeacherRequestDTO certifierRequestDTO) {
        ClientRequestDTO clientRequestDTO = new ClientRequestDTO();
        BeanUtils.copyProperties(certifierRequestDTO, clientRequestDTO);
        ClientModel client = clientRequestDTO.toClient();

        if(clientRepository.existsByLogin(client.getLogin())){
            throw new ConflictStoreException("login already in use");
        }

        // FIXME [Renan] certo seria deixar o cpf na tabela cliente para evitar essa double query. Alterar futuramente
        if(teacherRepository.existsByCpf(certifierRequestDTO.getCpf()) || studentRepository.existsByCpf(certifierRequestDTO.getCpf())){
            throw new ConflictStoreException("cpf already in use");
        }
        
        Optional<RoleModel> role = roleRepository.findByRole(RoleNames.ROLE_CERTIFIER);
        List<RoleModel> roles = new ArrayList<>();
        roles.add(role.get());
        client.setRoles(roles);

        clientRepository.save(client);

        CertifierModel certifierModel = new CertifierModel(certifierRequestDTO.getCpf(), certifierRequestDTO.getName(), certifierRequestDTO.getLogin(),certifierRequestDTO.getIdDiscipline(),0, false);

        certifierModel.setClientModel(client);   
        System.out.println(certifierRepository.save(certifierModel));
        return ResponseEntity.status(HttpStatus.CREATED).body(new CertifierResponseDTO(certifierRepository.save(certifierModel)));
    }

    @Transactional
    public ResponseEntity<Object> update(Long id, CertifierRequestDTO certifierRequestDTO){

        Optional<CertifierModel> certifierOptional = certifierRepository.findById(id);

        if(certifierOptional.isPresent()){
            CertifierModel certifier = certifierOptional.get();

            if(certifierRequestDTO.getName()!=null){
                certifier.setName(certifierRequestDTO.getName());
            }
            if(certifierRequestDTO.getLogin()!=null){
                certifier.setEmail(certifierRequestDTO.getLogin());
            }
            if(certifierRequestDTO.getCpf()!=null){
                certifier.setCpf(certifierRequestDTO.getCpf());
            }
            if(certifierRequestDTO.getIdDiscipline()!=0){
                certifier.setIdDiscipline(certifierRequestDTO.getIdDiscipline());
            }
            
            BeanUtils.copyProperties(certifierRequestDTO, certifier);  
            TeacherResponseDTO certifierResponseDTO = new TeacherResponseDTO(certifierRepository.save(certifier));
            
            return ResponseEntity.status(HttpStatus.OK).body(certifierResponseDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
     }

     @Transactional
     public ResponseEntity<Object> delete(Long id){

        Optional<CertifierModel> certifierOptional = certifierRepository.findById(id);

        if(certifierOptional.isPresent()){
            CertifierModel certifier = certifierOptional.get();
            certifierRepository.delete(certifier);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }

     } 

}
