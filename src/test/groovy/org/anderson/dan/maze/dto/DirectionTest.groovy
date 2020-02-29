package org.anderson.dan.maze.dto

import org.junit.jupiter.api.Test;

class DirectionTest {
    @Test
    void finds_right_orientation() {
        assert Direction.forOrientation('V') == Direction.VERTICAL
        assert Direction.forOrientation('H') == Direction.HORIZONTAL
    }
}