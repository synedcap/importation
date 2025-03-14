package com.example.importation.repositories;


import com.example.importation.model.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository  extends JpaRepository<People,String> {
}
