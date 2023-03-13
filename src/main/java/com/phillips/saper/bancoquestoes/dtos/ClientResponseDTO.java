package com.phillips.saper.bancoquestoes.dtos;

import java.util.List;

import com.phillips.saper.bancoquestoes.models.ClientModel;
import com.phillips.saper.bancoquestoes.models.RoleModel;

public class ClientResponseDTO {
    String name;
    String login;

    Long client_id;

    List<RoleModel> role;

    public ClientResponseDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public ClientResponseDTO(String name, String login, Long client_id) {
        this.name = name;
        this.login = login;
        this.client_id = client_id;
    }

    public ClientResponseDTO(ClientModel client) {
        this.name = client.getName();
        this.login = client.getLogin();
        this.client_id = client.getId();
        //TODO talvez melhorar como está sendo retornado no get
        this.role = client.getRoles();
    }

    public List<RoleModel> getRole() {
        return role;
    }

    public void setRole(List<RoleModel> role) {
        this.role = role;
    }



}
