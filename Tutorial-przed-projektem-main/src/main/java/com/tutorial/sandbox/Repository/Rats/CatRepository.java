package com.tutorial.sandbox.Repository.Rats;

import com.tutorial.sandbox.Entity.Rats.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
    List<Cat> findAll();

    Optional<Cat> findById(Long id);

    Cat findByName(String name);

    List<Cat> findAllByAge(Integer age);

    List<Cat> findAllByName(String name);
}
