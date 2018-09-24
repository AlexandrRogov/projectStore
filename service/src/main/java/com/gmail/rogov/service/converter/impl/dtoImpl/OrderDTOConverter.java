package com.gmail.rogov.service.converter.impl.dtoImpl;

import com.gmail.rogov.dao.dao.model.Order;
import com.gmail.rogov.service.converter.DTOConverter;
import com.gmail.rogov.service.model.OrderDTO;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Controller
public class OrderDTOConverter implements DTOConverter<Order, OrderDTO> {
    @Override
    public OrderDTO toDTO(Order entity) {

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId(entity.getId());
        orderDTO.setCreated(entity.getCreated());
        orderDTO.setQuantity(entity.getQuantity());
        orderDTO.setUserId(entity.getUser().getId());
        orderDTO.setItemId(entity.getItem().getId());

        return orderDTO;
    }

    @Override
    public List<OrderDTO> toDTOList(List<Order> list) {
        return list.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Set<OrderDTO> toDTOSet(Set<Order> list) {
        return list.stream()
                .map(this::toDTO)
                .collect(Collectors.toSet());
    }
}
