package org.anderson.dan.maze

import org.anderson.dan.maze.dto.Coordinates
import org.anderson.dan.maze.dto.Direction
import org.anderson.dan.maze.dto.MazeExit
import org.anderson.dan.maze.dto.Room
import org.anderson.dan.maze.factory.MazeFactory
import org.anderson.dan.maze.service.MazeRunner
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class MazeApplication implements CommandLineRunner {

	static void main(String[] args) {
		SpringApplication.run(MazeApplication, args)
	}

	void run(String... args) {
		List<String> fileContents = new File(args[0]).readLines()
		MazeExit exit = MazeRunner.buildAndLaunchMaze(fileContents)
		println exit
	}
}
