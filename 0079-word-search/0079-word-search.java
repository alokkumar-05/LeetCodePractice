class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //check from first character match
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    //helper function for word search
    private boolean helper(char[][] board, String word, int i, int j, int k) {
        int n = board.length;
        int m = board[0].length;
       
        //out of bound
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }
        
        //miss - match character
        if (board[i][j] != word.charAt(k)) {
            return false;
        }

        //word found 
        if (k == word.length() - 1) {
            return true;
        }
         
        //marking '#' for visited
        char org = board[i][j];
        board[i][j] = '#';
        
        //4 direction traversal
        boolean up = helper(board, word, i + 1, j, k + 1);
        boolean right = helper(board, word, i, j + 1, k + 1);
        boolean left = helper(board, word, i - 1, j, k + 1);
        boolean down = helper(board, word, i, j - 1, k + 1);
        
        //restore orginal character
        board[i][j] = org;

        if (right || up || left || down) {
            return true;
        }
        return false;
    }
}