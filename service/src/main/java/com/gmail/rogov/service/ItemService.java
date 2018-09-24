package com.gmail.rogov.service;

import com.gmail.rogov.service.model.ItemDTO;

import java.math.BigDecimal;
import java.util.Set;

public interface ItemService {

    ItemDTO create(ItemDTO itemDTO);

    ItemDTO delete(ItemDTO itemDTO);

    ItemDTO findOne(Long id);

    ItemDTO update(ItemDTO itemDTO);

    Set<ItemDTO> findAll();

    Set<ItemDTO> findSetItemInParametrs(BigDecimal start, BigDecimal finish);

}
