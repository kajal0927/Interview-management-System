package com.ims.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.api.dao.RoundRepository;
import com.ims.api.entities.Round;

@Service
public class RoundService {

    @Autowired
    private  RoundRepository roundRepository;

    public RoundService(RoundRepository roundRepository) {
        this.roundRepository = roundRepository;
    }

    public List<Round> getAllRounds() {
        return roundRepository.findAll();
    }

    public Optional<Round> getRoundById(Long roundId) {
        return roundRepository.findById(roundId);
    }

    public Round createRound(Round round) {
        
        return roundRepository.save(round);
    }

    public Round updateRound(Long roundId, Round updatedRound) {
        
        return roundRepository.findById(roundId)
                .map(round -> {
                    round.setRoundNumber(updatedRound.getRoundNumber());
                    round.setName(updatedRound.getName());
                    round.setDescription(updatedRound.getDescription());
                    return roundRepository.save(round);
                })
                .orElse(null);
    }

    public void deleteRound(Long roundId) {
        roundRepository.deleteById(roundId);
    }
}
