package com.record.database.entity;

import com.record.database.dto.request.RecordDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_RECORDS")
@Data
@NoArgsConstructor
public class RecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String middleName;
    private String preferredName;
    private String nickName;
    private int age;
    private String emailAddress;
    private String billingAddress;


    public RecordEntity(RecordDto recordDto) {
        this.age = recordDto.getAge();
        this.firstName = recordDto.getFirstName();
        this.lastName = recordDto.getLastName();
        this.middleName = recordDto.getMiddleName();
        this.billingAddress = recordDto.getBillingAddress();
       // this.id = recordDto.getId();
        this.nickName = recordDto.getNickName();
        this.emailAddress = recordDto.getEmailAddress();
    }
}
