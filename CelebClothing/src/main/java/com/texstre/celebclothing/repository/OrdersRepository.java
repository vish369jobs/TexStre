package com.texstre.celebclothing.repository;

import com.texstre.celebclothing.entity.DeliveryAddress;
import com.texstre.celebclothing.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<OrderDetails, Long> {
}
