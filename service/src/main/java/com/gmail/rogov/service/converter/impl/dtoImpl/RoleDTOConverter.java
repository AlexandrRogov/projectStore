package com.gmail.rogov.service.converter.impl.dtoImpl;


import com.gmail.rogov.dao.dao.model.Role;
import com.gmail.rogov.service.converter.DTOConverter;
import com.gmail.rogov.service.model.RoleDTO;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Controller
public class RoleDTOConverter implements DTOConverter<Role, RoleDTO> {

    @Override
    public RoleDTO toDTO(Role entity) {
        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId(entity.getId());
        roleDTO.setName(entity.getName());

        roleDTO.setUsers(new UserDTOConverter().toDTOSet(entity.getUsers()));
        roleDTO.setPermissions(new PermissionDTOConverter().toDTOSet(entity.getPermissions()));

        return roleDTO;
    }

    @Override
    public List<RoleDTO> toDTOList(List<Role> list) {
        return list.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Set<RoleDTO> toDTOSet(Set<Role> list) {
        return list.stream()
                .map(this::toDTO)
                .collect(Collectors.toSet());
    }


}
