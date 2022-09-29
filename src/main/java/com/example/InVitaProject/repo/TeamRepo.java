package com.example.InVitaProject.repo;


import com.example.InVitaProject.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepo extends JpaRepository<Team, Integer> {

    public Team findByName(String name);

    public void deleteByName(String name);
}
