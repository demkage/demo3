package com.example.demo3.micro.service;

import com.example.demo3.micro.data.AwesomeData;

import java.util.List;

/**
 * Created by abosii on 7/12/17.
 */
public interface DataGeneratorService {
    List<AwesomeData> getDataList();

    AwesomeData deleteData(String message);

    AwesomeData updateData(String message);

    AwesomeData addData(String message);

}
