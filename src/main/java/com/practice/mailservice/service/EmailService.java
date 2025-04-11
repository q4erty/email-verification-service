package com.practice.mailservice.service;

import com.practice.mailservice.dto.Email;

public interface EmailService {
    void sendSimpleEmail(Email email);
}
