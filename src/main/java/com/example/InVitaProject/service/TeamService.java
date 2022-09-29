package com.example.InVitaProject.service;


import com.example.InVitaProject.model.Team;
import com.example.InVitaProject.repo.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TeamService {

    @Autowired
    TeamRepo teamRepo;
    public List<Team> getAllTeamDetails() {
        return teamRepo.findAll();
    }

    public Team getByName(String teamName) {
        return teamRepo.findByName(teamName);
    }

    public Team updateByTeamName(Team updatedTeamData) {

       Optional<Team> oldTeamData = Optional.ofNullable(teamRepo.findByName(updatedTeamData.getName()));

       if(oldTeamData.isPresent()){
           Team newTeamData =  oldTeamData.get();

           newTeamData.setName(updatedTeamData.getName());
           newTeamData.setFifaRating(updatedTeamData.getFifaRating());
           newTeamData.setSquadSize(updatedTeamData.getSquadSize());
           newTeamData.setNextMatch(updatedTeamData.getNextMatch());
           newTeamData.setStadium(updatedTeamData.getStadium());

           return teamRepo.save(newTeamData);

       }else{
           return null;
       }
    }

    public void deleteTeamByName(Integer teamName){
         teamRepo.deleteById(teamName);
    }

    public Team createTeam(Team team) {
        return teamRepo.save(team);
    }
}
