package com.gmail.rogov.service;

import com.gmail.rogov.service.model.ProfileDTO;

import java.util.Set;

public interface ProfileService {

    ProfileDTO create(ProfileDTO role);

    ProfileDTO update(ProfileDTO role);

    ProfileDTO delete(ProfileDTO role);

    ProfileDTO findOne(Long id);

    Set<ProfileDTO> findAll();


}
