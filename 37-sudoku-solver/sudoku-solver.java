class Solution {

    public boolean isPossible(char[][] board, int r, int c, char ch)
    {
        
        for(int i = 0; i < board.length; i++)
        {
            if(board[i][c] == ch)
                return false;
        }

        for(int j = 0; j < board[0].length; j++)
        {
            if(board[r][j] == ch)
                return false;
        }

        for(int i = 0; i < 9; i++)
        {
            int row =(r / 3)*3 + i / 3;
            int col = (c / 3)* 3 + i % 3;

            if(board[row][col] == ch)
                return false;

        }

        return true;
    }

    public boolean solve(char[][] board)
    {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board[i][j] == '.')
                {
                    for(char ch = '1'; ch <= '9'; ch++)
                    {
                        if(isPossible(board, i, j, ch))
                        {
                            board[i][j] = ch;
                            if(solve(board) == true)
                                return true;
                            board[i][j] = '.';
                        }                        
                    }
                    return false;
                }
            }
        }

        return true;

    }


    public void solveSudoku(char[][] board) {
        
       solve(board);    
       
    }
}