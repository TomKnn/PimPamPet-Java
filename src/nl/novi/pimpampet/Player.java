package nl.novi.pimpampet;

public class Player {

    // attributen
    private final String name;
    private int score;


    // constructors
    public Player(String name, int score) {
        this.score = score;
        this.name = name;
    }

    //methodes / functies
    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public void addScore() {
        score++;
    }
}




