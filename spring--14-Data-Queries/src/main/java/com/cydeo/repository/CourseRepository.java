package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository <Course, Long> {

    //Find all courses by category
    List<Course> findByCategory(String category);

    //Find all courses by category and order the entities by name

    List<Course> findByCategoryOrderByName(String Category);

    //Checks if a course with the supplied name exists. Return true if exists, false otherwise
    Boolean existsCourseByName(String name);

    //Returns the count of courses for the given category
    int countByCategory(String Category);

    //Finds all the courses that start with the given course name string
    List<Course> findByNameStartingWith(String name);

    //Find all courses by category and returns a stream
    Stream<Course> streamAllByCategory(String category);

    Optional<Course> findByRating(Integer rating);
}
