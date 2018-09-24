package com.gmail.rogov.service.converter.impl.dtoImpl;

import com.gmail.rogov.dao.dao.model.Profile;
import com.gmail.rogov.service.converter.DTOConverter;
import com.gmail.rogov.service.model.ProfileDTO;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Controller
public class ProfileDTOConverter implements DTOConverter<Profile, ProfileDTO> {
    @Override
    public ProfileDTO toDTO(Profile entity) {

        ProfileDTO profileDTO = new ProfileDTO();

        profileDTO.setUserId(entity.getUserId());
        profileDTO.setAddress(entity.getAddress());
        profileDTO.setTelephone(entity.getTelephone());

        return profileDTO;
    }

    @Override
    public List<ProfileDTO> toDTOList(List<Profile> list) {
        return list.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Set<ProfileDTO> toDTOSet(Set<Profile> list) {
        return list.stream()
                .map(this::toDTO)
                .collect(Collectors.toSet());
    }
}
