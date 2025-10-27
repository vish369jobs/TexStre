package com.texstre.celebclothing.repository;

import com.texstre.celebclothing.entity.DeliveryAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<DeliveryAddress, Long> {
    List<DeliveryAddress> findByLinkedUsrId(String userId);
}
