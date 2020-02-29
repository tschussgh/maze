package org.anderson.dan.maze.service

import org.anderson.dan.maze.dto.Coordinates
import org.anderson.dan.maze.dto.Direction
import org.anderson.dan.maze.dto.LeftMirror
import org.anderson.dan.maze.dto.MazeExit
import org.anderson.dan.maze.dto.Navigate
import org.anderson.dan.maze.dto.RightMirror
import org.anderson.dan.maze.dto.Room
import org.junit.jupiter.api.Test;

class MazeRunnerTest {
    Coordinates coordinates
    Map<Integer, Map<Integer, Room>> maze

    @Test
    void build_and_launch() {
        List<String> fileContents = ["5,5","-1","0,0L","1,1RR","2,2LL","3,3R","4,4L","-1","0,0H","-1"]
        MazeExit result = MazeRunner.buildAndLaunchMaze(fileContents)
        assert result.exitPoint.x == 0
        assert result.exitPoint.y == 0
        assert result.exitOrientation == Direction.VERTICAL
    }

    @Test
    void launch_vertical() {
        maze = [
                0: [0: new Room(mirror: new LeftMirror(reflectRight: Boolean.TRUE)), 1: new Room()],
                1: [0: new Room(), 1: new Room()]
        ]
        coordinates = new Coordinates(0,1)
        MazeExit result = Navigate.DOWN(maze, coordinates)
        assert result.exitPoint.x == 1
        assert result.exitPoint.y == 0
        assert result.exitOrientation == Direction.HORIZONTAL
    }

    @Test
    void launch_horizontal() {
        maze = [
                0: [0: new Room(mirror: new RightMirror(reflectLeft: Boolean.TRUE)), 1: new Room()],
                1: [0: new Room(), 1: new Room()]
        ]
        coordinates = new Coordinates(0,1)
        MazeExit result = Navigate.DOWN(maze, coordinates)
        assert result.exitPoint.x == 0
        assert result.exitPoint.y == 0
        assert result.exitOrientation == Direction.HORIZONTAL
    }

}