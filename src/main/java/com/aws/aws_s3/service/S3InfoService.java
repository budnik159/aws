package com.aws.aws_s3.service;

import com.aws.aws_s3.entity.S3Info;

import java.util.List;

public interface S3InfoService {

     void updateS3Info();
     List<S3Info> getS3InfoFromDB();
}
