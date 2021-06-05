package main.tests;


import main.tasks.IslandArea;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IslandAreaTest {

    private IslandArea testObject;

    @BeforeEach
    public void setUp() throws Exception {
        testObject = new IslandArea();
    }

    @Test
    @DisplayName("Grid with one empty line returns 0")
    public void testEmpty() {
        int[][] grid = {{0,0,0,0,0,0,0,0}};
        assertEquals(0, testObject.maxAreaOfIsland(grid));
    }

    @Test
    @DisplayName("Grid with no empty line returns square")
    public void testFull() {
        int[][] grid = {{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1}};
        assertEquals(36, testObject.maxAreaOfIsland(grid));
    }


    @Test
    @DisplayName("Test grid")
    public void testMultiply() {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        assertEquals(6, testObject.maxAreaOfIsland(grid));
    }

    @Test
    @DisplayName("Test grid")
    public void testMultiply1() {
        int[][] grid = {{1,1,0,0,0,1},{0,1,1,1,1,1},{0,1,0,0,1,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,1,1,0,0,0}};
        assertEquals(18, testObject.maxAreaOfIsland(grid));
    }

    @Test
    @DisplayName("Test grid")
    public void testMultiply2() {
        int[][] grid = {{1,1,1,1,1,0,0,1},{1,0,0,0,1,0,1,1},{0,1,1,1,1,1,1,1},{0,1,0,0,0,1,0,0},{0,1,1,0,1,1,0,1},{0,0,1,0,0,1,1,1},};
        assertEquals(28, testObject.maxAreaOfIsland(grid));
    }
}
