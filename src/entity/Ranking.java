// ranking entity é a propria árvore binária, ou seja aqui os dados serão estruturados

package entity;

public class Ranking {
    private Node root;

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
    // 2. BUSCAR JOGADOR POR PONTUAÇÃO
    // ==========================================
    public boolean search(int scoreToFind) {
        return searchRecursive(this.root, scoreToFind);
    }

    private boolean searchRecursive(Node current, int scoreToFind) {
        if (current == null) {
            return false;
        }

        if (scoreToFind == current.getPlayer().getScore()) {
            return true;
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

    // Método auxiliar recursivo para encontrar o menor valor de uma subárvore
    private Node findMinimum(Node current) {
        if (current.getLeft() == null) {
            return current;
        }
        return findMinimum(current.getLeft());
    }

    // Método de exibição em ordem decrescente
    public void display() {
        if (this.root == null) {
            System.out.println("O ranking está vazio.");
            return;
        }
        printInOrderReverse(this.root);
    }

    private void printInOrderReverse(Node node) {
        if (node != null) {
            printInOrderReverse(node.getRight());
            System.out.println("Jogador: " + node.getPlayer().getName() + " | Pontos: " + node.getPlayer().getScore());
            printInOrderReverse(node.getLeft());
        }
    }
}

