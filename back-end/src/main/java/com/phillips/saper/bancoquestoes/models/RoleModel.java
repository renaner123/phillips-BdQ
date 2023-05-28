package com.phillips.saper.bancoquestoes.models;

import org.springframework.security.core.GrantedAuthority;

import com.phillips.saper.bancoquestoes.enums.RoleNames;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RoleModel implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private  RoleNames role;

    public RoleModel(long l, RoleNames roleTeacher) {
        this.id = l;
        this.role = roleTeacher;
    }

    @Override
    public String getAuthority() {
        return role.toString();
    }
}
