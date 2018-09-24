package com.gmail.rogov.service.converter.impl.entityImpl;

import com.gmail.rogov.dao.dao.model.Discount;
import com.gmail.rogov.service.converter.Converter;
import com.gmail.rogov.service.model.DiscountDTO;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Controller
public class DiscountConverter implements Converter<DiscountDTO, Discount> {


    @Override
    public Discount toEntity(DiscountDTO dto) {
        Discount discount = new Discount();

        discount.setId(dto.getId());
        discount.setName(dto.getName());
        discount.setPercent(dto.getPercent());
        discount.setTermination(dto.getTermination());
        discount.setUsers(new UserConverter().toEntitySet(dto.getUsers()));
        return discount;
    }

    @Override
    public List<Discount> toEntityList(List<DiscountDTO> list) {
        return list.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Set<Discount> toEntitySet(Set<DiscountDTO> list) {
        return list.stream()
                .map(this::toEntity)
                .collect(Collectors.toSet());
    }
}
