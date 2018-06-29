package com.drools.springdroolsruleengine.service;

import com.drools.springdroolsruleengine.drools.CompanyRuleService;
import com.drools.springdroolsruleengine.model.SaveCompanyFact;
import com.drools.springdroolsruleengine.model.SaveCompanyRequest;
import com.drools.springdroolsruleengine.model.SaveCompanyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    private CompanyRuleService companyRuleService;

    public SaveCompanyResponse confirmCompanySave(SaveCompanyRequest saveCompanyRequest) {
        // Collect all the data from SaveCompanyRequest model and construct SaveCompanyFact rule/fact model
        SaveCompanyFact saveCompanyFact = new SaveCompanyFact();
        saveCompanyFact.setCategory(saveCompanyRequest.getCategory());
        saveCompanyFact.setGovtRegistrationCode(saveCompanyRequest.getGovtRegistrationCode());
        saveCompanyFact.setNoOfEmployees(saveCompanyRequest.getNoOfEmployees());
        saveCompanyFact.setYearlyTurnOver(saveCompanyRequest.getYearlyTurnOver());
        saveCompanyFact.setYearOfRegistration(saveCompanyRequest.getYearOfRegistration());
        return companyRuleService.consultSaveCompany(saveCompanyFact);
    }
}
