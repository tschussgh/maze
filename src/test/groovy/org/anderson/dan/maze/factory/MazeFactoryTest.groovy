package org.anderson.dan.maze.factory

import org.anderson.dan.maze.dto.LeftMirror
import org.anderson.dan.maze.dto.RightMirror
import org.anderson.dan.maze.dto.Room
import org.junit.jupiter.api.Test

class MazeFactoryTest {

    @Test
    void createMaze() {
        Map<Integer, Map<Integer, Room>> result = MazeFactory.createMaze(2,7)
        assert result.size() == 2
        assert result[0].size() == 7
        assert result[1].size() == 7
    }
    @Test
    void populateMaze() {
        Map<Integer, Map<Integer, Room>> maze = MazeFactory.createMaze(8,8)
        Map<Integer, Map<Integer, Room>> result = MazeFactory.populateMaze(maze, ['1,1LL', '2,2RR', '3,3L', '4,4R'])
        assert result[1][1].mirror
        assert result[1][1].mirror.class == LeftMirror
        assert result[1][1].mirror.reflectLeft
        assert !result[1][1].mirror.reflectRight
        assert result[2][2].mirror
        assert result[2][2].mirror.class == RightMirror
        assert !result[2][2].mirror.reflectLeft
        assert result[2][2].mirror.reflectRight
        assert result[3][3].mirror
        assert result[3][3].mirror.class == LeftMirror
        assert result[3][3].mirror.reflectLeft
        assert result[3][3].mirror.reflectRight
        assert result[4][4].mirror
        assert result[4][4].mirror.class == RightMirror
        assert result[4][4].mirror.reflectLeft
        assert result[4][4].mirror.reflectRight
    }
}