package com.texstre.celebclothing.service;

import com.texstre.celebclothing.entity.DeliveryAddress;
import com.texstre.celebclothing.entity.OrderDetails;
import com.texstre.celebclothing.repository.AddressRepository;
import com.texstre.celebclothing.repository.OrdersRepository;
import com.texstre.celebclothing.util.AddressMapper;
import com.texstre.celebclothing.util.NullAwareBeanUtilsBean;
import com.texstre.model.DeliveryAddressDTO;
import com.texstre.model.OrderDetailsDTO;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrdersRepository orderRepo;

    public void createOrder(OrderDetailsDTO ordDetails) {
        OrderDetails newOrder = OrderDetails.builder()
                .orderByUserId(ordDetails.getOrderUserId())
                .deliveryAddressId(ordDetails.getDeliveryAddressId())
                .totalCost(ordDetails.getTotalCost())
                .build();
        orderRepo.save(newOrder);
    }


}

