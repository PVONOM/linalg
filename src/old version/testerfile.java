

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class testerfile extends Application{ // I GIVE UP ON USING JAVAFX I WILL USE SWING INSTEAD 

    Button butt;
    Scene scene1;
    Label boob;

    Button second;
    Scene secondScene;
    Label secondLabel;

    Scene matrixSizeInput;
    Button enter;
    Label RC;

    Stage stage;

    @Override
    public void start(Stage stagenull) throws Exception{// start the javafx

        stage = stagenull; // for the stage setup

        // instance of the GUIfuctions
        buttonFuctions click = new buttonFuctions();

        //1st button
        butt = new Button();
        butt.setText("click da button");
        butt.setOnAction(click);// creates function of the button 
        boob = new Label("this is scene 1");


        // 2nd button
        second = new Button();
        second.setText("if this displays, the scene is correctly changed");
        second.setOnAction(click);
        secondLabel = new Label("this is scene 2, click the button again to enter matrix numbers");

        //3rd button and scene
        HBox size = new HBox(10);
        enter = new Button();
        enter.setText("enter");
        enter.setOnAction(click);
        RC = new Label("enter the values for # of rows and # of cols");
        TextField rowField = new TextField("3");
        TextField coField = new TextField("3");
        size.getChildren().addAll(enter,RC, rowField, coField); // WORK ON THIS TOMORROW 
        matrixSizeInput = new Scene(size);


        // makes pane
        BorderPane pane = new BorderPane(); //THIS PART IS NOT USED YET
        pane.setCenter(butt); // layout pane

        //Group root = new Group(); // what is difference between group, pane? idk what a group is
        Scene scene = new Scene(pane, Color.AQUA); // basically the window 



        // makes vbox? pane?
        VBox pane1 = new VBox(10);
        pane1.getChildren().addAll(butt,boob);
        // scene asociated w/ this panel
        scene1 = new Scene(pane1);
    
        // makes vbox for 2nd scene
        VBox paneTwo = new VBox(10);
        paneTwo.getChildren().addAll(second,secondLabel);
        // scene asociated w/ this panel
        secondScene = new Scene(paneTwo);
  

        stage.setWidth(640); 
        stage.setHeight(480);  
        stage.setResizable(false);

        stage.setScene(scene1);
        stage.setTitle("linear algebra");
        stage.show();



        
    }// 640x480

        public void startButtonClick(){
            //GUIfunctions.buttonClick();

            stage.setScene(secondScene);
            //BorderPane dim = new BorderPane();

        }

        public void secndButtClick(){
            stage.setScene(matrixSizeInput);
        }
        

    public static void main(String[] args){
        launch(args); // for javafx
        //GUI gui = new GUI();// for jframe
    }

    private class buttonFuctions implements EventHandler<ActionEvent>{
        @Override public void handle(ActionEvent e){
            if(e.getSource()== butt)
                startButtonClick();


            if(e.getSource()==second){
                secndButtClick();
            }
        }

    }


}















        /*Scanner scanner = new Scanner(System.in);       
        boolean jerry = false;
        String rowC = new String("????");
        String colC = new String("????");
        /*
         * accepts the RxC dimentions 
         *
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
        scanner.close();*/
    //} // end main


    /*int Click = 0;
     *
     * button click
     *
    public void buttonClick(){
        Click++;

        if(Click >0){
            butt.setText("this button has no function");
        }
    }*/

    

    /*
     * to find the determinant
     *
    public static void determi(int mat[][], int row , int col){
        if( row != col){
            System.out.print("only square matrices can have a determinent!!");
        }
        if( row ==2){
            System.out.println("the determinent of this matrix is  " + functions.twoByTwo(mat));
        }else {
            System.out.println("the determinent of this matrix is  " + functions.recurs(mat, row));
        }
    }*/

    /*public static int recurs(int mat[][], int size){
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
    } // i KNOW this part is hella wordy but thats just how i write it OKAY!*/

    /* 
    THIS IS THE OLD PRINT FUNCTION
    public static void print2D(int mat[][])
    {
        // Loop through all rows
        for (int[] row : mat)
            System.out.println(Arrays.toString(row));
    }*/

//} // end of file 
