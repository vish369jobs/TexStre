package com.texstre.celebclothing.controller;

import com.texstre.api.BotiqsApi;
import com.texstre.celebclothing.service.BotiqDetailsService;
import com.texstre.model.ApiResponseDTO;
import com.texstre.model.BotiQDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;

@RestController
public class BotiqDetailsController implements BotiqsApi {
    @Autowired
    BotiqDetailsService botiqDetailsService;

    @Override
    public ResponseEntity<Void> createBotiq(BotiQDTO botiq) {
        botiqDetailsService.addBoutique(botiq);
        return new ResponseEntity<>(HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }

    @Override
    public ResponseEntity<ApiResponseDTO> fetchAllBotiqs() {
        ApiResponseDTO resp = new ApiResponseDTO();
        resp.setData(botiqDetailsService.getAllBoutiques());
        resp.setHttpCode(HttpURLConnection.HTTP_OK);
        // Overwrite the http code , when there is NO DATA
        if(resp.getData() == null) {
            resp.setHttpCode(HttpURLConnection.HTTP_NO_CONTENT);
        }
        return new ResponseEntity<>(resp, HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }

    @Override
    public ResponseEntity<ApiResponseDTO> fetchBotiqById(Long botiqId) {
        ApiResponseDTO resp = new ApiResponseDTO();
        resp.setData(botiqDetailsService.getBoutiqueDetailsById(botiqId));
        resp.setHttpCode(HttpURLConnection.HTTP_OK);
        // Overwrite the http code , when there is NO DATA
        if(resp.getData() == null) {
            resp.setHttpCode(HttpURLConnection.HTTP_NO_CONTENT);
        }
        return new ResponseEntity<>(resp, HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }
}
