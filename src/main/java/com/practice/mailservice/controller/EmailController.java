package com.practice.mailservice.controller;

import com.practice.mailservice.dto.Email;
import com.practice.mailservice.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send-verification")
    public ResponseEntity<String> sendVerification(@RequestBody Email email) {
        emailService.sendSimpleEmail(email);
        return ResponseEntity.ok("Email sent");
    }

}
