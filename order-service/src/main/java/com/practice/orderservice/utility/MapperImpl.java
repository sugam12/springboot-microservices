package com.practice.orderservice.utility;

import com.practice.orderservice.dto.OrderDto;
import com.practice.orderservice.entity.Order;
import org.springframework.stereotype.Service;

@Service
public class MapperImpl implements Mapper {
    @Override
    public OrderDto convertToDepartmentDto(Object departmentEntity) {
        return null;
    }

    @Override
    public Order convertToDepartmentEntity(Object departmentDto) {
        return null;
    }
}
