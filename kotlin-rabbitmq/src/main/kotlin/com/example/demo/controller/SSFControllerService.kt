package com.example.demo.controller

import com.example.demo.dto.WorkCenter
import com.example.demo.publisher.RabbitMQProducer
import com.example.demo.service.SSFService
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/ssf-service")
class SSFControllerService(
    @Autowired
    var ssfService: SSFService,
    @Autowired
    var rabbitMQProducer: RabbitMQProducer
) {

    @GetMapping("/work-center")
    fun getWorkOrder(): ResponseEntity<List<WorkCenter>> {
        print("Thread name::" + Thread.currentThread())
        var workOrderList = ssfService.fetchWorkOrder()
        var mapper = jacksonObjectMapper()
        var workOrderString = mapper.writeValueAsString(workOrderList)
        rabbitMQProducer.sendMessage(workOrderString)
        var categories = ssfService.fetchCategories()
        var departments = ssfService.fetchDepartment()

        return ResponseEntity(workOrderList, HttpStatus.OK);
    }
}