class Spreadsheet {
    int[][] arr;

    private int[] getRowAndCol(String cell)
    {
        int y = cell.charAt(0) - 'A';
        cell = cell.substring(1, cell.length());
        int x = Integer.parseInt(cell) - 1;
        int[] res = new int[2];
        res[0] = x;
        res[1] = y;
        return res;
    }

    private boolean check(String str)
    {
        for(char ch : str.toCharArray())
        {
            if(ch >= 'A' && ch <= 'Z' )
                return true;
        }
        return false;
    }

    public Spreadsheet(int rows) {
        arr = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int[] res = getRowAndCol(cell);
        arr[res[0]][res[1]] = value;

    }
    
    public void resetCell(String cell) {
        int[] res = getRowAndCol(cell);
        arr[res[0]][res[1]] = 0;
    }
    
    public int getValue(String formula) {
        String[] strs = formula.substring(1, formula.length()).split("\\+");
        int x = -1;
        int y = -1;
        for(String str : strs)
        {
            if(check(str))
            {
                int[] res = getRowAndCol(str);
                if(x == -1)x = arr[res[0]][res[1]];
                else if(y == -1) y = arr[res[0]][res[1]];
            }
            else
            {
                if(x == -1) x = Integer.parseInt(str);
                else if(y == -1) y = Integer.parseInt(str);
            }
        }
        return x + y;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */