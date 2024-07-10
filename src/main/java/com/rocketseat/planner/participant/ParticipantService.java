package com.rocketseat.planner.participant;

import com.rocketseat.planner.trip.Trip;
import com.rocketseat.planner.trip.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ParticipantService {

    @Autowired
    ParticipantRepository repository;

    public void registerParticipantsToEvent(List<String> participantsToInvite, Trip trip){
        List<Participant> participants = participantsToInvite.stream().map(email -> new Participant(email, trip)).toList();

        this.repository.saveAll(participants);

        System.out.println(participants.get(0).getId());
    }

    public ParticipanteCreateResponse registerParticipantToEvent(String email,Trip trip) {
        Participant newParticipant = new Participant(email, trip);

        this.repository.save(newParticipant);

        return new ParticipanteCreateResponse(newParticipant.getId());
    }

    public void triggerConfirmationEmailToParticipants(UUID tripId){}

    public void triggerConfirmationEmailToParticipant(String email){

    }

    public List<ParticipantDataSet> getAllParticipantsFromEvents(UUID tripId){
        return this.repository.findByTripId(tripId).stream().map(participant -> new ParticipantDataSet(participant.getId(), participant.getName(), participant.getEmail(), participant.getIsConfirmed())).toList();
    }
}
