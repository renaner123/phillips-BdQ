package com.phillips.saper.bancoquestoes.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.phillips.saper.bancoquestoes.dtos.MaterialResponseDTO;
import com.phillips.saper.bancoquestoes.dtos.StudentResponseDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private Long idStudent;

    private String cpf;
    private String name;
    private String email;

    @OneToOne(targetEntity = ClientModel.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_client")
    ClientModel clientModel;

    @ManyToMany()
    @JoinTable(name = "student_has_test",
        joinColumns = @JoinColumn(name = "id_student"),
        inverseJoinColumns = @JoinColumn(name = "id_test"))
    private Set<TestModel> tests = new HashSet<>();

    @OneToMany(mappedBy = "id.idStudent", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StudentTest> studentTests = new HashSet<>();

    @ManyToMany(
        targetEntity = MaterialModel.class,
        mappedBy = "students")
    Set<MaterialModel> materials;

    public StudentModel(Long idStudent, String cpf, String name, String email) {
        this.idStudent = idStudent;
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    public StudentModel() {
    }
    
    public StudentModel(StudentResponseDTO returnStudentDTO) {
        this.idStudent = returnStudentDTO.getId();
        this.cpf = returnStudentDTO.getCpf();
        this.name = returnStudentDTO.getName();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StudentModel other = (StudentModel) obj;
        return Objects.equals(name, other.name) &&
                cpf == other.cpf && idStudent == other.idStudent;
    }
    
}
