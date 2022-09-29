package com.example.InVitaProject.controller;


import com.example.InVitaProject.model.Team;
import com.example.InVitaProject.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("soccer/details")
public class TeamController {

    @Autowired
    TeamService teamService;


    @GetMapping()
    public ResponseEntity<List<Team>> getAllTeamDetails() {
        List<Team> teams = teamService.getAllTeamDetails();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<Team> createTeam(@RequestBody Team team){
        System.out.println(team);
        Team createdTeam = teamService.createTeam(team);
        return new ResponseEntity<>(createdTeam, HttpStatus.CREATED);
    }

    @GetMapping("/{teamName}")
    public ResponseEntity<Team> getByName(@PathVariable  String teamName){
        Team team = teamService.getByName(teamName);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @PutMapping("/{updatedTeam}")
    public ResponseEntity<Team> updateByTeamName(@RequestBody  Team updatedTeam){
        Team team = teamService.updateByTeamName(updatedTeam);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @DeleteMapping("/{teamId}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Integer teamId){
        teamService.deleteTeamByName(teamId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
