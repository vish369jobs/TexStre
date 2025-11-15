package com.texstre.celebclothing.repository;

import com.texstre.celebclothing.entity.BotiqDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BotiqDetailsRepository extends JpaRepository<BotiqDetails, Long> {
}
