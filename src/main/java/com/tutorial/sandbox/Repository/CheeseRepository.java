package com.tutorial.sandbox.Repository;

import com.tutorial.sandbox.Entity.Cheese;
import com.tutorial.sandbox.Entity.Rat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CheeseRepository extends JpaRepository<Cheese,Long> {

    List<Cheese> findAll();

    Optional<Cheese> findById(Long id);

    Cheese findByName(String name);

    List<Cheese> findAllByAmount(Integer amount);

    List<Cheese> findAllByRatto(Rat ratto);

    List<Cheese> findAllByName(String name);
}