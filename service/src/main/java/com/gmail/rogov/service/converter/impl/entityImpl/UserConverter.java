package com.gmail.rogov.service.converter.impl.entityImpl;

import com.gmail.rogov.dao.dao.model.Role;
import com.gmail.rogov.dao.dao.model.User;
import com.gmail.rogov.service.converter.Converter;
import com.gmail.rogov.service.model.UserDTO;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Controller
public class UserConverter implements Converter<UserDTO, User> {
    @Override
    public User toEntity(UserDTO dto) {
        User user = new User();
        Role role = new Role();

        user.setId(dto.getId());
        user.setPassword(dto.getPassword());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setCreated(dto.getCreated());

        role.setId(dto.getRoleId());
        user.setRole(role);
        user.setComments(new CommentConverter().toEntitySet(dto.getComments()));
        user.setNewsSet(new NewsConverter().toEntitySet(dto.getNewsSet()));
        user.setAudit(new AuditConverter().toEntitySet(dto.getAudit()));
        user.setOrders(new OrderConverter().toEntityList(dto.getOrders()));

        return user;
    }

    @Override
    public List<User> toEntityList(List<UserDTO> list) {
        return list.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Set<User> toEntitySet(Set<UserDTO> list) {
        return list.stream()
                .map(this::toEntity)
                .collect(Collectors.toSet());
    }
}
