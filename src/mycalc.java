import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mycalc implements ActionListener {
    public static void main(String args[]){
        mycalc start = new mycalc();
    }

    JFrame frame;
    int numrows, numcols;
    JLabel text;
    JPanel panelOne;
    JButton enterButton;
    JTextField rowField;
    JTextField colField;
    JPanel panelZero;
    JButton enterValButton;
    JButton detButton;
    int[][] matrix;
    JLabel[][] dislayedMatrix;
    JTextField[][] textFields;
    JLabel prompt;

    mycalc(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        text = new JLabel();
        text.setBounds(25,20,415,50);
        text.setText("enter the number of Rows and Columns");



        rowField = new JTextField();
        rowField.setBounds(50,200,100,50);
        rowField.setEditable(true);

        prompt = new JLabel();
        prompt.setText("what would you like to do with this?");
        prompt.setBounds(25,350,300, 30 );

        colField = new JTextField();
        colField.setBounds(250,200,100,50);
        colField.setEditable(true);
 

        enterButton = new JButton("enter");
        enterButton.setBounds(150,430,100,50);
        enterButton.addActionListener(this);
        

        frame.add(text);
        frame.add(enterButton);
        frame.add(rowField);
        frame.add(colField);
        frame.add(prompt); prompt.setVisible(false);


        enterValButton = new JButton("enter values");
        enterValButton.setBounds(150,430,120,50);
        enterValButton.addActionListener(this);
        enterValButton.setVisible(false);
        frame.add(enterValButton);

        detButton = new JButton("find determinent");
        detButton.setBounds(150,430,120,50);
        detButton.addActionListener(this);
        detButton.setVisible(false);
        frame.add(detButton);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == enterButton){
                try {
                    numrows = Integer.parseInt(rowField.getText());
                    numcols = Integer.parseInt(colField.getText());
                    text.setText("ENTER THE NUMBER VALUES FOR THE MATRIX");
                    // for future use: MAKE IT FAIL PROOF BY CATCHING WHEN THIS INPUT IS ZERO
                    matrixInput(numrows,numcols);
                } catch (NumberFormatException w) {
                    text.setText("THAT WAS NOT AN INTEGER! TRY AGAIN");
                }
        }
        if(e.getSource() == enterValButton){
            try {
                for(int i = 0; i< numrows;i++){
                    for(int j=0; j< numcols; j++){
                        matrix[i][j]= Integer.parseInt(textFields[i][j].getText()); 
                    }
                }
                text.setText("Success! your matrix is:");
                matrixShow(numrows, numcols);
            } catch (NumberFormatException z) {
                text.setText("THE ENTRIES HAD VALUES THAT WERE NOT INTEGERS. TRY AGAIN");
            }
        }

        if(e.getSource() == detButton){
            detShow();
        }

    }

    private void matrixInput(int rows, int cols){
        panelOne = new JPanel();
        panelOne.setBounds(50,100,300,300);
        textFields = new JTextField[rows][cols];
        panelOne.setLayout(new GridLayout(rows, cols,5,5));
        panelOne.setBackground(Color.BLACK);
        matrix = new int[rows][cols];

        for(int i = 0; i< rows;i++){
            for(int j=0; j< cols; j++){
                textFields[i][j] = new JTextField();
                panelOne.add(textFields[i][j]);
            }
        }
        rowField.setVisible(false);
        colField.setVisible(false);
        frame.add(panelOne);
        enterButton.setVisible(false);

        enterValButton.setVisible(true);

    }

    private void matrixShow(int rows, int cols){
        panelOne.setVisible(false);
        prompt.setVisible(true);

        panelZero = new JPanel();
        panelZero.setBounds(50,100,200,200);
        dislayedMatrix = new JLabel[rows][cols];
        panelZero.setLayout(new GridLayout(rows, cols));

        for(int i = 0; i< rows;i++){
            for(int j=0; j< cols; j++){
                dislayedMatrix[i][j] = new JLabel();
                dislayedMatrix[i][j].setText(String.valueOf(matrix[i][j]));
                panelZero.add(dislayedMatrix[i][j]);
            }
        }
        frame.add(panelZero);
        panelZero.setVisible(true);
        enterValButton.setVisible(false);
        
        detButton.setVisible(true);        
    }

    private void detShow(){
        detButton.setVisible(false);

        if (numcols==numrows) {
            int det = functions.recurs(matrix,numrows);
            prompt.setText("this matrix's determinant is " + det );
        } else {
            prompt.setText("only square matrix have determinant!" );
        }        
    }
}
