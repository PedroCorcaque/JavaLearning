package com.power.RocketLeagueStats.repository;

import org.springframework.data.repository.CrudRepository;
import com.power.RocketLeagueStats.model.RLStats;

public interface AddressRepository extends CrudRepository<RLStats, String> { }
