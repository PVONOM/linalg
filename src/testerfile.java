import java.util.*;
import javax.swing.*;
import java.math.*;

public class testerfile {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);       
        boolean jerry = false;
        String rowC = new String("????");
        String colC = new String("????");

        /*
         * accepts the RxC dimentions 
         */
        while (!jerry) {
            System.out.println( "enter the number of rows of ur matrix " );
            rowC = scanner.nextLine();
            System.out.println("enter the number of columns of ur matrix");
            colC = scanner.nextLine();

            try {
                Integer.parseInt(rowC);
                Integer.parseInt(colC);
                jerry = true;
            } catch (NumberFormatException e) {
                System.out.println("UR INPUT WAS NOT A NUMBER DO THAT AGAIN!");
            }
        }
        
        System.out.println("success");
        System.out.println("ur matrix is of " + rowC + "x" + colC);
        
        int[][] matrix = new int[Integer.parseInt(rowC)][Integer.parseInt(colC)]; // creates an matrix of said dimentions 

        for(int i =1; i <= Integer.parseInt(rowC); i++){
            System.out.println("enter the values of row " + i);
            for(int j = 0; j< Integer.parseInt(colC); j++){
                try {
                    matrix[i-1][j] = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("UR INPUT WAS NOT A NUMBER DO THAT AGAIN");
                    j--;
                }
            }
        }
        

        System.out.println("success");
        print2D(matrix);
        jerry = false;

        System.out.println("what do you want to do with your matrix?? "); String input; String det = new String("det");String none = new String("none");
        while (!jerry) {
            System.out.println("print 'det' to find the determinent and print 'none' to end the program (case sensitive!)");
            input = scanner.nextLine();
            if(input.equals(none))
                jerry = true;
            else if(input.equals(det)){
                determi(matrix , Integer.parseInt(rowC), Integer.parseInt(colC));
                jerry = true;
            }else{
                System.out.println("that was not one of the options! D:<");
            }
                
            
            
        }

        scanner.close();
    } // end main

    /*
     * to find the determinant
     */
    public static void determi(int mat[][], int row , int col){
        if( row != col){
            System.out.print("only square matrices can have a determinent!!");
        }
        if( row ==2){
            System.out.println("the determinent of this matrix is  " + twoByTwo(mat));
        }else {
            System.out.println("the determinent of this matrix is  " + recurs(mat, row));
        }
        /*int[][][] ahah = new int[row-1][row-1][row];
        if(row > 2){
            for(int z = 0; z < row; z++){
                for(int i = 0; i< row-1;i++){
                    for(int j = 0; j<row-1;j++){
                        ahah[i][j][z] = mat[row-i][row-j];
                    }
                }
            } IDEA OF A 3D MATRIX 
        }*/

        /*if(row == 3){
            int[][] won = new int[2][2];
            int[][] tue = new int[2][2];
            int[][] tree = new int[2][2];

            for(int i = 0; i<2; i++){
                for(int j = 0; j<2; j++){
                    won[i][j] = mat[i+1][j+1];
                }
            }

            for(int i = 0; i<2; i++){
                for(int j = 0; j<2; j++){
                    tree[i][j] = mat[i][j+1];
                }
            }

            for(int i = 0; i<2; i++){
                for(int j = 0; j<2; j++){
                    tue[i][j] = mat[i+(i%2)][j+1];
                }
            }

            determinent = (mat[0][0]*determi(won,2,2)) - (mat[1][0]*determi(tue,2,2)) + (mat[2][0]*determi(tree,2,2));
            return determinent;

        }*/

    }

    public static int recurs(int mat[][], int size){
        if(size == 2){
            return twoByTwo(mat);
        }
        double det = 0;
        int[][] pat = new int[size-1][size-1];


        for(int i = 0; i< size; i++){// the counter for the first row of a11 a12 ... etc;

            for(int x = 0; x <size-1; x++ ){
                int z = 0;
                for(int y = 0; y < size-1; y++){
                    // make it so that the value only gets inputed if y!= i
                    if(z == i)
                        z++;
                    
                    pat[x][y] = mat[x+1][z];
                    z++;
                }
            }





            det = det+ (Math.pow(-1, 1+i)*mat[0][i]*recurs(pat, size-1));
        }
        int caca = (int) det;
        return -caca; // got no clue why the det becomes neg but oh well
    }

    public static int twoByTwo(int mat[][]){
        int ad = mat[0][0]*mat[1][1];
        int bc = mat[1][0]*mat[0][1];
        int det = ad-bc;
        return det;
    }

    public static void print2D(int mat[][])
    {
        // Loop through all rows
        for (int[] row : mat)
            System.out.println(Arrays.toString(row));
    }

} // end of file 
