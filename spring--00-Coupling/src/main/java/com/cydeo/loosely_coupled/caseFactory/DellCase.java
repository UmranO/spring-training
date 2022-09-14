package com.cydeo.loosely_coupled.caseFactory;

public class DellCase extends Case{

    public DellCase(String model, String manufacturer, String powerSupply) {
        super(model, manufacturer, powerSupply);
    }

    public void pressPowerButton() {

        System.out.println("Power button pressed");
    }
}
