package com.demoqa.entities;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PracticeFormEntity {
    private String firstNameInput;
    private String lastNameInput;
    private String emailInput;
    private String mobileNumberInput;
    private String subjectsContainerInput;
    private String currentAddressInput;
    private String stateInput;
    private String cityInput;
    private String picturePath;
    private String dateOfBirthInput;
    private String monthOfBirthInput;
    private String yearOfBirthInput;
}
