package com.malkollm.ElJournalServer.model.response;

import lombok.Data;

@Data
public class CustomerResponse {
    private int id;
    private String customerLocalName;
    private String customerEnglishName;
    private String customerEmail;
    private String customerPhone;
    private String customerAddress;
}
