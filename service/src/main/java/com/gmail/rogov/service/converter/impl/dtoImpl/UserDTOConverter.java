package com.gmail.rogov.service.converter.impl.dtoImpl;


import com.gmail.rogov.dao.dao.model.User;
import com.gmail.rogov.service.converter.DTOConverter;
import com.gmail.rogov.service.model.UserDTO;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Controller
public class UserDTOConverter implements DTOConverter<User, UserDTO> {

    @Override
    public UserDTO toDTO(User entity) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(entity.getId());
        userDTO.setPassword(entity.getPassword());
        userDTO.setFirstName(entity.getFirstName());
        userDTO.setLastName(entity.getLastName());
        userDTO.setCreated(entity.getCreated());

        userDTO.setRoleId(entity.getRole().getId());
        userDTO.setComments(new CommentDTOConverter().toDTOSet(entity.getComments()));
        userDTO.setNewsSet( new NewsDTOConverter().toDTOSet(entity.getNewsSet()));
        userDTO.setAudit(new AuditDTOConverter().toDTOSet(entity.getAudit()));
        userDTO.setOrders(new OrderDTOConverter().toDTOList(entity.getOrders()));

        return userDTO;
    }

    @Override
    public List<UserDTO> toDTOList(List<User> list) {
        return list.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Set<UserDTO> toDTOSet(Set<User> list) {
        return list.stream()
                .map(this::toDTO)
                .collect(Collectors.toSet());
    }
}
