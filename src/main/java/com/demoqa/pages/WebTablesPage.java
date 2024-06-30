package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import com.demoqa.entities.EmployeeEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WebTablesPage extends BasePage {
    @FindBy(id = "addNewRecordButton")
    public WebElement addNewBtn;

    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "age")
    public WebElement ageInput;

    @FindBy(id = "userEmail")
    public WebElement emailInput;

    @FindBy(id = "salary")
    public WebElement salaryInput;

    @FindBy(id = "department")
    public WebElement departmentInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;


    // МЕТОД ДЛЯ ДОБАВЛЕНИЯ нового сотрудника с проверкой на отсутствие похожего email адреса
    public WebTablesPage addNewEmployee(EmployeeEntity employeeEntity) {
        // Получаем всех сотрудников из таблицы
        List<EmployeeEntity> existingEmployees = getEmployeesFromTable();
// Перебираем каждого сотрудника через цикл
        for (EmployeeEntity item : existingEmployees) {
            // Если находим сотрудника с таким же email, выводим сообщение и выходим из метода
            if (item.getEmail().equals(employeeEntity.getEmail())) {
                System.out.println("Employee with email " + employeeEntity.getEmail() + " already exists.");
                return this;
            }
        }
        // Если мы дошли до этой точки, значит, нет сотрудника с таким же email, добавляем нового
        webElementActions.click(addNewBtn)
                .sendKeys(firstNameInput, employeeEntity.getFirstname())
                .sendKeys(lastNameInput, employeeEntity.getLastname())
                .sendKeys(ageInput, String.valueOf(employeeEntity.getAge()))
                .sendKeys(emailInput, employeeEntity.getEmail())
                .sendKeys(salaryInput, String.valueOf(employeeEntity.getSalary()))
                .sendKeys(departmentInput, employeeEntity.getDepartment())
                .click(submitBtn);
        return this;
    }


    // МЕТОД ДЛЯ ПОЛУЧЕНИЯ СПИСКА всех сотрудников со всеми данными
    public ArrayList<EmployeeEntity> getEmployeesFromTable() {
        // Получаем список всех ячеек таблицы (rows) с помощью селектора CSS
        // В этом листе "rows" хранится одна строка со всеми данными сотрудника
        List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable .rt-tr-group")); //10

        // Создаем пустой список для хранения объектов EmployeeEntity
        ArrayList<EmployeeEntity> employeeEntities = new ArrayList<>();

        // Перебираем каждую ячейку таблицы
        for (WebElement row : rows) {
            // Получаем все ячейки (cells) текущей строки с помощью селектора CSS
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));

            // Извлекаем текст из каждой ячейки и сохраняем в переменные
            String firstName = cells.get(0).getText();
            String lastName = cells.get(1).getText();
            // Извлекаем текст и удаляем все символы, которые не являются цифрами
            String ageText = cells.get(2).getText().replaceAll("[^0-9]", "");
            String email = cells.get(3).getText();
            // Извлекаем текст и удаляем все символы, которые не являются цифрами
            String salaryText = cells.get(4).getText().replaceAll("[^0-9]", "");
            String department = cells.get(5).getText();

            // Если любая из строк (полей) пустая, пропускаем текущую итерацию
            if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty() || email.isEmpty() || salaryText.isEmpty() || department.isEmpty()) {
                continue;
            }
            int age = Integer.parseInt(ageText.trim());
            long salary = Long.parseLong(salaryText.trim());

            // Создаем новый объект EmployeeEntity и добавляем его в список employeeEntities
            employeeEntities.add((new EmployeeEntity(firstName, lastName, age, email, salary, department)));

        }
        // Возвращаем список объектов EmployeeEntity
        return employeeEntities;
    }


    // МЕТОД ДЛЯ РЕДАКТИРОВАНИЯ данных сотрудника
    public WebTablesPage editEmployeeData(String email, EmployeeEntity newEmployeeData) throws InterruptedException {
// Получаем всех сотрудников из таблицы
        List<EmployeeEntity> existingEmployees = getEmployeesFromTable();

// Флаг для определения, был ли найден сотрудник с заданным email
        boolean emailFound = false;
// Перебираем каждого сотрудника через цикл for с использованием индекса,чтобы найти сотрудника с задан.email
        for (int i = 0; i < existingEmployees.size(); i++) {
            // Если email сотрудника совпадает с переданным значением
            if (existingEmployees.get(i).getEmail().equals(email)) {
                // Находим кнопку редактирования для строки с соответствующим индексом
                WebElement editBtn = DriverManager.getDriver().findElement(By.cssSelector("#edit-record-" + i));
                webElementActions.click(editBtn);
                // Устанавливаем флаг, что сотрудник был найден
                emailFound = true;

                // Заполняем форму новыми данными из объекта newEmployeeData, если поле не null
                if (newEmployeeData.getFirstname() != null) {
                    webElementActions.clearAndSendKeys(firstNameInput, newEmployeeData.getFirstname());
                }
                if (newEmployeeData.getLastname() != null) {
                    webElementActions.clearAndSendKeys(lastNameInput, newEmployeeData.getLastname());
                }
                if (newEmployeeData.getAge() != 0) {
                    webElementActions.clearAndSendKeys(ageInput, String.valueOf(newEmployeeData.getAge()));
                }
                if (newEmployeeData.getEmail() != null) {
                    webElementActions.clearAndSendKeys(emailInput, newEmployeeData.getEmail());
                }
                if (newEmployeeData.getSalary() != 0) {
                    webElementActions.clearAndSendKeys(salaryInput, String.valueOf(newEmployeeData.getSalary()));
                }
                if (newEmployeeData.getDepartment() != null) {
                    webElementActions.clearAndSendKeys(departmentInput, newEmployeeData.getDepartment());
                }
                webElementActions.click(submitBtn); // Нажимаем кнопку отправки, чтобы сохранить изменения
                break;  // Прерываем цикл после нахождения и редактирования нужного сотрудника
            }
        }
        // Если сотрудник с заданным email не найден, то выбрасывае исключение
        if (!emailFound){
            throw new IllegalArgumentException("Сотрудник с email " + email + " не найден.");
        }
        return this; // Возвращаем текущий объект WebTablesPage для цепочки вызовов методов
    }


    // МЕТОД ДЛЯ УДАЛЕНИЯ сотрудника
    public WebTablesPage deleteEmployee(String email) {
        List<EmployeeEntity> existingEmployees = getEmployeesFromTable();

        // Флаг для определения найден ли сотрудник с заданным email
        boolean emailFound = false;

        // Перебираем каждого сотрудника через цикл for с использованием индекса,чтобы найти сотрудника с задан.email
        for (int i = 0; i < existingEmployees.size(); i++) {
            // Если email сотрудника совпадает с переданным значением
            if (existingEmployees.get(i).getEmail().equals(email)) {
                // Находим кнопку редактирования для строки с соответствующим индексом
                WebElement deleteBtn = DriverManager.getDriver().findElement(By.xpath("//span[@id='delete-record-" + i + "']"));
                webElementActions.click(deleteBtn);
                emailFound = true;
                break;
            }
        }
        // Если сотрудник с заданным email не найден, то выбрасывае исключение
        if (!emailFound) {
            throw new IllegalArgumentException("Сотрудник с email " + email + " не найден.");
        }
        return this; // Возвращаем текущий объект WebTablesPage для цепочки вызовов методов
    }
}
