// classe que cria o nó manual.
// Ela recebe o objeto Player inteiro no construtor e possui os ponteiros de amarração.

package entity;

public class Node {

    private Player player; // O nó carrega o objeto Player inteiro aqui dentro
    private Node left;   // Ponteiro para o nó da esquerda
    private Node right;  // Ponteiro para o nó da direita

    public Node(Player player) {
        this.player = player;
        this.left = null;
        this.right = null;
    }

    // Getters e Setters para o nó conseguir se conectar
    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }
    public Node getLeft() { return left; }
    public void setLeft(Node left) { this.left = left; }
    public Node getRight() { return right; }
    public void setRight(Node right) { this.right = right; }
}

