package com.util;


import org.springframework.stereotype.Repository;

/**
 * @author zx
 * @Company ydtf
 * @date 2020/8/4 11:50
 */
@Repository
public class FileBean {
    String newname="";
    String originalFilename="";
    String uri="";

    public String getNewname() {
        return newname;
    }

    public void setNewname(String newname) {
        this.newname = newname;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
