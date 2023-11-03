public class Solution {
    public boolean[][] dupe; // checks for any letters that we reused

    private boolean search(char[][]board, String word, int i, int j, int index){
        if(index == word.length()){ // if the index equals the word length, returns true
            return true;
        }

        if(i >= 4 || i < 0 || j >= 4 || j < 0 || board[i][j] != word.charAt(index) || dupe[i][j] == true){
            return false; // returns false if letter is not on board, the letter was already used
        }

        dupe[i][j] = true;
        int [] rowchangeIndex = {-1,-1, 0, 1,1,1,0,-1}; //row index change, used to check all 8 positions
        int [] colchangeIndex = { 0,-1,-1,-1,0,1,1, 1}; //column index change, used to check all 8 positions
        for(int r=0; r < 8; r++){ // goes through each number in rowchangeIndex and colchangeIndex
            // takes each number and puts it into a variable
            int r1 =  rowchangeIndex[r];
            int c1 =  colchangeIndex[r];
            if(search(board, word, i-r1, j-c1, index+1)){ // uses search to check if it's on the board
                return true;
            }

        }

        // if word isn't found on board return false
        dupe[i][j] = false;
        return false;
    }



    public boolean is_there(char[][] board, String word) {

        dupe = new boolean[4][4]; // array of all letters on board

        // goes through each letter on board to check if it's even on the board
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }

        return false; // returns false if there's a letter that isn't on the board
    }

}
