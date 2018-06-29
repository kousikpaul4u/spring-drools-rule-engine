package com.drools.springdroolsruleengine.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class SaveCompanyFact {

    private Integer noOfEmployees;

    private BigDecimal yearlyTurnOver;

    private Date yearOfRegistration;

    private String category;

    private String govtRegistrationCode;
}
