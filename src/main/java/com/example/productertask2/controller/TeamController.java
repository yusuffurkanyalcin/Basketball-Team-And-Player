package com.example.productertask2.controller;

import com.example.productertask2.business.abstracts.TeamService;
import com.example.productertask2.entity.team.TeamEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService service;

    @PostMapping
    public TeamEntity create(@RequestBody TeamEntity team){
        return service.create(team);
    }
}
