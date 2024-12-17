package com.record.database.dto.request;

import lombok.Data;

@Data
public class RecordDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String preferredName;
    private String nickName;
    private int age;
    private String emailAddress;
    private String billingAddress;
}
