package com.cydeo.bean_annotation.configuration;

import com.cydeo.bean_annotation.caseFactory.Case;
import com.cydeo.bean_annotation.caseFactory.DellCase;
import com.cydeo.bean_annotation.monitorFactory.AcerMonitor;
import com.cydeo.bean_annotation.monitorFactory.Monitor;
import com.cydeo.bean_annotation.monitorFactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardFactory.AsusMotherboard;
import com.cydeo.bean_annotation.motherboardFactory.Motherboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComputerConfig {

    @Bean
    public Monitor monitorSony(){

        return new SonyMonitor("25 inch Beast","Sony",25);
    }
   /* @Bean
    public Monitor monitorAcer(){
        return new AcerMonitor("23 inch Beast","Acer",23);
    }*/

    @Bean
    public Case caseDell(){
        return new DellCase("220B","Dell","240");
    }

    @Bean
    public Motherboard motherboardAsus(){
        return new AsusMotherboard("BJ-200","Asus",4,6,"v2.44");
    }

}


