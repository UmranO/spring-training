package com.cydeo.stereotype_annotation.caseFactory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@AllArgsConstructor
public abstract class Case {

    private String model;
    private String manufacturer;
    private String powerSupply;

   // when you have only 1 constructor even if  is done through AllArgsConstructor you don't even have to write @Autowired
    private Dimensions dimensions;

        //  If you have only 1 constructor you don't even have to write @Autowired
        //  public Case(String model, String manufacturer, String powerSupply) {
        //  this.model = model;
        //  this.manufacturer = manufacturer;
        //  this.powerSupply = powerSupply;
        //  }

    public abstract void pressPowerButton();

}