class Solution {
    public List<String> findWords(char[][] board, String[] words) {
     Set wordSet = new HashSet<>();
        Set firstLetters = new HashSet<>();
        
        // Populate the HashSets with target words and initial letters
        for (String w : words) {
            wordSet.add(w);
            firstLetters.add(w.charAt(0));
        }
        
        Set resultSet = new HashSet<>();
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        
        // Find each matching first letter on the board and invoke the helper function
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (firstLetters.contains(board[r][c])) {
                    dfs(board, r, c, "", wordSet, resultSet, visited);
                }
            }
        }
        
        return new ArrayList<>(resultSet);
    }
    
    private void dfs(char[][] board, int r, int c, String currentStr, Set wordSet, Set resultSet, boolean[][] visited) {
        
        // Base boundary conditions and visited check
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || visited[r][c]) {
            return;
        }
        
        currentStr += board[r][c];
        
        // Stop exploring paths longer than 10 chars
        if (currentStr.length() > 10) {
            return;
        }
        
        // Check if the current combination forms a valid target word
        if (wordSet.contains(currentStr)) {
            resultSet.add(currentStr);
        }
        
        visited[r][c] = true;
        
        // Traverse in 4 directions
        dfs(board, r - 1, c, currentStr, wordSet, resultSet, visited); // Up
        dfs(board, r + 1, c, currentStr, wordSet, resultSet, visited); // Down
        dfs(board, r, c - 1, currentStr, wordSet, resultSet, visited); // Left
        dfs(board, r, c + 1, currentStr, wordSet, resultSet, visited); // Right
        
        visited[r][c] = false; // Backtrack
    }
}