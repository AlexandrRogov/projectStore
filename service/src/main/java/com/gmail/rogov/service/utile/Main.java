package com.gmail.rogov.service.utile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.gmail.rogov.service.DiscountService;
import com.gmail.rogov.service.ItemService;
import com.gmail.rogov.service.UserService;
import com.gmail.rogov.service.impl.DiscountServiceImpl;
import com.gmail.rogov.service.impl.ItemServiceImpl;
import com.gmail.rogov.service.impl.UserServiceImpl;
import com.gmail.rogov.service.model.DiscountDTO;
import com.gmail.rogov.service.model.ItemDTO;
import com.gmail.rogov.service.model.UserDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);


    private static void updateDiscountWithParametr(DiscountDTO discountDTO, Set<ItemDTO> itemSet, DiscountService discountService) {
        ItemDTO item = new ItemDTO();
        //todo
        for (ItemDTO i : itemSet) {

        }
        discountService.update(discountDTO);
    }

    public static void main(String[] args) {
        ItemService itemService = new ItemServiceImpl();
        DiscountService discountService = new DiscountServiceImpl();
        ItemDTO item = new ItemDTO();
        UserService userService = new UserServiceImpl();

        // generate random price
        int a = 100; // firs price
        int b = 500; // finish price
        for (int i = 1; i <= 30; i++) {
            item.setPrice(new BigDecimal(new Random().nextInt(401) + 100));
            item.setName("Name" + i);
            item.setUniqueNumber("i=" + i);
            item.setDescription("its new Thinks" + i);
//todo
        }

        // generate discount 10,20,30
        for (int i = 10; i <= 30; i += 10) {
            DiscountDTO discountDTO = new DiscountDTO();
            discountDTO.setPercent(i);
            discountDTO.setName("Name " + i);
            discountDTO.setTermination(LocalDateTime.now().plusMonths(5));
//todo
        }
        // connect links
        Set<ItemDTO> itemSet = new HashSet<>();
        itemSet = itemService.findSetItemInParametrs(new BigDecimal(200), new BigDecimal(299));
        System.out.println(1);
        updateDiscountWithParametr(discountService.findDiscountByPercent(10), itemSet, discountService);
        itemSet = itemService.findSetItemInParametrs(new BigDecimal(300), new BigDecimal(399));
        updateDiscountWithParametr(discountService.findDiscountByPercent(20), itemSet, discountService);
        itemSet = itemService.findSetItemInParametrs(new BigDecimal(400), new BigDecimal(500));
        updateDiscountWithParametr(discountService.findDiscountByPercent(30), itemSet, discountService);

        //method find item dependents discount;





        UserDTO userDTO = new UserDTO();

        userDTO.setLastName("Alex");
        userDTO.setCreated(LocalDateTime.now());
        userDTO.setFirstName("Alex");
        userDTO.setRoleId(2L);
        userDTO.setDiscountID(0L);
        userService.create(userDTO);
        System.out.println(1);
    }
}
