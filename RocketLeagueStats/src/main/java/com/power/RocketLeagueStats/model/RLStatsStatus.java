package com.power.RocketLeagueStats.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RLStatsStatus {

    public static final int DEFAULT_ID = 1;
    @Id
    private int id;
    private Status status;
}
