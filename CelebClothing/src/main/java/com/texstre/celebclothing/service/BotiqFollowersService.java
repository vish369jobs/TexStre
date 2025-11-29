package com.texstre.celebclothing.service;

import com.texstre.celebclothing.entity.BotiqDetails;
import com.texstre.celebclothing.entity.BotiqFollowers;
import com.texstre.celebclothing.repository.BotiqDetailsRepository;
import com.texstre.celebclothing.repository.BotiqFollowersRepository;
import com.texstre.celebclothing.util.BotiqDetailsMapper;
import com.texstre.model.BotiQDTO;
import com.texstre.model.BotiqFollowerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BotiqFollowersService {
    @Autowired
    private BotiqFollowersRepository botiqFollowRepo;

    @Autowired
    private BotiqDetailsMapper botiqDetailsMapper;

    public void addBoutiqueFollower(BotiqFollowerDTO botiqFollower) {
        BotiqFollowers followBotiq = BotiqFollowers.builder()
                .botiqId(botiqFollower.getBotiqId())
                .followUserId(botiqFollower.getUserId())
                .isFollowing(Boolean.TRUE)
                .build();
        botiqFollowRepo.save(followBotiq);
    }

    public void unFollowBotiq(Long botiqFollowerId) {
        if(botiqFollowerId != null) {
            Optional<BotiqFollowers> followBotiq = botiqFollowRepo.findById(botiqFollowerId);
            if(followBotiq.isPresent()) {
                followBotiq.get().setFollowing(Boolean.FALSE);
                botiqFollowRepo.save(followBotiq.get());
            }
        }
    }

    public List<Long> getBoutiquesFollowedByUser(Long userId) {
        List<BotiqFollowers> botiqsFollowed = botiqFollowRepo.findAllByFollowUserId(userId);
        List<Long> botiqIdsList = new ArrayList<>();
        for(BotiqFollowers bf : botiqsFollowed) {
            botiqIdsList.add(bf.getBotiqId());
        }
        return botiqIdsList;
    }

    public Integer getBoutiquesFollowersCnt(Long botiqId) {
        return botiqFollowRepo.findAllByBotiqId(botiqId).size();
    }
}
