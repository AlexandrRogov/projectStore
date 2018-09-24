package com.gmail.rogov.service;

import com.gmail.rogov.service.model.RoleDTO;

import java.util.Set;

public interface RoleService {

    RoleDTO create(RoleDTO role);

    RoleDTO update(RoleDTO role);

    RoleDTO delete(RoleDTO role);

    RoleDTO findOne(Long id);

    Set<RoleDTO> findAll();
}
