package main.tasks;

import java.util.HashSet;
import java.util.Set;

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
        for (int i = 0; i < m; i++) {
            Island[] previous = current;
            current = new Island[n];
            CurrentIsland currentIsland = null;
            for (int j = 0; j < n; j++) {
                if (isanIsland(grid[i][j])) {
                    if (previous[j] != null) {
                        if (currentIsland == null) {
                            currentIsland = new CurrentIsland(previous[j]);
                        } else if (!currentIsland.belongsToArchipelag(previous[j])) {
                            currentIsland.joinIsland(previous[j]);
                        }
                    } else if (currentIsland == null) {
                        currentIsland = new CurrentIsland(new Island());
                    }
                    currentIsland.addSquare();
                    maxSquare = max(maxSquare, currentIsland.getSquare());
                    current[j] = currentIsland.getCurrentIsland();
                } else {
                    currentIsland = null;
                }
            }
        }
        return maxSquare;
    }

    private boolean isanIsland(int i) {
        return i == 1;
    }
}

class Island {
    private int square = 0;

    public Island() {
    }

    public void addSquare() {
        square += 1;
    }

    public void joinIsland(int joiningSquare) {
        square += joiningSquare;
    }

    public int getSquare() {
        return square;
    }
}

class CurrentIsland {
    private Island currentIsland;
    private Set<Island> joinedIslands = new HashSet<>();

    public CurrentIsland(Island currentIsland) {
        this.currentIsland = currentIsland;
    }

    // todo atomic???
    void joinIsland(Island joinedIsland) {
        currentIsland.joinIsland(joinedIsland.getSquare());
        joinedIslands.add(joinedIsland);
    }

    boolean belongsToArchipelag(Island candidate) {
        return currentIsland == candidate || joinedIslands.contains(candidate);
    }

    void addSquare() {
        currentIsland.addSquare();
    }

    public Island getCurrentIsland() {
        return currentIsland;
    }

    public int getSquare() {
        return currentIsland.getSquare();
    }
}

