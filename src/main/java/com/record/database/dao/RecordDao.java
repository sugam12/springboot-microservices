package com.record.database.dao;

import com.record.database.dto.request.RecordDto;
import com.record.database.dto.response.ApiResponse;
import com.record.database.entity.RecordEntity;
import com.record.database.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordDao {

    @Autowired
    private RecordRepository recordRepository;

    public ApiResponse saveRecords(RecordDto recordDto) {
        RecordEntity record = new RecordEntity(recordDto);
        recordRepository.save(record);

        ApiResponse apiResponse = ApiResponse.builder().message("Records save sucess").build();
        return apiResponse;


    }
}
