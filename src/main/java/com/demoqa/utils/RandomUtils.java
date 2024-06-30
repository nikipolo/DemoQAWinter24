package com.demoqa.utils;

import com.demoqa.entities.EmployeeEntity;
import com.demoqa.entities.PracticeFormEntity;
import com.demoqa.entities.TextBoxEntity;
import com.github.javafaker.Faker;

public class RandomUtils {
    Faker faker = new Faker();

    public TextBoxEntity generateRandomTextBoxEntity() {
        TextBoxEntity textBoxEntity = new TextBoxEntity();
        textBoxEntity.setFullName(faker.name().fullName());
        textBoxEntity.setEmail(faker.internet().emailAddress());
        textBoxEntity.setCurrentAddress(faker.address().fullAddress());
        textBoxEntity.setPermanentAddress(faker.address().secondaryAddress());
        return textBoxEntity;
    }

    public PracticeFormEntity generateRandomPracticeFormEntity() {
        PracticeFormEntity practiceFormEntity = new PracticeFormEntity();
        practiceFormEntity.setFirstNameInput(faker.name().firstName());
        practiceFormEntity.setLastNameInput(faker.name().lastName());
        practiceFormEntity.setEmailInput(faker.internet().emailAddress());
        practiceFormEntity.setMobileNumberInput(faker.phoneNumber().subscriberNumber(10));
        practiceFormEntity.setMonthOfBirthInput("March");
        practiceFormEntity.setYearOfBirthInput("2024");
        practiceFormEntity.setSubjectsContainerInput("Math");
        practiceFormEntity.setCurrentAddressInput(faker.address().fullAddress());
        practiceFormEntity.setStateInput("Uttar");
        practiceFormEntity.setCityInput("Agra");
        practiceFormEntity.setPicturePath("C:\\Users\\Aidana\\Pictures\\Saved Pictures\\o-o.jpeg");
        return practiceFormEntity;
    }

    public EmployeeEntity createMockEmployee() {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setFirstname(faker.name().firstName());
        employeeEntity.setLastname(faker.name().lastName());
        employeeEntity.setAge(faker.number().numberBetween(18, 100));

        employeeEntity.setEmail(faker.internet().emailAddress());
//        employeeEntity.setEmail("kierra@example.com"); // Специально прошу ввести уже существующий email,
        // чтобы проверить работу метода addNewEmployee

        employeeEntity.setSalary(faker.number().numberBetween(3000000, 4000000));
        employeeEntity.setDepartment(faker.job().position());

        return employeeEntity;
    }
}
