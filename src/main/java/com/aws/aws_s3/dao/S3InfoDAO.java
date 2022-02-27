package com.aws.aws_s3.dao;

import com.aws.aws_s3.entity.S3Info;

import java.util.List;

public interface S3InfoDAO {

    //получение инф-ии от AWS S3 Bucket cloudaware-test и сохранение в базу данных aws_db
     void updateS3Info();

    //получение информации из базы данных aws_db
     List<S3Info> getS3InfoFromDB();
}
