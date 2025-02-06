package com.example.demo.dto

data class WorkCenter(
    private var workcentreId: String,

    val workcentre: String,

    val departmentId: String,

    val department: String,

    val categoryId: String,

    val categoryName: String,

    val tag: String,

    val categoryTag: String?
)
