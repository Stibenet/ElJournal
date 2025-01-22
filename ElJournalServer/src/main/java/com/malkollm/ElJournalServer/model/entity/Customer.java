package com.malkollm.ElJournalServer.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "customer_local_name", length = 150)
    private String customerLocalName;

    @Column(name = "customer_english_name", length = 150)
    private String customerEnglishName;

    @Column(name = "customer_email", length = 100)
    private String customerEmail;

    @Column(name = "customer_phone", length = 20)
    private String customerPhone;

    @Column(name = "customer_address", length = 20)
    private String customerAddress;
}
