package com.texstre.celebclothing.controller;

import com.texstre.api.LegalApi;
import com.texstre.model.ApiResponseDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

@RestController
public class LegalController implements LegalApi {

    @Override
    public ResponseEntity<ApiResponseDTO> retrievePrivacyPolicy() {
        ApiResponseDTO resp = new ApiResponseDTO();
        resp.setHttpCode(HttpURLConnection.HTTP_OK);
        try (InputStream inputStream = getClass().getResourceAsStream("/static/PrivacyPolicy.txt")) {
            assert inputStream != null;
            String fileData = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            resp.setData(fileData);
        }
        catch (Exception e) {
            System.out.println("Exception in Privacy Policy Retrieval");
        }
        return new ResponseEntity<>(resp, HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }

    @Override
    public ResponseEntity<ApiResponseDTO> retrieveTermsAndConditions() {
        ApiResponseDTO resp = new ApiResponseDTO();
        resp.setHttpCode(HttpURLConnection.HTTP_OK);
        try (InputStream inputStream = getClass().getResourceAsStream("/static/TermsAndConditions.txt")) {
            assert inputStream != null;
            String fileData = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            resp.setData(fileData);
        } catch (Exception e) {
            System.out.println("Exception in Terms & Conditions Retrieval");
        }
        return new ResponseEntity<>(resp, HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }
}
