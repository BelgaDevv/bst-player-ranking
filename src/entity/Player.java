package entity;

//player entity guarda os atributos dos usuarios
public class Player {
	
	private String name;
	private int score;
	private int level;
	private int time;

	public Player(int level, String name, int score, int time) {
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

	// toString pra poder retornar os dados do jogador no main
	@Override
	public String toString() {
	    return "Nome: " + name +
	           " | Pontuação: " + score +
	           " | Fase: " + level +
	           " | Tempo: " + time;
	}
}