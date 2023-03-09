package com.noirix.domain;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class User {

    private Long id;

    private String name;

    private String surname;

    private Timestamp birthDate;

    private String fullName;

    private Double weight;

//    @Override
//    public String toString() {
////        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
//    }
}
