package com.texstre.celebclothing.repository;

import com.texstre.celebclothing.entity.BotiqDetails;
import com.texstre.celebclothing.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BotiqDetailsRepository extends JpaRepository<BotiqDetails, Long> {
}
