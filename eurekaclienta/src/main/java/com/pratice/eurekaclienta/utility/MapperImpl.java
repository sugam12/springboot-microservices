package com.pratice.eurekaclienta.utility;

import com.pratice.eurekaclienta.dto.DepartmentDto;
import com.pratice.eurekaclienta.entity.Department;
import org.springframework.stereotype.Service;

@Service
public class MapperImpl implements Mapper {
    @Override
    public DepartmentDto convertToDepartmentDto(Object departmentEntity) {
        return null;
    }

    @Override
    public Department convertToDepartmentEntity(Object departmentDto) {
        return null;
    }
}
