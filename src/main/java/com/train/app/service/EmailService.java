package com.train.app.service;


import com.train.app.model.entity.BaseTicket;

public interface EmailService {

    void createPdfBaseTicket(BaseTicket baseTicket);

    void sendAttachmentEmail();
}
