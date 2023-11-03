public class Dice {
    public int number_sides; // number of sides
    public char [] letters; // array of letters

    //constructor
    public Dice(int number_sides, char [] letters){
        this.number_sides=number_sides;
        this.letters = letters;
    }

    public Dice(String s){ //constructor with letters for the board
        this.number_sides = s.length();
        this.letters = new char[number_sides];
        for(int i=0; i < letters.length; i++){
            letters[i]=s.charAt(i);
        }
    }

    public  char roll(){
        return letters[(int)(Math.random() * number_sides)]; // randomly returns a letter
    }

}

