package com.gmail.rogov.service;

import com.gmail.rogov.service.model.PermissionDTO;

import java.util.Set;

public interface PermissionService {

    PermissionDTO create(PermissionDTO role);

    PermissionDTO update(PermissionDTO role);

    PermissionDTO delete(PermissionDTO role);

    PermissionDTO findOne(Long id);

    Set<PermissionDTO> findAll();


}
