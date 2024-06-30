import com.demoqa.entities.EmployeeEntity;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest extends BaseTest{
    @BeforeClass
    public void set() {
        driver.get("https://demoqa.com/webtables");
    }


    @Test(groups = {"E2E","4554"},description = "Web Tables Test")
    public void addNewEmployeeTest() throws InterruptedException {
// Вызов метода добавления нового сотрудника с прoверкой email
        demoQAPages.getWebTablesPage().addNewEmployee(randomUtils.createMockEmployee());
//        webElementActions.scrollToElement(demoQAPages.getWebTablesPage().addNewBtn);
        Thread.sleep(6000);
    }


    @Test
    public void getListOfEmployeesTest() throws InterruptedException {
// Вызов метода получения списка всех сотрудников и вывода на консоль
        List<EmployeeEntity> employeeEntities = demoQAPages.getWebTablesPage().getEmployeesFromTable();
        for (EmployeeEntity employeeEntity : employeeEntities) {
            System.out.println(employeeEntity);
        }
        Thread.sleep(5000);
    }


    @Test
    public void editDataTest() throws InterruptedException {
        // Создание объекта EmployeeEntity с новыми данными
        // Объект newEmployeeData нужно создавать именно перед вызовом метода editEmployeeData, так как этот объект содержит данные,
        // которые я хочу изменить
        EmployeeEntity newEmployeeData = new EmployeeEntity();
        newEmployeeData.setAge(35);
        newEmployeeData.setLastname("Ivanov");
        // остальные поля могут быть null, если их не нужно менять

        // Вызов метода для редактирования
        demoQAPages.getWebTablesPage().editEmployeeData("alden@example.com", newEmployeeData);
        Thread.sleep(2000);

        // Вызов метода getListOfEmployeesTest, чтобы увидеть в консоли результат редактирования
        List<EmployeeEntity> employeeEntities = demoQAPages.getWebTablesPage().getEmployeesFromTable();
        for (EmployeeEntity employeeEntity : employeeEntities) {
            System.out.println(employeeEntity);
        }
        Thread.sleep(2000);
    }

    @Test
    public void deleteEmployeeTest() throws InterruptedException {
        // Вызов метода для удаления сотрудника
        demoQAPages.getWebTablesPage().deleteEmployee("alden@example.com");
        Thread.sleep(2000);

        // Вызов метода getListOfEmployeesTest, чтобы увидеть в консоли результат удвления сотрудника
        List<EmployeeEntity> employeeEntities = demoQAPages.getWebTablesPage().getEmployeesFromTable();
        for (EmployeeEntity employeeEntity : employeeEntities) {
            System.out.println(employeeEntity);
        }
        Thread.sleep(2000);

    }

}
