package com.berlincoders.romeo.photoz.clone;

import jakarta.validation.constraints.NotEmpty;

public class Photo {

    private String id;

    @NotEmpty
    private String FileName;

    //raw data

    // empty constructor
    public Photo() {
    }
    // constructor
    public Photo(String id, String fileName) {
        this.id = id;
        FileName = fileName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }
}
