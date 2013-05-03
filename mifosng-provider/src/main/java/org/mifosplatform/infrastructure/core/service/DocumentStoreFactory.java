package org.mifosplatform.infrastructure.core.service;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import org.mifosplatform.infrastructure.configuration.domain.ConfigurationDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DocumentStoreFactory {

    private ConfigurationDomainService configurationDomainServiceJpa;

    @Autowired
    public DocumentStoreFactory(ConfigurationDomainService configurationDomainService) {
        this.configurationDomainServiceJpa = configurationDomainService;
    }

    public DocumentStore getInstance(){
        DocumentStore documentStore;
        if(this.configurationDomainServiceJpa.isAmazonS3Enabled()){
            AmazonS3Client s3Client = new AmazonS3Client(new BasicAWSCredentials("access_key", "secret_key"));
            documentStore = new S3DocumentStore("bucket_name", s3Client);
        }
        else {
            documentStore = new FileSystemDocumentStore();
        }
        return documentStore;
    }
}
