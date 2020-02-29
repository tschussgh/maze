package org.anderson.dan.maze.dto

enum Direction {
    VERTICAL('V'),
    HORIZONTAL('H')

    String orientation
    Direction(String orientation) {
        this.orientation = orientation
    }

    static Direction forOrientation(String orientation) {
        values().find{it.orientation == orientation}
    }
}