package com.malkollm.ElJournalServer.model.request;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CustomerRequest {
    private String customerLocalName;
    private String customerEnglishName;
    private String customerEmail;
    private String customerPhone;
    private String customerAddress;
}
