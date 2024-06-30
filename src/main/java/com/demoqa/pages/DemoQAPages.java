package com.demoqa.pages;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class DemoQAPages {
    protected TextBoxPage textBoxPage;
    protected AlertPage alertPage;
    protected PracticeFormPage practiceFormPage;
    protected CheckBoxPage checkBoxPage;
    protected ButtonsPage buttonsPage;
    protected MenuPage menuPage;
    protected ProgressBarPage progressBarPage;
    protected WebTablesPage webTablesPage;
    protected PracticeFormPageCalendar practiceFormPageCalendar = new PracticeFormPageCalendar();

    public void setUp() {
        textBoxPage = new TextBoxPage();
        alertPage = new AlertPage();
        practiceFormPage = new PracticeFormPage();
        checkBoxPage = new CheckBoxPage();
        buttonsPage = new ButtonsPage();
        menuPage = new MenuPage();
        progressBarPage = new ProgressBarPage();
        webTablesPage = new WebTablesPage();
        practiceFormPageCalendar = new PracticeFormPageCalendar();
    }
}

