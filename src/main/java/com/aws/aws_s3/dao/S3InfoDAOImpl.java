package com.aws.aws_s3.dao;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.aws.aws_s3.entity.S3Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

//@Repository - разновидность @Component
@Repository
public class S3InfoDAOImpl implements S3InfoDAO {

    // Используем функционал JPA - EntityManager.
    // entityManager создается автоматически (его бин нигде не описываю)
    @Autowired
    private EntityManager entityManager;

    String bucket_name = "cloudaware-test";
    final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).build();

    @Override
    public void updateS3Info() {

        List<S3ObjectSummary> result = s3.listObjectsV2(bucket_name).getObjectSummaries();

        entityManager.createQuery("DELETE from S3Info").executeUpdate();
        for (S3ObjectSummary el : result) {
            S3Info s3Info = new S3Info();
            s3Info.setKeyId(el.getKey());
            s3Info.setDate(el.getLastModified());
            s3Info.setETag(el.getETag());
            s3Info.setSize(el.getSize());

            //TODO el.getOwner() по какой-то причине всегда null
            s3Info.setOwnerId("XX");//(el.getOwner().getId());
            s3Info.setDisplayName("XX");//el.getOwner().getDisplayName()
            s3Info.setStorageClass(el.getStorageClass());
            //метод merge() для entityManager из JPA аналогичен методу saveOrUpdate() для session из Hibernate
            entityManager.merge(s3Info);

        }

    }

    @Override
    public List<S3Info> getS3InfoFromDB() {
        // функционал JPA

        Query query = entityManager.createQuery("from S3Info");
        List<S3Info> allS3Info = query.getResultList();
        return allS3Info;

    }


}
