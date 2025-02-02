package com.malkollm.ElJournalServer.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CustomerRequest {
    @Length(min = 3, max = 150)
    @NotBlank(message = "Local name is mandatory")
    private String customerLocalName;

    @Length(min = 3, max = 150)
    @NotBlank(message = "English name is mandatory")
    private String customerEnglishName;

    @Length(min = 3, max = 99)
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Invalid Email address")
    private String customerEmail;

    @Length(min = 3, max = 150)
    @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$", message = "Invalid Phone number format")
    private String customerPhone;
    private String customerAddress;
}
