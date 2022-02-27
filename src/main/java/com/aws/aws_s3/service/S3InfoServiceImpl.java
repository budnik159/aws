package com.aws.aws_s3.service;

import com.aws.aws_s3.dao.S3InfoDAOImpl;
import com.aws.aws_s3.entity.S3Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Service - это специализированный @Component (посредник между dao и controller)
@Service
public class S3InfoServiceImpl implements S3InfoService {

    @Autowired
    private S3InfoDAOImpl s3InfoDAO;

    @Override
    @Transactional
    @Scheduled(initialDelayString = "${scheduler.initialdelay}", fixedRateString = "${scheduler.delay}")
    public void updateS3Info() {
        System.out.println("Update info from AWS S3 Bucket cloudaware-test");
        s3InfoDAO.updateS3Info();
    }

    @Override
    @Transactional
    public List<S3Info> getS3InfoFromDB() {
        return s3InfoDAO.getS3InfoFromDB();
    }
}
