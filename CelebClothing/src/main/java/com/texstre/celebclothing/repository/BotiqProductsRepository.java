package com.texstre.celebclothing.repository;

import com.texstre.celebclothing.entity.BotiqProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BotiqProductsRepository extends JpaRepository<BotiqProducts, Long> {

}