package com.record.database.controller;

import com.record.database.dao.RecordDao;
import com.record.database.dto.request.RecordDto;
import com.record.database.dto.response.ApiResponse;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ReadController {

    @Autowired
    private RecordDao recordDao;

    @PostMapping("records")
    public ResponseEntity<ApiResponse> saveRecords(@RequestBody RecordDto recordDto) {
        ApiResponse apiResponse = recordDao.saveRecords(recordDto);
        return ResponseEntity.ok().body(apiResponse);
    }

    @GetMapping("records")
    public ResponseEntity<ApiResponse> getRecords() {

        RecordDto recordDto = new RecordDto();
        recordDto.setId(56L);
        recordDto.setAge(29);
        recordDto.setFirstName("Mike");
        recordDto.setLastName("Hardy");
        recordDto.setMiddleName("-");
        recordDto.setBillingAddress("45Y Ret Street");
        recordDto.setEmailAddress("abc@test.com");

        return ResponseEntity.ok().body(ApiResponse.builder().message("Sucess").object(recordDto).build());
    }
}
