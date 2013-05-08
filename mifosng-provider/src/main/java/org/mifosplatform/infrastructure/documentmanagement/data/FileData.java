package org.mifosplatform.infrastructure.documentmanagement.data;

import java.io.File;

public class FileData {
    private final File file;
    private final String fileName;
    private final String contentType;

    public FileData(File file, String fileName, String contentType) {
        this.file = file;
        this.fileName = fileName;
        this.contentType = contentType;
    }

    public String contentType() {
        return contentType;
    }

    public String name() {
        return fileName;
    }

    public File file() {
        return file;
    }
}

