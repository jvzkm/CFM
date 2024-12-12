package com.train.app.api.controllers;

import com.train.app.model.dto.EmailTicketInformation;
import com.train.app.util.email.EmailSenderService;
import com.train.app.util.email.PDFService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/train-api/email")
public class EmailController {

    private final EmailSenderService emailService;

    @PostMapping("/send")
    void sendEmail(@RequestParam String reciver, @RequestParam String message) {
        emailService.sendSimpleEmail(reciver, message);
    }

    @PostMapping(value = "/sendFile")
    void sendEmailWithAttachment(@RequestBody EmailTicketInformation info) {

        Map<String, String> placeholders = getStringStringMap(info);

        String outputPdfPath = createPDF(info, placeholders);

        emailService.sendMailWithAttachment(info.travelerEmail(), "TICKET", "TICKETS", outputPdfPath);

    }

    private static String createPDF(EmailTicketInformation info, Map<String, String> placeholders) {
        String outputPdfPath = "src/main/java/com/app/train/model/trash/EmailCompartiment/ticketTemplates/ticketsPdf/" + info.ticketID() + ".pdf";
        String templatePath = "src/main/java/com/app/train/model/trash/EmailCompartiment/ticketTemplates/testTemplate.html";

        try {
            PDFService.generatePdf(templatePath, outputPdfPath, placeholders);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return outputPdfPath;

    }

    private static Map<String, String> getStringStringMap(EmailTicketInformation info) {
        Map<String, String> placeholders = new HashMap<>();

        placeholders.put("class", info.ticket_class());
        placeholders.put("ticket_id", "" + info.ticketID());
        placeholders.put("train_id", "" + info.train_id());
        placeholders.put("seat", "" + info.seat());
        placeholders.put("vagon", "" + info.vagon());
        placeholders.put("pas_type", info.person_type());
        placeholders.put("st_date", info.boardDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        placeholders.put("st_stat", info.boardStation());
        placeholders.put("end_stat", info.endStation());
        placeholders.put("end_date", info.endDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        placeholders.put("price", "" + info.price());
        placeholders.put("val", info.curency());
        placeholders.put("valid", info.boardDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return placeholders;
    }
}


