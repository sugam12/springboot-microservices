package com.example.demo.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class WorkCenters(
    @JsonProperty("workcentres")
    val workCenterList: List<WorkCenter>
) {
}