package com.gmail.rogov.service.converter.impl.entityImpl;

import com.gmail.rogov.dao.dao.model.Item;
import com.gmail.rogov.dao.dao.model.Order;
import com.gmail.rogov.dao.dao.model.User;
import com.gmail.rogov.service.converter.Converter;
import com.gmail.rogov.service.model.OrderDTO;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Controller
public class OrderConverter implements Converter<OrderDTO, Order> {
    @Override
    public Order toEntity(OrderDTO dto) {
        Order order = new Order();
        User user = new User();
        Item item = new Item();

        order.setId(dto.getId());
        order.setCreated(dto.getCreated());
        order.setQuantity(dto.getQuantity());
        user.setId(dto.getUserId());
        order.setUser(user);
        item.setId(dto.getItemId());
        order.setItem(item);

        return order;
    }

    @Override
    public List<Order> toEntityList(List<OrderDTO> list) {
        return list.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Set<Order> toEntitySet(Set<OrderDTO> list) {
        return list.stream()
                .map(this::toEntity)
                .collect(Collectors.toSet());
    }
}
