package com.drools.springdroolsruleengine.drools;

import com.drools.springdroolsruleengine.config.DroolsConfiguration;
import com.drools.springdroolsruleengine.model.SaveCompanyFact;
import com.drools.springdroolsruleengine.model.SaveCompanyResponse;
import com.drools.springdroolsruleengine.service.CompanyService;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.*;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class CompanyRuleService {

    @Autowired
    private DroolsConfiguration droolsConfiguration;

    @Autowired
    private CompanyService companyService;

    private KnowledgeBase knowledgeBase;

    @PostConstruct
    public void init() {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource(droolsConfiguration.getCompanyRules()), ResourceType.DRL);
        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        if (errors.size() > 0) {
            for (KnowledgeBuilderError error : errors) {
                System.err.println(error);
            }
            throw new IllegalArgumentException("Could not parse knowledge.");
        }
        knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
        knowledgeBase.addKnowledgePackages(kbuilder.getKnowledgePackages());

    }

    public SaveCompanyResponse consultSaveCompany(SaveCompanyFact saveCompanyFact) {
        StatefulKnowledgeSession session = knowledgeBase.newStatefulKnowledgeSession();
        session.insert(saveCompanyFact);
        session.insert(droolsConfiguration);
        session.insert(companyService);
        SaveCompanyResponse result = new SaveCompanyResponse();
        session.insert(result);
        session.fireAllRules();
        session.dispose();
        return result;
    }

}
