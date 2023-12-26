
public class RotateMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[][] matrix = {
		            {1, 2, 3, 4},
		            {5, 6, 7, 8},
		            {9, 10, 11, 12},
		            {13, 14, 15, 16}
		        };

		        System.out.println("Original Matrix:");
		        printMatrix(matrix);

		       RotateMatrix rm = new RotateMatrix();
		       rm.rotate(matrix);
		       

		       System.out.println("===================================================");
		       rm.printMatrix(matrix);
		       

		      
	}
	static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }

	
	void rotate(int[][] matrix) {
	    if (matrix.length == 0 || matrix.length != matrix[0].length)
	        throw new IllegalArgumentException("Matrix must be a non-empty square matrix.");

	    int n = matrix.length;

	    for (int layer = 0; layer < n / 2; layer++) {
	        int first = layer;
	        int last = n - 1 - layer;
	        for (int i = first; i < last; i++) {
	            int offset = i - first;
	            int top = matrix[first][i]; // save top

	            // left -> top
	            matrix[first][i] = matrix[last - offset][first];

	            // bottom -> left
	            matrix[last - offset][first] = matrix[last][last - offset];

	            // right -> bottom
	            matrix[last][last - offset] = matrix[i][last];

	            // top -> right
	            matrix[i][last] = top; // right <- saved top
	        }
	    }
	}


}
