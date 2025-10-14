package com.texstre.celebclothing.controller;

import com.texstre.celebclothing.response.ApiResponse;
import com.texstre.celebclothing.service.OtpService;
import com.texstre.celebclothing.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/otp")
public class OtpController {

    @Autowired
    private OtpService otpService;

    //@Autowired
    //private EmailService emailService;

    @Autowired
    private SmsService smsService;

    @PostMapping("/send/sms")
    public ResponseEntity<ApiResponse<String>> sendOtpSms(@RequestParam String phoneNum) {
        String otp = otpService.generateOtp(phoneNum);
        //smsService.sendOtp(phone, otp);
        ApiResponse<String> resp = new ApiResponse<>(
                "success",
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
                "success",
                "OTP generated Successfully",
                otp,
                null
        );
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/verify")
    public ResponseEntity<ApiResponse<String>> verifyOtp(@RequestParam String key, @RequestParam String otp) {
        String status = "Success";
        String msg = "OTP Verified Successfully";

        if(! otpService.validateOtp(key, otp) ) {
            status = "Error";
            msg = "Invalid OTP";
        }

        ApiResponse<String> resp = new ApiResponse<>(
                status,
                msg,
                null,
                null
        );
        return ResponseEntity.ok(resp);
    }

}
