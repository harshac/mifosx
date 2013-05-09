package org.mifosplatform.portfolio.client.data;

import org.apache.commons.lang.StringUtils;
import org.mifosplatform.infrastructure.core.service.DocumentStoreType;
import org.mifosplatform.infrastructure.core.service.ImageUtils;

import java.io.File;

public class ImageData {

    private final Long clientId;
    private final String key;
    //    private final DocumentStoreType storeType;
    private final String storeType;
    private File file;
    private String contentType;
    private String name;


    public ImageData(Long clientId, String key, String storeType) {
        this.clientId = clientId;
        this.key = key;
        this.storeType = storeType;
    }

    public String imageKey() {
        return this.key;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    private String setImageContentType() {
        String fileName = file.getName();
        String contentType = ImageUtils.IMAGE_MIME_TYPE.JPEG.getValue();
        if (StringUtils.endsWith(fileName, ImageUtils.IMAGE_FILE_EXTENSION.GIF.getValue())) {
            contentType = ImageUtils.IMAGE_MIME_TYPE.GIF.getValue();
        } else if (StringUtils.endsWith(fileName, ImageUtils.IMAGE_FILE_EXTENSION.PNG.getValue())) {
            contentType = ImageUtils.IMAGE_MIME_TYPE.PNG.getValue();
        }
        return contentType;
    }

    public String contentType(){
        return this.contentType;
    }

    public DocumentStoreType storeType() {
        //need to refactor. Get Enum constant from enum value
        if (storeType.equals(DocumentStoreType.FILE_SYSTEM.getValue())) {
            return DocumentStoreType.FILE_SYSTEM;
        } else {
            return DocumentStoreType.S3;
        }
    }

    public String name(){
        return this.file.getName();
    }


}
