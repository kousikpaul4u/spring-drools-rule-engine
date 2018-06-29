package com.drools.springdroolsruleengine.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class SaveCompanyRequest {

    @NotBlank(message = "name should not be null")
    private String name;

    @NotNull(message = "no-of-employees should not be null")
    private Integer noOfEmployees;

    @NotNull(message = "yearly-turn-over should not be null")
    private BigDecimal yearlyTurnOver;

    @NotNull(message = "year-of-registration should not be null")
    private Date yearOfRegistration;

    @NotBlank(message = "category should not be null")
    private String category;

    private String govtRegistrationCode;
}
