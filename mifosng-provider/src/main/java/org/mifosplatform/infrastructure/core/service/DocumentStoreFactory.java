package org.mifosplatform.infrastructure.core.service;

import com.amazonaws.services.s3.AmazonS3Client;
import org.mifosplatform.infrastructure.configuration.domain.ConfigurationDomainService;
import org.mifosplatform.infrastructure.configuration.domain.ExternalServicesDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DocumentStoreFactory {

    private ApplicationContext applicationContext;

    @Autowired
    public DocumentStoreFactory(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public DocumentStore getInstance(){
        DocumentStore documentStore;
        ConfigurationDomainService configurationDomainServiceJpa = applicationContext.getBean("configurationDomainServiceJpa", ConfigurationDomainService.class);
        if(configurationDomainServiceJpa.isAmazonS3Enabled()){
            AmazonS3Client s3Client = applicationContext.getBean("s3ClientFactory", S3ClientFactory.class).getS3Client();
            ExternalServicesDomainService externalServicesDomainService = applicationContext.getBean("externalServicesDomainService", ExternalServicesDomainService.class);
            documentStore = new S3DocumentStore(externalServicesDomainService.getValue("s3_bucket_name"), s3Client);
        }
        else {
            documentStore = new FileSystemDocumentStore();
        }
        return documentStore;
    }
}
