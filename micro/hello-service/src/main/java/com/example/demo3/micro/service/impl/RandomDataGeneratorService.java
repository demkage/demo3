package com.example.demo3.micro.service.impl;

import com.example.demo3.micro.data.AwesomeData;
import com.example.demo3.micro.service.DataGeneratorService;
import org.springframework.stereotype.Service;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by abosii on 7/12/17.
 */
@Service
public class RandomDataGeneratorService implements DataGeneratorService {
    @Override
    public List<AwesomeData> getDataList() {
        try {
            List<AwesomeData> awesomeDataList = new ArrayList<AwesomeData>();

            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            int number = new Random().nextInt(40);

            for(int i = 0; i < number; ++i) {
                awesomeDataList.add(createAwesomeData("get" + i));
            }

            return awesomeDataList;
        } catch (NoSuchAlgorithmException e) {
            return new ArrayList<AwesomeData>();
        }
    }

    @Override
    public AwesomeData deleteData(String message) {
        try {

            return createAwesomeData("delete" + message);
        } catch (NoSuchAlgorithmException e) {
            return  new AwesomeData();
        }
    }

    @Override
    public AwesomeData updateData(String message) {
        try {

            return createAwesomeData("update" + message);
        } catch (NoSuchAlgorithmException e) {
            return  new AwesomeData();
        }
    }

    @Override
    public AwesomeData addData(String message) {
        try {

            return createAwesomeData("add" + message);
        } catch (NoSuchAlgorithmException e) {
            return  new AwesomeData();
        }
    }

    private String hashToString(byte[] hash) {
        return new HexBinaryAdapter().marshal(hash);
    }

    private AwesomeData createAwesomeData(String message) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        int entropy = new Random().nextInt();
        return new AwesomeData(hashToString(messageDigest.digest((message + "1" + entropy).getBytes())),
                hashToString(messageDigest.digest((message + "2" + entropy).getBytes())),
                hashToString(messageDigest.digest((message + "3" + entropy).getBytes())),
                hashToString(messageDigest.digest((message + "4" + entropy).getBytes())));
    }
}
