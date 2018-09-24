package com.gmail.rogov.service;

import com.gmail.rogov.service.model.OrderDTO;

import java.util.Set;

public interface OrderService {

    OrderDTO create(OrderDTO role);

    OrderDTO update(OrderDTO role);

    OrderDTO delete(OrderDTO role);

    OrderDTO findOne(Long id);

    Set<OrderDTO> findAll();


}
