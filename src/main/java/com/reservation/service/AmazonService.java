package com.reservation.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import com.reservation.dto.UserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AmazonService {


    private static final String FILENAME = "/tmp/costumer_data.csv";

    @Value("${amazonProperties.endpointUrl}")
    private String endpointUrl;
    @Value("${amazonProperties.bucketName}")
    private String bucketName;
    @Value("${amazonProperties.accessKey}")
    private String accessKey;
    @Value("${amazonProperties.secretKey}")
    private String secretKey;

    public List<UserDto> readAndWriteFile() throws IOException {
        AmazonS3 s3client = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.SA_EAST_1)
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
                .build();

        S3ObjectInputStream s3is = s3client.getObject(bucketName, "customer/customer_data.csv").getObjectContent();
        FileOutputStream fos = writeFile(s3is);
        List<UserDto> users = readUsersFromFile();

        s3is.close();
        fos.close();
        return users;
    }

    private FileOutputStream writeFile(S3ObjectInputStream s3is) throws IOException {
        FileOutputStream fos = new FileOutputStream(new File(FILENAME));
        byte[] read_buf = new byte[1024];
        int read_len = 0;
        while ((read_len = s3is.read(read_buf)) > 0) {
            fos.write(read_buf, 0, read_len);
        }
        return fos;
    }

    private List<UserDto> readUsersFromFile() {
        try {
            List<UserDto> users = new ArrayList<UserDto>();
            BufferedReader reader = new BufferedReader(new FileReader(new File(FILENAME)));

           String line = reader.readLine();
           while ((line = reader.readLine()) != null) {
               line = line.concat(";");
               String[] columns = line.split(";");
               users.add(new UserDto(columns[0],columns[1],columns[2], defineActive(columns[3])));
           }
            reader.close();
            return users;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private Boolean defineActive(String column) {
        return column.equalsIgnoreCase("0") ? Boolean.TRUE : Boolean.FALSE;
    }

}
