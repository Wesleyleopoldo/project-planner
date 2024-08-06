package com.rocketseat.planner.link;

import com.rocketseat.planner.trip.Trip;

import java.util.UUID;

public record LinkRequestPayload(UUID id, String tittle, String url, Trip trip) {
}
