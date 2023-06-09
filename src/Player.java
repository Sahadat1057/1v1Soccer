public class Player {
    private int score;
    private int recentScore;
    private int highScore;

    public Player(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int goalsAdded) {
        score = score + goalsAdded;
    }


}
