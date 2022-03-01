package com.crudexample.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.crudexample.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long>{

}
