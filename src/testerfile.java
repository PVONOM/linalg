import java.util.*;
import javax.swing.*;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.Color;
import java.math.*;

public class testerfile extends Application{

    @Override
    public void start(Stage arg0) throws Exception{// start the javafx
        Group root = new Group();
        Scene scene = new Scene(root);
        arg0.setScene(scene);

        arg0.show();
    }


    public static void main(String[] args){
        launch(args); // for javafx
        //GUI gui = new GUI();// for jframe

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

    public static void rowswap(int mat[][], int cval, int row1, int row2){ // assume zero index for variables
        int[] temp = new int[cval];
        for(int i = 0; i< cval; i++){
            temp[i] = mat[row1][i];
        }
        for(int k = 0; k< cval; k++){
            mat[row1][k] = mat[row2][k];
        }
        for(int t = 0; t< cval; t++){
            mat[row2][t] = temp[t];
        }
    } // i KNOW this part is hella wordy but thats just how i write it OKAY!

    public static void print2D(int mat[][])
    {
        // Loop through all rows
        for (int[] row : mat)
            System.out.println(Arrays.toString(row));
    }

} // end of file 
