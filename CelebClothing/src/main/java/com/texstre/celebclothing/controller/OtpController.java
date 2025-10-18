package com.texstre.celebclothing.controller;

import com.texstre.celebclothing.entity.UserDetails;
import com.texstre.celebclothing.repository.UserDetailsRepository;
import com.texstre.celebclothing.response.ApiResponse;
import com.texstre.celebclothing.service.OtpService;
import com.texstre.celebclothing.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.HttpURLConnection;
import java.util.Optional;

@RestController
@RequestMapping("/otp")
public class OtpController {

    @Autowired
    private OtpService otpService;

    //@Autowired
    //private EmailService emailService;

    @Autowired
    private SmsService smsService;

    @Autowired
    private UserDetailsRepository userRepo;

    @PostMapping("/send/sms")
    public ResponseEntity<ApiResponse<String>> sendOtpSms(@RequestParam String phoneNum) {
        String otp = otpService.generateOtp(phoneNum);
        //smsService.sendOtp(phone, otp);
        ApiResponse<String> resp = new ApiResponse<>(
                HttpURLConnection.HTTP_OK,
                "OTP generated Successfully",
                otp,
                null
        );
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/send/email")
    public ResponseEntity<ApiResponse<String>> sendOtpEmail(@RequestParam String email) {
        String otp = otpService.generateOtp(email);
        //emailService.sendOtp(email, otp);
        ApiResponse<String> resp = new ApiResponse<>(
                HttpURLConnection.HTTP_OK,
                "OTP generated Successfully",
                otp,
                null
        );
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/verify")
    public ResponseEntity<ApiResponse<String>> verifyOtp(@RequestParam String key, @RequestParam String otp) {
        int status = HttpURLConnection.HTTP_NO_CONTENT;
        String msg = "Invalid OTP";
        String usrDetailsObj = "";
        // Return the User Details object, If OTP verification is SUCCESSFUL
        if(otpService.validateOtp(key, otp) ) {
            status = HttpURLConnection.HTTP_OK;
            msg = "OTP Verified Successfully";
            usrDetailsObj = userRepo.findOneByContactNum(Integer.parseInt(key)).toString();
        }

        ApiResponse<String> resp = new ApiResponse<>(
                status,
                msg,
                usrDetailsObj,
                null
        );
        return ResponseEntity.ok(resp);
    }

}
