package com.gmail.rogov.service;

import com.gmail.rogov.service.model.AuditDTO;

import java.util.Set;

public interface AuditService {

    AuditDTO create(AuditDTO role);

    AuditDTO update(AuditDTO role);

    AuditDTO delete(AuditDTO role);

    AuditDTO findOne(Long id);

    Set<AuditDTO> findAll();


}
