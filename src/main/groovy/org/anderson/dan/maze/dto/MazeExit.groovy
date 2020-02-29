package org.anderson.dan.maze.dto

class MazeExit {
    Direction exitOrientation
    Coordinates exitPoint

    MazeExit(Coordinates coordinates, Direction direction){
        this.exitPoint = coordinates
        this.exitOrientation = direction
    }

    String toString() {
        "The laser will exit the maze at (${exitPoint.x}, ${exitPoint.y}) moving ${exitOrientation.orientation}"
    }
}
