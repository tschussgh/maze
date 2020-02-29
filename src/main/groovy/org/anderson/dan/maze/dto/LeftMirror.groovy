package org.anderson.dan.maze.dto

class LeftMirror implements Mirror {
    Boolean reflectLeft
    Boolean reflectRight

    MazeExit left(Coordinates coordinates, Map<Integer, Map<Integer, Room>> maze) {
        if (reflectRight) {
            Navigate.UP(maze, coordinates)
        } else {
            Navigate.LEFT(maze, coordinates)
        }
    }

    MazeExit right(Coordinates coordinates, Map<Integer, Map<Integer, Room>> maze) {
        if (reflectLeft) {
            Navigate.DOWN(maze, coordinates)
        } else {
            Navigate.RIGHT(maze, coordinates)
        }
    }

    MazeExit up(Coordinates coordinates, Map<Integer, Map<Integer, Room>> maze) {
        if (reflectLeft) {
            Navigate.LEFT(maze, coordinates)
        } else {
            Navigate.UP(maze, coordinates)
        }
    }

    MazeExit down(Coordinates coordinates, Map<Integer, Map<Integer, Room>> maze) {
        if (reflectRight) {
            Navigate.RIGHT(maze, coordinates)
        } else {
            Navigate.DOWN(maze, coordinates)
        }
    }
}
