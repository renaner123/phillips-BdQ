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
    Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    RoleNames role;

    @Override
    public String getAuthority() {
        return role.toString();
    }
}
