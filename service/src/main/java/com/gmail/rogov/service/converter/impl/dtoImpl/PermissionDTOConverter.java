package com.gmail.rogov.service.converter.impl.dtoImpl;

import com.gmail.rogov.dao.dao.model.Permission;
import com.gmail.rogov.service.converter.DTOConverter;
import com.gmail.rogov.service.model.PermissionDTO;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Controller
public class PermissionDTOConverter implements DTOConverter<Permission, PermissionDTO> {
    @Override
    public PermissionDTO toDTO(Permission entity) {
        PermissionDTO permissionDTO = new PermissionDTO();

        permissionDTO.setId(entity.getId());
        permissionDTO.setName(entity.getName());

        return permissionDTO;
    }

    @Override
    public List<PermissionDTO> toDTOList(List<Permission> list) {
        return list.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Set<PermissionDTO> toDTOSet(Set<Permission> list) {
        return list.stream()
                .map(this::toDTO)
                .collect(Collectors.toSet());
    }
}
