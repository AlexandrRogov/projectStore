package com.gmail.rogov.service.converter.impl.dtoImpl;

import com.gmail.rogov.dao.dao.model.Audit;
import com.gmail.rogov.service.converter.DTOConverter;
import com.gmail.rogov.service.model.AuditDTO;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Controller
public class AuditDTOConverter implements DTOConverter<Audit, AuditDTO> {
    @Override
    public AuditDTO toDTO(Audit entity) {

        AuditDTO auditDTO = new AuditDTO();

        auditDTO.setId(entity.getId());
        auditDTO.setEventType(entity.getEventType());
        auditDTO.setCreated(entity.getCreated());
        auditDTO.setUserId(entity.getUser().getId());

        return auditDTO;
    }

    @Override
    public List<AuditDTO> toDTOList(List<Audit> list) {
        return list.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Set<AuditDTO> toDTOSet(Set<Audit> list) {
        return list.stream()
                .map(this::toDTO)
                .collect(Collectors.toSet());
    }
}
