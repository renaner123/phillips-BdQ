package com.phillips.saper.bancoquestoes.dtos;

import java.util.List;
import java.util.Objects;

import com.phillips.saper.bancoquestoes.models.ClientModel;
import com.phillips.saper.bancoquestoes.models.RoleModel;

public class ClientResponseDTO {
    String name;
    String login;
    //TODO Adicionar  @Schema(example = "") nos atributos e validações

    Long id_client;

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

    public Long getid_client() {
        return id_client;
    }

    public void setid_client(Long id_client) {
        this.id_client = id_client;
    }

    public ClientResponseDTO(String name, String login, Long id_client) {
        this.name = name;
        this.login = login;
        this.id_client = id_client;
    }

    public ClientResponseDTO(ClientModel client) {
        this.name = client.getName();
        this.login = client.getLogin();
        this.id_client = client.getId();
        // TODO talvez melhorar como está sendo retornado no get
        this.role = client.getRoles();
    }

    public List<RoleModel> getRole() {
        return role;
    }

    public void setRole(List<RoleModel> role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ClientResponseDTO other = (ClientResponseDTO) obj;
        return Objects.equals(name, other.name) &&
                login == other.login && id_client == other.id_client;
    }

}
