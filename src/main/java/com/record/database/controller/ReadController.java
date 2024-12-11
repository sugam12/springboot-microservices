package com.record.database.controller;

import com.record.database.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ReadController {

    @GetMapping("test")
    public ResponseEntity<ApiResponse> getResponse(){
        return ResponseEntity.ok().body(ApiResponse.builder().message("Test response").build());
    }
}
