package service;

import entity.Player;
import entity.Ranking;


public class RankingService {

	private Ranking ranking;

	public RankingService() {
		this.ranking = new Ranking();
	}

	public boolean createPlayer(String name, int score, int level, int time) {
		Player player = new Player(level, name, score, time);
		return ranking.insert(player);
	}

	public Player findPlayerByScore(int score) {
		return ranking.searchByScore(score);
	}

	public boolean updatePlayer(int originalScore, String name, int newScore, int level, int time) {
		Player updatedPlayer = new Player(level, name, newScore, time);
		return ranking.update(originalScore, updatedPlayer);
	}

	public boolean deletePlayer(int score) {
		return ranking.remove(score);
	}

	public void showRankingInOrder() {
		ranking.displayRanking();
	}

	public void showRankingPreOrder() {
		ranking.displayPreOrder();
	}

	public void showRankingPostOrder() {
		ranking.displayPostOrder();
	}

	public Player getHighestScorePlayer() {
		return ranking.getHighestScore();
	}

	public Player getLowestScorePlayer() {
		return ranking.getLowestScore();
	}

	public int countPlayers() {
		return ranking.countPlayers();
	}

	public int getTreeHeight() {
		return ranking.getHeight();
	}
}
