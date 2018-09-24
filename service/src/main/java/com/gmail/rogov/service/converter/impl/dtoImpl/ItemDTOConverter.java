package com.gmail.rogov.service.converter.impl.dtoImpl;

import com.gmail.rogov.dao.dao.model.Item;
import com.gmail.rogov.service.converter.DTOConverter;
import com.gmail.rogov.service.model.ItemDTO;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Controller
public class ItemDTOConverter implements DTOConverter<Item, ItemDTO> {
    @Override
    public ItemDTO toDTO(Item entity) {

        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setId(entity.getId());
        itemDTO.setName(entity.getName());
        itemDTO.setDescription(entity.getDescription());
        itemDTO.setUniqueNumber(entity.getUniqueNumber());
        itemDTO.setPrice(entity.getPrice());
        itemDTO.setOrders(new OrderDTOConverter().toDTOList(entity.getOrders()));

        return itemDTO;
    }

    @Override
    public List<ItemDTO> toDTOList(List<Item> list) {
        return list.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Set<ItemDTO> toDTOSet(Set<Item> list) {
        return list.stream()
                .map(this::toDTO)
                .collect(Collectors.toSet());
    }
}
