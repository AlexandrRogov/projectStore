package com.gmail.rogov.service;

import com.gmail.rogov.service.model.DiscountDTO;

import java.util.Set;

public interface DiscountService {

    DiscountDTO create(DiscountDTO discountDTO);

    DiscountDTO delete(DiscountDTO discountDTO);

    DiscountDTO findDiscountByPercent(Integer percent);

    DiscountDTO update(DiscountDTO discountDTO);

    DiscountDTO findOne(Long id);

    Set<DiscountDTO> findAll();


}
