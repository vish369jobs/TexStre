package com.texstre.celebclothing.controller;

import com.texstre.api.BotiqFollowersApi;
import com.texstre.api.BotiqsApi;
import com.texstre.celebclothing.service.BotiqDetailsService;
import com.texstre.celebclothing.service.BotiqFollowersService;
import com.texstre.model.ApiResponseDTO;
import com.texstre.model.BotiQDTO;
import com.texstre.model.BotiqFollowerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;

@RestController
public class BotiqFollowersController implements BotiqFollowersApi {
    @Autowired
    BotiqFollowersService botiqfollowersService;

    @Override
    public ResponseEntity<ApiResponseDTO> addFollowerToBotiq(BotiqFollowerDTO botiqFollowerDTO) {
        ApiResponseDTO resp = new ApiResponseDTO();
        botiqfollowersService.addBoutiqueFollower(botiqFollowerDTO);
        resp.setHttpCode(HttpURLConnection.HTTP_CREATED);
        resp.setMessage("Follower Added to Boutique Successfully");
        return new ResponseEntity<>(resp, HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }

    @Override
    public ResponseEntity<ApiResponseDTO> removeFollowerFrmBotiq(Long botiqId, Long followUsrId) {
        ApiResponseDTO resp = new ApiResponseDTO();
        botiqfollowersService.unFollowBotiq(botiqId, followUsrId);
        resp.setHttpCode(HttpURLConnection.HTTP_CREATED);
        resp.setMessage("Boutique Unfollowed Successfully");
        return new ResponseEntity<>(resp, HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }

    @Override
    public ResponseEntity<ApiResponseDTO> fetchBotiqFollowersCnt(Long botiqId) {
        ApiResponseDTO resp = new ApiResponseDTO();
        resp.setData(botiqfollowersService.getBoutiquesFollowersCnt(botiqId));
        resp.setHttpCode(HttpURLConnection.HTTP_CREATED);
        return new ResponseEntity<>(resp, HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }

    @Override
    public ResponseEntity<ApiResponseDTO> fetchBotiqsFollowedByUser(Long userId) {
        ApiResponseDTO resp = new ApiResponseDTO();
        resp.setData(botiqfollowersService.getBoutiquesFollowedByUser(userId));
        resp.setHttpCode(HttpURLConnection.HTTP_CREATED);
        return new ResponseEntity<>(resp, HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }
}
