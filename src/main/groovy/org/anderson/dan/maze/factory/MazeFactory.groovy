package org.anderson.dan.maze.factory

import org.anderson.dan.maze.dto.LeftMirror
import org.anderson.dan.maze.dto.Mirror
import org.anderson.dan.maze.dto.RightMirror
import org.anderson.dan.maze.dto.Room

class MazeFactory {
    static final char LEFT = 'L'
    static final char RIGHT = 'R'

    static Map<Integer, Map<Integer, Room>> createMaze(Integer xWidth, Integer yWidth) {
        Map<Integer, Map<Integer, Room>> maze = [:]
        (0..<xWidth).each { xIndex ->
                maze[xIndex] = [:]
            (0..<yWidth).each { yIndex ->
                maze[xIndex] << [(yIndex) : new Room()]
            }
        }
        maze
    }
    static Map<Integer, Map<Integer, Room>> populateMaze(Map<Integer, Map<Integer, Room>> maze, List<String> mirrors) {
        mirrors.each {
            String[] elements = it.chars
            Room room = maze[elements[0].toInteger()]?.getAt(elements[2].toInteger())
            Mirror mirror = null

            switch (elements[3]) {
                case LEFT.toString() :
                    mirror = new LeftMirror()
                    break
                case RIGHT.toString() :
                    mirror = new RightMirror()
            }
            if (elements.size() > 4) {
                switch (elements[4]) {
                    case LEFT.toString():
                        mirror.reflectLeft = Boolean.TRUE
                        break
                    case RIGHT.toString():
                        mirror.reflectRight = Boolean.TRUE
                        break
                }
            } else {
                mirror.reflectRight = Boolean.TRUE
                mirror.reflectLeft = Boolean.TRUE
            }
            room.mirror = mirror
        }
        maze
    }
}
