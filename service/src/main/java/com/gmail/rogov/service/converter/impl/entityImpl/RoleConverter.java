package com.gmail.rogov.service.converter.impl.entityImpl;

import com.gmail.rogov.dao.dao.model.Role;
import com.gmail.rogov.service.converter.Converter;
import com.gmail.rogov.service.model.RoleDTO;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Controller
public class RoleConverter implements Converter<RoleDTO, com.gmail.rogov.dao.dao.model.Role> {
    @Override
    public Role toEntity(RoleDTO dto) {
        Role role = new Role();

        role.setId(dto.getId());
        role.setName(dto.getName());

        role.setUsers(new UserConverter().toEntitySet(dto.getUsers()));
        role.setPermissions(new PermissionConverter().toEntitySet(dto.getPermissions()));
        return role;
    }

    @Override
    public List<Role> toEntityList(List<RoleDTO> list) {
        return list.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Set<Role> toEntitySet(Set<RoleDTO> list) {
        return list.stream()
                .map(this::toEntity)
                .collect(Collectors.toSet());
    }


}
