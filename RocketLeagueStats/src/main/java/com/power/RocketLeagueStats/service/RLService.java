package com.power.RocketLeagueStats.service;

import com.power.RocketLeagueStats.model.RLStatsStatus;
import com.power.RocketLeagueStats.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RLService {

    @Autowired
    public RLStatsStatus RLStatsStatus;

    public Status getStatus() {

    }

    private void saveStatus(Status status) {

    }

    public void setup() {

    }
}
