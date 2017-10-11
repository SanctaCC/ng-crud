package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Person;

public interface PersonCrudRepository extends CrudRepository<Person, Integer> {

}
