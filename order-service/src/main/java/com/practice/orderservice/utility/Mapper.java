package com.practice.orderservice.utility;

import com.practice.orderservice.dto.OrderDto;
import com.practice.orderservice.entity.Order;

public interface Mapper<D, T> {
    OrderDto convertToDepartmentDto(D departmentEntity);

    Order convertToDepartmentEntity(T departmentDto);
}
