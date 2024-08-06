package com.rocketseat.planner.activity;

import java.time.LocalDateTime;
import java.util.UUID;

public record ActivityDataSet(UUID id, String tittle, LocalDateTime occurs_at) {
}
