// player entity guarda os atributos dos usuarios

package entity;

public class Player {


    public String name;
    public int score;
    public int level;
    public int time;

    public Player( int level, String name, int score, int time) {
        this.level = level;
        this.name = name;
        this.score = score;
        this.time = time;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
