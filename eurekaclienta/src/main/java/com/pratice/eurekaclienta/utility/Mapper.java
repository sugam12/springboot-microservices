package com.pratice.eurekaclienta.utility;

import com.pratice.eurekaclienta.dto.DepartmentDto;
import com.pratice.eurekaclienta.entity.Department;

public interface Mapper<D, T> {
    DepartmentDto convertToDepartmentDto(D departmentEntity);

    Department convertToDepartmentEntity(T departmentDto);
}
