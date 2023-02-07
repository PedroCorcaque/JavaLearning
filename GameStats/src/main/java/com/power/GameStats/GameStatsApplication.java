package com.power.GameStats;

import com.power.GameStats.libs.annotations.EnableDiscord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDiscord
public class GameStatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameStatsApplication.class);
	}

}
