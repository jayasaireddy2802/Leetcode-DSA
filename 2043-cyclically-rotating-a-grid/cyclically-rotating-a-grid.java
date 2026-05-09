class Solution {
    public int[][] rotateGrid(int[][] matrix, int k) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int totalLayers = Math.min(rows, cols) / 2;

        for (int l = 0; l < totalLayers; l++) {

            List<Integer> elements = new ArrayList<>();

            int r1 = l;
            int r2 = rows - l - 1;
            int c1 = l;
            int c2 = cols - l - 1;

            
            for (int c = c1; c <= c2; c++) {
                elements.add(matrix[r1][c]);
            }

            
            for (int r = r1 + 1; r < r2; r++) {
                elements.add(matrix[r][c2]);
            }

            
            for (int c = c2; c >= c1; c--) {
                elements.add(matrix[r2][c]);
            }

            
            for (int r = r2 - 1; r > r1; r--) {
                elements.add(matrix[r][c1]);
            }

            int size = elements.size();
            int shift = k % size;

           
            Collections.rotate(elements, -shift);

            int index = 0;

            
            for (int c = c1; c <= c2; c++) {
                matrix[r1][c] = elements.get(index++);
            }

            
            for (int r = r1 + 1; r < r2; r++) {
                matrix[r][c2] = elements.get(index++);
            }

            
            for (int c = c2; c >= c1; c--) {
                matrix[r2][c] = elements.get(index++);
            }

            
            for (int r = r2 - 1; r > r1; r--) {
                matrix[r][c1] = elements.get(index++);
            }
        }

        return matrix;
    }
}