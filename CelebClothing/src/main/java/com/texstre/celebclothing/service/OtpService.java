package com.texstre.celebclothing.service;

import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class OtpService {

    private final Map<String, String> otpStore = new HashMap<>();
    private final Random random = new SecureRandom();

    public String generateOtp(String key) {
        String otp = String.format("%04d", random.nextInt(10000));
        otpStore.put(key, otp);
        return otp;
    }

    public boolean validateOtp(String key, String otp) {
        return otp.equals(otpStore.getOrDefault(key, ""));
    }
}