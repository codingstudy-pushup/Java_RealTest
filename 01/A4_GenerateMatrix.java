package realtest01;

public class A4_GenerateMatrix {

	public static void main(String[] args) {
//		System.out.println(generateMatrix(4));
		
		int[][] res = generateMatrix(3);
		for(int i=0; i<res.length; i++) {
			for(int j=0; j<res[i].length; j++) {
				System.out.print(res[i][j]+"\t");
			}
			System.out.println(" ");
		}
	}
	public static int[][] generateMatrix(int n) {
        // 1
        int[][] matrix = new int[n][n];
        if (n == 0) return matrix;
        
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;
        int num = 1; 
        
        //2
        while (rowStart <= rowEnd && colStart <= colEnd) {
        	//right
        	for (int i = colStart; i <= colEnd; i ++) {
                matrix[rowStart][i] = num ++; 
            }
            rowStart ++;
            
            //down
            for (int i = rowStart; i <= rowEnd; i ++) {
                matrix[i][colEnd] = num ++;
            }
            colEnd --;
            
            //left
            for (int i = colEnd; i >= colStart; i --) {
                if (rowStart <= rowEnd)
                    matrix[rowEnd][i] = num ++; 
            }
            rowEnd --;
            //up
            for (int i = rowEnd; i >= rowStart; i --) {
                if (colStart <= colEnd)
                    matrix[i][colStart] = num ++;
            }
            colStart ++;
        }
        
        return matrix;
    }
}
