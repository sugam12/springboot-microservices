package com.example.demo.service

import com.example.demo.dto.*
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class SSFService(
    @Autowired
    var restTemplate: RestTemplate
) {
    fun fetchWorkOrder(): List<WorkCenter> {

        val headers = org.springframework.http.HttpHeaders()
        headers.add("apiKey", "a29c93bee9ed46b42f35fefa38f9ae6ed17a4da9")
        // headers["If-Modified-Since"] = "2024-07-24T03:16:55+00:00"
        val entity = HttpEntity<Any>(headers)

        val response = restTemplate.exchange(
            "https://api-dev133.smartshopfloor.cloud/api/2.0/getAllWorkcentres",
            HttpMethod.GET,
            entity,
            String::class.java
        )
        var body: String = response.body.toString()
        println(response)
        val mapper = jacksonObjectMapper()
        try {

            /*  var jsonString = """{"id":1,"description":"Test"}""";
              var testModel = mapper.fromJson(jsonString, WorkCenters::class.java)*/

            val workCenter = mapper.readValue(body, WorkCenters::class.java)
            return workCenter.workCenterList;
        } catch (exception: Exception) {
            exception.printStackTrace()
        }

        return mutableListOf();
    }

    fun fetchCategories(): List<Category> {

        val headers = org.springframework.http.HttpHeaders()
        headers.add("apiKey", "a29c93bee9ed46b42f35fefa38f9ae6ed17a4da9")
        // headers["If-Modified-Since"] = "2024-07-24T03:16:55+00:00"
        val entity = HttpEntity<Any>(headers)

        val response = restTemplate.exchange(
            "https://api-dev133.smartshopfloor.cloud/api/2.0/getCategories",
            HttpMethod.GET,
            entity,
            String::class.java
        )
        var body: String = response.body.toString()
        println(response)
        val mapper = jacksonObjectMapper()
        try {

            /*  var jsonString = """{"id":1,"description":"Test"}""";
              var testModel = mapper.fromJson(jsonString, WorkCenters::class.java)*/

            val categories = mapper.readValue(body, Categories::class.java)
            return categories.categories;
        } catch (exception: Exception) {
            exception.printStackTrace()
        }

        return mutableListOf();

    }

    fun fetchDepartment(): List<Department> {

        val headers = org.springframework.http.HttpHeaders()
        headers.add("apiKey", "a29c93bee9ed46b42f35fefa38f9ae6ed17a4da9")
        // headers["If-Modified-Since"] = "2024-07-24T03:16:55+00:00"
        val entity = HttpEntity<Any>(headers)

        val response = restTemplate.exchange(
            "https://api-dev133.smartshopfloor.cloud/api/2.0/getAllDepartments",
            HttpMethod.GET,
            entity,
            String::class.java
        )
        var body: String = response.body.toString()
        println(response)
        val mapper = jacksonObjectMapper()
        try {

            /*  var jsonString = """{"id":1,"description":"Test"}""";
              var testModel = mapper.fromJson(jsonString, WorkCenters::class.java)*/

            val departments = mapper.readValue(body, Departments::class.java)
            return departments.departments;
        } catch (exception: Exception) {
            exception.printStackTrace()
        }

        return mutableListOf();

    }
}