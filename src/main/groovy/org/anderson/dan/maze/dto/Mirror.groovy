package org.anderson.dan.maze.dto

interface Mirror {
    void setReflectLeft(Boolean reflectLeft)
    Boolean getReflectLeft()
    void setReflectRight(Boolean reflectRight)
    Boolean getReflectRight()
    MazeExit left(Coordinates coordinates, Map<Integer, Map<Integer, Room>> maze)
    MazeExit right(Coordinates coordinates, Map<Integer, Map<Integer, Room>> maze)
    MazeExit up(Coordinates coordinates, Map<Integer, Map<Integer, Room>> maze)
    MazeExit down(Coordinates coordinates, Map<Integer, Map<Integer, Room>> maze)
}