package entity;

//ranking entity é a propria árvore binária, ou seja aqui os dados serão estruturados
public class Ranking {

	private Node root;

	public Ranking(Node root) {
		this.root = null;
	}

	// ==========================================
    // 1. INSERIR JOGADOR
    // ==========================================
	public void insert(Player newPlayer) {
		Node newNode = new Node(newPlayer);
		this.root = insertRecursive(this.root, newNode);
	}

	private Node insertRecursive(Node current, Node newNode) {
		if (current == null) {
			return newNode;
		}

		if (newNode.getPlayer().getScore() < current.getPlayer().getScore()) {
			current.setLeft(insertRecursive(current.getLeft(), newNode));
		} else {
			current.setRight(insertRecursive(current.getRight(), newNode));
		}

		return current;
	}

	// ==========================================
    // 2. BUSCAR JOGADOR PELA PONTUAÇÃO
    // ==========================================
	public Player searchByScore(int scoreToFind) {
		return searchRecursive(this.root, scoreToFind);
	}

	private Player searchRecursive(Node current, int scoreToFind) {
		if (current == null) {
			return null;
		}

		if (scoreToFind == current.getPlayer().getScore()) {
			return current.getPlayer();
		}

		if (scoreToFind < current.getPlayer().getScore()) {
			return searchRecursive(current.getLeft(), scoreToFind);
		}

		return searchRecursive(current.getRight(), scoreToFind);
	}

	// ==========================================
    // 3. REMOVER JOGADOR
    // ==========================================
	public void remove(int scoreToRemove) {
		this.root = removeRecursive(this.root, scoreToRemove);
	}

	private Node removeRecursive(Node current, int scoreToRemove) {

		if (current == null) {
			System.out.println("Pontuação não encontrada no ranking.");
			return null;
		}

		if (scoreToRemove < current.getPlayer().getScore()) {
			current.setLeft(removeRecursive(current.getLeft(), scoreToRemove));
		} else if (scoreToRemove > current.getPlayer().getScore()) {
			current.setRight(removeRecursive(current.getRight(), scoreToRemove));
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

			current.setPlayer(successor.getPlayer());

			current.setRight(removeRecursive(current.getRight(), successor.getPlayer().getScore()));
		}

		return current;
	}

	// ==========================================
    // 4. MOSTRAR RANKING EM ORDEM CRESCENTE
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
    // 5. MOSTRAR MAIOR PONTUAÇÃO
    // ==========================================
	public Player getHighestScore() {
		if (this.root == null) {
			return null;
		}
		return findMaximum(this.root).getPlayer();
	}

	 // Método auxiliar recursivo para encontrar o maior valor de uma subárvore
	private Node findMaximum(Node current) {
		if (current.getRight() == null) {
			return current;
		}
		return findMaximum(current.getRight());
	}

	// ==========================================
    // 6. MOSTRAR MENOR PONTUAÇÃO
    // ==========================================
	public Player getLowestScore() {
		if (this.root == null) {
			return null;
		}
		return findMinimum(this.root).getPlayer();
	}
	
	// Método auxiliar recursivo para encontrar o menor valor de uma subárvore
	private Node findMinimum(Node current) {
		if (current.getLeft() == null) {
			return current;
		}
		return findMinimum(current.getLeft());
	}
	
	// ==========================================
    // 7. MOSTRAR QUANTIDADE DE JOGADORES
    // ==========================================
	public int countPlayers() {
		return countPlayersRecursive(this.root);
	}
	
	private int countPlayersRecursive(Node current) {
		if (current == null) {
			return 0;
		}
		return 1
				+ countPlayersRecursive(current.getLeft())
				+ countPlayersRecursive(current.getRight());
	}
}