package com.cydeo.caseFactory;

import com.cydeo.config.PcConfig;
import com.cydeo.monitorFactory.Monitor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {

        ApplicationContext container=new AnnotationConfigApplicationContext(PcConfig.class);

        Case theCase=container.getBean(Case.class);
        System.out.println(theCase.getDimensions().getDepth());
    }
}
