

public class functions {
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

    public void rowswap(int mat[][], int cval, int row1, int row2){ // assume zero index for variables
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
}
