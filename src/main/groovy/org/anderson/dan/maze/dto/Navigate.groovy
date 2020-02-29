package org.anderson.dan.maze.dto

class Navigate {

    static MazeExit LEFT(Map<Integer, Map<Integer, Room>> maze, Coordinates coordinates) {
        Integer newX = coordinates.x - 1
        Integer newY = coordinates.y
        Coordinates newCoordinates = new Coordinates(newX, newY)
        Room room = maze[newX]?.getAt(newY)
        if (room) {
            if (room.mirror) {
                room.mirror.left(newCoordinates, maze)
            } else {
                LEFT(maze, newCoordinates)
            }
        } else {
            new MazeExit(coordinates, Direction.HORIZONTAL)
        }
    }

    static MazeExit RIGHT(Map<Integer, Map<Integer, Room>> maze, Coordinates coordinates) {
        Integer newX = coordinates.x + 1
        Integer newY = coordinates.y
        Coordinates newCoordinates = new Coordinates(newX, newY)
        Room room = maze[newX]?.getAt(newY)
        if (room) {
            if (room.mirror) {
                room.mirror.right(newCoordinates, maze)
            } else {
                RIGHT(maze, new Coordinates(newX, newY))
            }
        } else {
            new MazeExit(coordinates, Direction.HORIZONTAL)
        }
    }

    static MazeExit UP(Map<Integer, Map<Integer, Room>> maze, Coordinates coordinates) {
        Integer newX = coordinates.x
        Integer newY = coordinates.y + 1
        Coordinates newCoordinates = new Coordinates(newX, newY)
        Room room = maze[newX]?.getAt(newY)
        if (room) {
            if (room.mirror) {
                room.mirror.up(newCoordinates, maze)
            } else {
                UP(maze, new Coordinates(newX, newY))
            }
        } else {
            new MazeExit(coordinates, Direction.VERTICAL)
        }
    }

    static MazeExit DOWN(Map<Integer, Map<Integer, Room>> maze, Coordinates coordinates) {
        Integer newX = coordinates.x
        Integer newY = coordinates.y - 1
        Coordinates newCoordinates = new Coordinates(newX, newY)
        Room room = maze[newX]?.getAt(newY)
        if (room) {
            if (room.mirror) {
                room.mirror.down(newCoordinates, maze)
            } else {
                DOWN(maze, new Coordinates(newX, newY))
            }
        } else {
            coordinates
            new MazeExit(coordinates, Direction.VERTICAL)
        }
    }
}