package org.anderson.dan.maze.service

import org.anderson.dan.maze.dto.Coordinates
import org.anderson.dan.maze.dto.Direction
import org.anderson.dan.maze.dto.MazeExit
import org.anderson.dan.maze.dto.Navigate
import org.anderson.dan.maze.dto.Room
import org.anderson.dan.maze.factory.MazeFactory

class MazeRunner {
    static MazeExit buildAndLaunchMaze(List<String> fileContents) {
        String mapSizeString = fileContents.pop()
        List<String> mapSize = mapSizeString.tokenize(',')
        fileContents.pop()
        fileContents.removeLast()
        String startingCoordinatesString = fileContents.removeLast()
        List<String> startingCoordinates = startingCoordinatesString.toList()
        fileContents.removeLast()

        println "The generated maze is ${mapSize[0]} rooms wide and ${mapSize[1]} rooms tall"
        println "The laser will enter the maze at ${startingCoordinates[0]},${startingCoordinates[2]} moving ${startingCoordinates[3]}"
        Map<Integer, Map<Integer, Room>> maze = MazeFactory.populateMaze(MazeFactory.createMaze(mapSize[0].toInteger(), mapSize[1].toInteger()), fileContents)

        launchMaze(maze, new Coordinates(startingCoordinates[0].toInteger(), startingCoordinates[2].toInteger()), Direction.forOrientation(startingCoordinates[3]))
    }

    static MazeExit launchMaze(Map<Integer, Map<Integer, Room>> maze, Coordinates startingCoordinates, Direction startingDirection) {
        Coordinates launchPoint = new Coordinates(startingCoordinates.x, startingCoordinates.y)

        if (startingDirection == Direction.HORIZONTAL) {
            if (startingCoordinates.x == 0) {
                launchPoint.x += -1
                Navigate.RIGHT(maze, launchPoint)
            } else {
                launchPoint.x += 1
                Navigate.LEFT(maze, launchPoint)
            }
        } else {
            if (startingCoordinates.y == 0) {
                launchPoint.y += -1
                Navigate.UP(maze, launchPoint)
            } else {
                launchPoint.y += 1
                Navigate.DOWN(maze, launchPoint)
            }
        }
    }
}
