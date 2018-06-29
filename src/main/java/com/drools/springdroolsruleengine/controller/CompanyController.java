package com.drools.springdroolsruleengine.controller;

import com.drools.springdroolsruleengine.model.SaveCompanyRequest;
import com.drools.springdroolsruleengine.model.SaveCompanyResponse;
import com.drools.springdroolsruleengine.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveCompany(@Valid @RequestBody SaveCompanyRequest saveCompanyRequest) {
        try {
            SaveCompanyResponse saveCompanyResponse = companyService.confirmCompanySave(saveCompanyRequest);
            return new ResponseEntity<>(saveCompanyResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
