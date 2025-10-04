package com.celebclothing.texstre.controller;

import com.celebclothing.texstre.service.EmailService;
import com.celebclothing.texstre.service.OtpService;
import com.celebclothing.texstre.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String sendOtpSms(@RequestParam String phoneNum) {
        String otp = otpService.generateOtp(phoneNum);
        //smsService.sendOtp(phone, otp);
        return "Your OTP is " + otp + ". Please check your phone.";
    }

    @PostMapping("/send/email")
    public String sendOtpEmail(@RequestParam String email) {
        String otp = otpService.generateOtp(email);
        //emailService.sendOtp(email, otp);
        return "OTP" + otp + " sent to email your email. Please check your email.";
    }

    @PostMapping("/verify")
    public String verifyOtp(@RequestParam String key, @RequestParam String otp) {
        return otpService.validateOtp(key, otp) ? "OTP Verified Successfully." : "Invalid OTP";
    }

}
