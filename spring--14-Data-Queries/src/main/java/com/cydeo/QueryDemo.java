package com.cydeo;

import com.cydeo.repository.CourseRepository;
import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final CourseRepository courseRepository;

    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, CourseRepository courseRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-----------REGIONS-----------");

        System.out.println("findByCountry:" + regionRepository.findByCountry("Canada"));
        System.out.println("---------------------------------------------------------------");
        System.out.println("findByCountryContaining:" + regionRepository.findByCountryContains("United"));
        System.out.println("findByCountryContainsOrderByRegion:" + regionRepository.findByCountryContainsOrderByRegion("United"));
        System.out.println("---------------------------------------------------------------");
        System.out.println("findTop2ByCountry:" + regionRepository.findTop2ByCountry("United States"));
        System.out.println("findTop3ByCountry:" + regionRepository.findTop3ByCountry("United States"));
        System.out.println("---------------------------------------------------------------");
        System.out.println("findTopByCountryContainsOrderByRegion:" + regionRepository.findTopByCountryContainsOrderByRegion("United States"));

        System.out.println("-----------DEPARTMENTS----------");

        System.out.println("findByDepartment:" + departmentRepository.findByDepartment("Furniture"));
        System.out.println("---------------------------------------------------------------");
        System.out.println("findByDivision:" + departmentRepository.findByDivision("Health"));
        System.out.println("---------------------------------------------------------------");
        System.out.println("findByDivisionEndsWith:" + departmentRepository.findByDivisionIsEndingWith("ics"));
        System.out.println("---------------------------------------------------------------");
        System.out.println("findDistinctTop3ByDivisionContains:" + departmentRepository.findDistinctTop3ByDivisionContains("Hea"));
        System.out.println("findDistinctTop2ByDivisionContains:" + departmentRepository.findDistinctTop2ByDivisionContains("Hea"));
        System.out.println("---------------------------------------------------------------");

        System.out.println("-----------EMPLOYEES----------");
        System.out.println(employeeRepository.retrieveEmployeeDetail());
        System.out.println("---------------------------------------------------------------");
        System.out.println(employeeRepository.retrieveEmployeeSalary());

        System.out.println("-----------COURSES------------");
        System.out.println(courseRepository.findByCategoryOrderByName("Spring"));
        System.out.println("---------------------------------------------------------------");
        System.out.println(courseRepository.existsCourseByName("Rapid Spring Boot Application Development"));
        System.out.println("---------------------------------------------------------------");
        System.out.println(courseRepository. countByCategory("Spring"));
        System.out.println("---------------------------------------------------------------");
        System.out.println(courseRepository.findByNameStartingWith("Rapid"));
        System.out.println("---------------------------------------------------------------");
        System.out.println(courseRepository.findByRating(5));
    }

    }

