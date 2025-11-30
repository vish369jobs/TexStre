package com.texstre.celebclothing.repository;

import com.texstre.celebclothing.entity.BotiqProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BotiqProductsRepository extends JpaRepository<BotiqProducts, Long> {
    List<BotiqProducts> findByBotiqId(Long botiqId);
    List<BotiqProducts> findByBotiqIdAndProductCategory(Long botiqId, String category);
}