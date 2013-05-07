package org.mifosplatform.portfolio.client.data;

public class ImageData {

    private final Long clientId;
    private final String key;
//    private final DocumentStoreType storeType;
    private final String storeType;


    public ImageData(Long clientId, String key, String storeType) {
        this.clientId = clientId;
        this.key = key;
        this.storeType = storeType;
    }

    public String imageKey() {
        return this.key;
    }
}
