package com.gmail.rogov.service.converter.impl.entityImpl;

import com.gmail.rogov.dao.dao.model.Profile;
import com.gmail.rogov.service.converter.Converter;
import com.gmail.rogov.service.model.ProfileDTO;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Controller
public class ProfileConverter implements Converter<ProfileDTO, com.gmail.rogov.dao.dao.model.Profile> {
    @Override
    public Profile toEntity(ProfileDTO dto) {
        Profile profile = new Profile();

        profile.setUserId(dto.getUserId());
        profile.setAddress(dto.getAddress());
        profile.setTelephone(dto.getTelephone());
        return profile;
    }

    @Override
    public List<Profile> toEntityList(List<ProfileDTO> list) {
        return list.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Set<Profile> toEntitySet(Set<ProfileDTO> list) {
        return list.stream()
                .map(this::toEntity)
                .collect(Collectors.toSet());
    }
}
