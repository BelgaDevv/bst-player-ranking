package entity;

import entity.Node;
import entity.Player;

public class Ranking {

	private Node root;

	public Ranking() {
		this.root = null;
	}

	// ==========================================
	// 1. INSERT PLAYER
	// ==========================================
	public boolean insert(Player newPlayer) {
		if (searchByScore(newPlayer.getScore()) != null) {
			return false;
		}

		Node newNode = new Node(newPlayer);
		this.root = insert(this.root, newNode);
		return true;
	}

	private Node insert(Node current, Node newNode) {
		if (current == null) {
			return newNode;
		}

		if (newNode.getPlayer().getScore() < current.getPlayer().getScore()) {
			current.setLeft(insert(current.getLeft(), newNode));
		} else {
			current.setRight(insert(current.getRight(), newNode));
		}

		return current;
	}

	// ==========================================
	// 2. SEARCH PLAYER BY SCORE
	// ==========================================
	public Player searchByScore(int scoreToFind) {
		return search(this.root, scoreToFind);
	}

	private Player search(Node current, int scoreToFind) {
		if (current == null) {
			return null;
		}

		if (scoreToFind == current.getPlayer().getScore()) {
			return current.getPlayer();
		}

		if (scoreToFind < current.getPlayer().getScore()) {
			return search(current.getLeft(), scoreToFind);
		}

		return search(current.getRight(), scoreToFind);
	}

	// ==========================================
	// 3. REMOVE PLAYER
	// ==========================================
	public boolean remove(int scoreToRemove) {
		if (searchByScore(scoreToRemove) == null) {
			return false;
		}

		this.root = remove(this.root, scoreToRemove);
		return true;
	}

	private Node remove(Node current, int scoreToRemove) {

		if (current == null) {
			return null;
		}

		if (scoreToRemove < current.getPlayer().getScore()) {
			current.setLeft(remove(current.getLeft(), scoreToRemove));
		} else if (scoreToRemove > current.getPlayer().getScore()) {
			current.setRight(remove(current.getRight(), scoreToRemove));
		}

		else {

			if (current.getLeft() == null && current.getRight() == null) {
				return null;
			}

			if (current.getLeft() == null) {
				return current.getRight();
			} else if (current.getRight() == null) {
				return current.getLeft();
			}

			Node successor = findMinimum(current.getRight());


			Player successorData = successor.getPlayer();


			current.setRight(remove(current.getRight(), successorData.getScore()));


			current.setPlayer(successorData);
		}

		return current;
	}

	// ==========================================
	// 4. UPDATE PLAYER
	// ==========================================
	public boolean update(int originalScore, Player updatedPlayer) {
		Player currentPlayer = searchByScore(originalScore);
		if (currentPlayer == null) {
			return false;
		}

		if (originalScore == updatedPlayer.getScore()) {
			currentPlayer.setName(updatedPlayer.getName());
			currentPlayer.setLevel(updatedPlayer.getLevel());
			currentPlayer.setTime(updatedPlayer.getTime());
			return true;
		}

		if (searchByScore(updatedPlayer.getScore()) != null) {
			return false;
		}


		this.root = remove(this.root, originalScore);


		Player cleanPlayer = new Player(updatedPlayer.getLevel(), updatedPlayer.getName(), updatedPlayer.getScore(), updatedPlayer.getTime());
		insert(cleanPlayer);
		return true;
	}

	// ==========================================
	// 5. SHOW RANKING IN ASCENDING ORDER
	// ==========================================
	public void displayRanking() {
		if (this.root == null) {
			System.out.println("O ranking está vazio.");
			return;
		}
		printInOrder(this.root);
	}

	private void printInOrder(Node current) {
		if (current != null) {
			printInOrder(current.getLeft());
			System.out.println(current.getPlayer());
			printInOrder(current.getRight());
		}
	}

	// ==========================================
	// 6. MOSTRAR MAIOR PONTUAÇÃO
	// ==========================================
	public Player getHighestScore() {
		if (this.root == null) {
			return null;
		}
		return findMaximum(this.root).getPlayer();
	}

	private Node findMaximum(Node current) {
		if (current.getRight() == null) {
			return current;
		}
		return findMaximum(current.getRight());
	}

	// ==========================================
	// 7. SHOW LOWEST SCORE
	// ==========================================
	public Player getLowestScore() {
		if (this.root == null) {
			return null;
		}
		return findMinimum(this.root).getPlayer();
	}

	private Node findMinimum(Node current) {
		if (current.getLeft() == null) {
			return current;
		}
		return findMinimum(current.getLeft());
	}

	// ==========================================
	// 8. SHOW NUMBER OF PLAYERS
	// ==========================================
	public int countPlayers() {
		return countPlayers(this.root);
	}

	private int countPlayers(Node current) {
		if (current == null) {
			return 0;
		}
		return 1
				+ countPlayers(current.getLeft())
				+ countPlayers(current.getRight());
	}

	// ==========================================
	// 9. SHOW TREE SIZE
	// ==========================================
	public int getHeight() {
		return getHeight(this.root);
	}

	private int getHeight(Node current) {
		if (current == null) {
			return 0;
		}

		int leftHeight = getHeight(current.getLeft());
		int rightHeight = getHeight(current.getRight());

		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		}
		return rightHeight + 1;
	}

	// ==========================================
	// 10. SHOW RANKING IN PRE-ORDER
	// ==========================================
	public void displayPreOrder() {
		if (this.root == null) {
			System.out.println("O ranking está vazio.");
			return;
		}
		printPreOrder(this.root);
	}

	private void printPreOrder(Node current) {
		if (current != null) {
			System.out.println(current.getPlayer());
			printPreOrder(current.getLeft());
			printPreOrder(current.getRight());
		}
	}

	// ==========================================
	// 11. SHOW RANKING IN POST-ORDER
	// ==========================================
	public void displayPostOrder() {
		if (this.root == null) {
			System.out.println("O ranking está vazio.");
			return;
		}
		printPostOrder(this.root);
	}

	private void printPostOrder(Node current) {
		if (current != null) {
			printPostOrder(current.getLeft());
			printPostOrder(current.getRight());
			System.out.println(current.getPlayer());
		}
	}
}