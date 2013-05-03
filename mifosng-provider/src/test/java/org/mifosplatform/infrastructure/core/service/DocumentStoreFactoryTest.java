package org.mifosplatform.infrastructure.core.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mifosplatform.infrastructure.configuration.domain.ConfigurationDomainService;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SuppressWarnings("unused")

@RunWith(MockitoJUnitRunner.class)
public class DocumentStoreFactoryTest {

    @Test
    public void shouldReturnS3DocumentStoreObjectIfS3Enabled(){
        ConfigurationDomainService configurationDomainService = mock(ConfigurationDomainService.class);
        when(configurationDomainService.isAmazonS3Enabled()).thenReturn(true);

        DocumentStoreFactory documentStoreFactory= new DocumentStoreFactory(configurationDomainService);
        assertEquals(documentStoreFactory.getInstance().getClass(),S3DocumentStore.class);
    }

    @Test
    public void shouldReturnFileSystemDocumentStoreObjectIfS3IsDisabled(){
        ConfigurationDomainService configurationDomainService = mock(ConfigurationDomainService.class);
        when(configurationDomainService.isAmazonS3Enabled()).thenReturn(false);

        DocumentStoreFactory documentStoreFactory= new DocumentStoreFactory(configurationDomainService);
        assertEquals(documentStoreFactory.getInstance().getClass(),FileSystemDocumentStore.class);
    }


}
