public class Board {
    // this is an nxn board
    public int side_size; // size by size
    int total_size;
    public Dice[] diceSet; // initial set of Dice objects
    public Dice[][] diceLayout; // The board is a size by size layout of Dice object
    public char[][] charLayout; // the char layout of the board after all dice rolled


    // Create an array of 16 Dice objects. Calling Dice constructor with the char values as strings.
    void createDiceset() {
        diceSet = new Dice[16];
        diceSet[0] = new Dice("RIFOBX");
        diceSet[1] = new Dice("IFEHEY");
        diceSet[2] = new Dice("DENOWS");
        diceSet[3] = new Dice("UTOKND");
        diceSet[4] = new Dice("HMSRAO");
        diceSet[5] = new Dice("LUPETS");
        diceSet[6] = new Dice("ACITOA");
        diceSet[7] = new Dice("YLGKUE");
        diceSet[8] = new Dice("QBMJOA");
        diceSet[9] = new Dice("EHISPN");
        diceSet[10] = new Dice("VETIGN");
        diceSet[11] = new Dice("BALIYT");
        diceSet[12] = new Dice("EZAVND");
        diceSet[13] = new Dice("RALEDC");
        diceSet[14] = new Dice("UWILRG");
        diceSet[15] = new Dice("PACEMD");
    }

    //constructors
    // diceset amount is a perfect square
    public Board() {
        int diceAssignedNum;
        side_size = 4;
        createDiceset(); // calling the method to create all the dice for this board.
        total_size = side_size * side_size;
        diceLayout = new Dice[side_size][side_size]; // Dice Layout - position of each dice on the board
        charLayout = new char[side_size][side_size]; // char layout - letter shown on the board

        // Create a boolean array to "shadow" the diceset; set to all false
        boolean[] diceAssigned = new boolean[total_size];
        //set all booleans to false;
        for (int i = 0; i < diceAssigned.length; i++) {
            diceAssigned[i] = false;
        }

        // Assigns the Dice randomly to the board. Each rolling for a char value
        for (int r = 0; r < side_size; r++) {
            for (int c = 0; c < side_size; c++) {
                do {
                    diceAssignedNum = (int) (Math.random() * 16);
                } while (diceAssigned[diceAssignedNum] == true); // roll again if the dice at r,c is assigned
                diceAssigned[diceAssignedNum] = true;

                diceLayout[r][c] = diceSet[diceAssignedNum];
                charLayout[r][c] = diceLayout[r][c].roll();
            }
        }
    }

    // Prints the board on the screen.
    public void printBoard() {
        for (char[] r : charLayout) {
            for (char c : r) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}