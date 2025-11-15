package com.texstre.celebclothing.service;

import com.texstre.celebclothing.entity.BotiqDetails;
import com.texstre.celebclothing.repository.BotiqDetailsRepository;
import com.texstre.celebclothing.util.BotiqDetailsMapper;
import com.texstre.model.BotiQDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BotiqDetailsService {
    @Autowired
    private BotiqDetailsRepository botiqRepo;

    @Autowired
    private BotiqDetailsMapper botiqDetailsMapper;

    public void addBoutique(BotiQDTO botiq) {
        BotiqDetails botiqDetails = BotiqDetails.builder()
                .botiqName(botiq.getBotiqName())
                .botiqBannerImg(botiq.getBotiqBannerImg())
                .botiqRating(botiq.getBotiqRating())
                .botiqFollowersCnt(botiq.getBotiqFollowersCnt())
                .botiqProductsCnt(botiq.getBotiqProductsCnt())
                .build();
        botiqRepo.save(botiqDetails);
    }

    public List<BotiQDTO> getAllBoutiques() {
        List<BotiQDTO> botiqsList = new ArrayList<>();
        for(BotiqDetails botiqDetail : botiqRepo.findAll()) {
            botiqsList.add(botiqDetailsMapper.BotiqDetailsToBotiQDTO(botiqDetail));
        }
        return botiqsList;
    }

    public BotiQDTO getBoutiqueDetailsById(Long botiqId) {
        return botiqDetailsMapper.BotiqDetailsToBotiQDTO(botiqRepo.findById(botiqId).orElse(null));
    }
}
