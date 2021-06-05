package main.tasks;

import static java.lang.Math.max;

public class IslandArea {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        int maxSquare = 0;
        Island[] current = new Island[n];
        for (int[] aGrid : grid) {
            Island[] previous = current;
            current = new Island[n];
            Island currentIsland = null;
            for (int j = 0; j < n; j++) {
                if (isanIsland(aGrid[j])) {
                    if (previous[j] != null) {
                        if (currentIsland == null) {
                            currentIsland = previous[j];
                        } else if (currentIsland != previous[j]) {
                            joinIslands(currentIsland, previous, current, j);
                        }
                    } else if (currentIsland == null) {
                        currentIsland = new Island();
                    }
                    currentIsland.addSquare();
                    maxSquare = max(maxSquare, currentIsland.getSquare());
                    current[j] = currentIsland;
                } else {
                    currentIsland = null;
                }
            }
        }
        return maxSquare;
    }

    private void joinIslands(Island currentIsland, Island[] previous, Island[] current, int indexOfIslandToJoin) {
        currentIsland.joinIslands(previous[indexOfIslandToJoin].getSquare());
        for (int k = 0; k < indexOfIslandToJoin; k++) {
            if (current[k] == previous[indexOfIslandToJoin]) {
                current[k] = currentIsland;
            }
        }
        // todo test indexOfIslandToJoin = n
        for (int l = previous.length - 1; l > indexOfIslandToJoin; l--) {
            if( previous[l] == previous[indexOfIslandToJoin]) {
                previous[l] = currentIsland;
            }
        }
    }

    private boolean isanIsland(int i) {
        return i == 1;
    }
}

class Island {
    private int square = 0;

    Island() {
    }

    void addSquare() {
        square += 1;
    }

    void joinIslands(int joiningSquare) {
        square += joiningSquare;
    }

    int getSquare() {
        return square;
    }
}

