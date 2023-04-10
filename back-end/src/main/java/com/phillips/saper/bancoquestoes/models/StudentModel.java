package com.phillips.saper.bancoquestoes.models;

import java.util.HashSet;
import java.util.Set;

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
}
