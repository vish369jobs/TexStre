package com.texstre.celebclothing.repository;

import com.texstre.celebclothing.entity.BotiqDetails;
import com.texstre.celebclothing.entity.BotiqFollowers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BotiqFollowersRepository extends JpaRepository<BotiqFollowers, Long> {
    List<BotiqFollowers> findAllByFollowUserId(Long userId);
    List<BotiqFollowers> findAllByBotiqId(Long botiqId);
    Optional<BotiqFollowers> findByBotiqIdAndFollowUserId(Long botiqId, Long followUsrId);
}
