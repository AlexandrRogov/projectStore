package com.gmail.rogov.service.converter.impl.entityImpl;

import com.gmail.rogov.dao.dao.model.Item;
import com.gmail.rogov.service.converter.Converter;
import com.gmail.rogov.service.model.ItemDTO;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Controller
public class ItemConverter implements Converter<ItemDTO, Item> {
    @Override
    public Item toEntity(ItemDTO dto) {
        Item item = new Item();

        item.setId(dto.getId());
        item.setName(dto.getName());
        item.setDescription(dto.getDescription());
        item.setUniqueNumber(dto.getUniqueNumber());
        item.setPrice(dto.getPrice());
        item.setOrders(new OrderConverter().toEntityList(dto.getOrders()));

        return item;
    }

    @Override
    public List<Item> toEntityList(List<ItemDTO> list) {
        return list.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Set<Item> toEntitySet(Set<ItemDTO> list) {
        return list.stream()
                .map(this::toEntity)
                .collect(Collectors.toSet());
    }
}
