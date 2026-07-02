class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        
        int[][] maxHealth = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(maxHealth[i], -1);
        }
        
        return helper(grid, maxHealth, health, 0, 0);
    }

    private boolean helper(List<List<Integer>> grid, int[][] maxHealth, int health, int r, int c) {
        int n = grid.size();
        int m = grid.get(0).size();
        
        //Out of bounds check
        if (r < 0 || c < 0 || r >= n || c >= m) {
            return false;
        }
        
        // Deduct health immediately for the current cell
        int remainingHealth = health - grid.get(r).get(c);
        if (remainingHealth <= 0) {
            return false;
        }
        
        // Destination 
        if (r == n - 1 && c == m - 1) {
            return true;
        }
        
        //If we visited this cell before with equal or more health, skip it
        if (remainingHealth <= maxHealth[r][c]) {
            return false;
        }
        // Update the maximum health for this cell
        maxHealth[r][c] = remainingHealth;
        
        // Explore 4 directions
        boolean ri = helper(grid, maxHealth, remainingHealth, r, c + 1);
        boolean u  = helper(grid, maxHealth, remainingHealth, r + 1, c);
        boolean l  = helper(grid, maxHealth, remainingHealth, r, c - 1);
        boolean d  = helper(grid, maxHealth, remainingHealth, r - 1, c);
        
        return ri || u || l || d;
    }
}