package com.cydeo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<GenreRepository,Long> {


// ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that return all genres



    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns genres by containing name


}
