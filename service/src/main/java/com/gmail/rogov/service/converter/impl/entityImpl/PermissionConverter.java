package com.gmail.rogov.service.converter.impl.entityImpl;

import com.gmail.rogov.dao.dao.model.Permission;
import com.gmail.rogov.service.converter.Converter;
import com.gmail.rogov.service.model.PermissionDTO;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Controller
public class PermissionConverter implements Converter<PermissionDTO, Permission> {
    @Override
    public Permission toEntity(PermissionDTO dto) {

        Permission permission = new Permission();

        permission.setId(dto.getId());
        permission.setName(dto.getName());

        return permission;
    }

    @Override
    public List<Permission> toEntityList(List<PermissionDTO> list) {
        return list.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Set<Permission> toEntitySet(Set<PermissionDTO> list) {
        return list.stream()
                .map(this::toEntity)
                .collect(Collectors.toSet());
    }
}
