package com.cydeo.bean_annotation;


import com.cydeo.bean_annotation.caseFactory.DellCase;
import com.cydeo.bean_annotation.configuration.ComputerConfig;
import com.cydeo.bean_annotation.monitorFactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardFactory.AsusMotherboard;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {

    public static void main(String[] args) {

        System.out.println("Creating Container");

        //Creating container by using Application Context
        ApplicationContext container = new AnnotationConfigApplicationContext(ComputerConfig.class);

        //Creating container by using BeanFactory
        BeanFactory context = new AnnotationConfigApplicationContext();

        System.out.println("************Retrieving the beans******************");

        SonyMonitor sony = container.getBean(SonyMonitor.class);
        DellCase dell = container.getBean(DellCase.class);
        AsusMotherboard asus = container.getBean(AsusMotherboard.class);

        PC myPc = new PC(dell,sony,asus);

        myPc.powerUp();


    }
}
