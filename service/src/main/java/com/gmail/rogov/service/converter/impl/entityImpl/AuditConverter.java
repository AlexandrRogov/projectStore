package com.gmail.rogov.service.converter.impl.entityImpl;


import com.gmail.rogov.dao.dao.model.Audit;
import com.gmail.rogov.dao.dao.model.User;
import com.gmail.rogov.service.converter.Converter;
import com.gmail.rogov.service.model.AuditDTO;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class AuditConverter implements Converter<AuditDTO, Audit> {
    @Override
    public Audit toEntity(AuditDTO dto) {
        Audit audit = new Audit();
        User user = new User();

        audit.setId(dto.getId());
        audit.setEventType(dto.getEventType());
        audit.setCreated(dto.getCreated());

        user.setId(dto.getUserId());
        audit.setUser(user);


        return audit;
    }

    @Override
    public List<Audit> toEntityList(List<AuditDTO> list) {
        return list.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Set<Audit> toEntitySet(Set<AuditDTO> list) {
        return list.stream()
                .map(this::toEntity)
                .collect(Collectors.toSet());
    }
}
