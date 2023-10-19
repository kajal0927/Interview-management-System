package com.ims.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ims.api.entities.Round;
import com.ims.api.services.RoundService;

@RestController
@RequestMapping("/api/rounds")
public class RoundController {


    @Autowired
    private final RoundService roundService;

    public RoundController(RoundService roundService) {
        this.roundService = roundService;
    }

    @GetMapping
    public List<Round> getAllRounds() {
        return roundService.getAllRounds();
    }

    @GetMapping("/{roundId}")
    public ResponseEntity<Round> getRoundById(@PathVariable Long roundId) {
        Optional<Round> round = roundService.getRoundById(roundId);
        return round.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Round> createRound(@RequestBody Round round) {
        Round createdRound = roundService.createRound(round);
        return ResponseEntity.ok(createdRound);
    }

    @PutMapping("/{roundId}")
    public ResponseEntity<Round> updateRound(@PathVariable Long roundId, @RequestBody Round updatedRound) {
        Round round = roundService.updateRound(roundId, updatedRound);
        return round != null ? ResponseEntity.ok(round) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{roundId}")
    public ResponseEntity<Void> deleteRound(@PathVariable Long roundId) {
        roundService.deleteRound(roundId);
        return ResponseEntity.noContent().build();
    }
}
