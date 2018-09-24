package com.gmail.rogov.service.converter.impl.dtoImpl;

import com.gmail.rogov.dao.dao.model.Discount;
import com.gmail.rogov.service.converter.DTOConverter;
import com.gmail.rogov.service.model.DiscountDTO;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Controller
public class DiscountDTOConverter implements DTOConverter<Discount, DiscountDTO> {
    @Override
    public DiscountDTO toDTO(Discount entity) {

        DiscountDTO discount =new DiscountDTO();

        discount.setId(entity.getId());
        discount.setName(entity.getName());
        discount.setPercent(entity.getPercent());
        discount.setTermination(entity.getTermination());
        discount.setUsers(new UserDTOConverter().toDTOSet(entity.getUsers()));
        return discount;
    }

    @Override
    public List<DiscountDTO> toDTOList(List<Discount> list) {
        return list.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Set<DiscountDTO> toDTOSet(Set<Discount> list) {
        return list.stream()
                .map(this::toDTO)
                .collect(Collectors.toSet());
    }
}
