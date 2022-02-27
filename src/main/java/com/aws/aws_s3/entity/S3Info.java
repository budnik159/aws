package com.aws.aws_s3.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="s3info")
public class S3Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "key_id")
    private String keyId;

    @Column(name = "last_modified")
    private Date date;

    @Column(name = "e_tag")
    private String eTag;

    @Column(name = "size")
    private Long size;

    @Column(name = "owner_id")
    private String ownerId;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "storage_class")
    private String storageClass;


    public S3Info() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getETag() {
        return eTag;
    }

    public void setETag(String e_tag) {
        this.eTag = e_tag;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getStorageClass() {
        return storageClass;
    }

    public void setStorageClass(String storageClass) {
        this.storageClass = storageClass;
    }
}
