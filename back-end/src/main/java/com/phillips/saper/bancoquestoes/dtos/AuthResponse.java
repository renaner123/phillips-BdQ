package com.phillips.saper.bancoquestoes.dtos;

import java.util.List;

import com.phillips.saper.bancoquestoes.models.RoleModel;

public record AuthResponse(Long id, String name, List<RoleModel> role) {
}
