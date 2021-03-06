package org.anderson.dan.maze.dto

import org.junit.jupiter.api.Test

class RightMirrorTest {
    Coordinates coordinates
    Map<Integer, Map<Integer, Room>> maze

    @Test
    void right_mirror_left_nav() {
        maze = [
                0: [0: new Room(), 1: new Room(mirror: new RightMirror(reflectRight: Boolean.TRUE))],
                1: [0: new Room(), 1: new Room()]
        ]
        coordinates = new Coordinates(2,1)
        MazeExit result = Navigate.LEFT(maze, coordinates)
        assert result.exitPoint.x == 0
        assert result.exitPoint.y == 0
        assert result.exitOrientation == Direction.VERTICAL
    }

    @Test
    void right_mirror_down_nav() {
        maze = [
                0: [0: new Room(mirror: new RightMirror(reflectLeft: Boolean.TRUE)), 1: new Room()],
                1: [0: new Room(), 1: new Room()]
        ]
        coordinates = new Coordinates(0,2)
        MazeExit result = Navigate.DOWN(maze, coordinates)
        assert result.exitPoint.x == 0
        assert result.exitPoint.y == 0
        assert result.exitOrientation == Direction.HORIZONTAL
    }

    @Test
    void no_mirror_down_nav() {
        maze = [
                0: [0: new Room(), 1: new Room()],
                1: [0: new Room(), 1: new Room()]
        ]
        coordinates = new Coordinates(0,2)
        MazeExit result = Navigate.DOWN(maze, coordinates)
        assert result.exitPoint.x == 0
        assert result.exitPoint.y == 0
        assert result.exitOrientation == Direction.VERTICAL
    }

    @Test
    void right_mirror_right_nav() {
        maze = [
                0: [0: new Room(), 1: new Room()],
                1: [0: new Room(mirror: new RightMirror(reflectLeft: Boolean.TRUE)), 1: new Room()]
        ]
        coordinates = new Coordinates(-1,0)
        MazeExit result = Navigate.RIGHT(maze, coordinates)
        assert result.exitPoint.x == 1
        assert result.exitPoint.y == 1
        assert result.exitOrientation == Direction.VERTICAL
    }

    @Test
    void right_mirror_up_nav() {
        maze = [
                0: [0: new Room(), 1: new Room()],
                1: [0: new Room(), 1: new Room(mirror: new RightMirror(reflectRight: Boolean.TRUE))]
        ]
        coordinates = new Coordinates(1,-1)
        MazeExit result = Navigate.UP(maze, coordinates)
        assert result.exitPoint.x == 1
        assert result.exitPoint.y == 1
        assert result.exitOrientation == Direction.HORIZONTAL
    }
}