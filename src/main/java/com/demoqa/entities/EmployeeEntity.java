package com.demoqa.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class EmployeeEntity {
    private String firstname;
    private String lastname;
    private int age;
    private String email;
    private long salary;
    private String department;
}
