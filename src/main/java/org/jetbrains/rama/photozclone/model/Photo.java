package org.jetbrains.rama.photozclone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("PHOTOS")
public class Photo {
    @Id
    private Integer id;

    private String fileName;
    @JsonIgnore
    private byte[] data;
    private String contentType;
    public Photo() {
    }

    public Photo(Integer id, String fileName, byte[] data, String contentType) {
        this.id = id;
        this.fileName = fileName;
        this.data = data;
        this.contentType = contentType;
    }



    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
