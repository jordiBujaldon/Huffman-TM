public class Node {

    private char value;
    private int probability;
    private Node left, right;

    public Node(char value, int probability) {
        this.value = value;
        this.probability = probability;
    }

    public Node(int probability, Node left, Node right) {
        this.value = '\0';
        this.probability = probability;
        this.left = left;
        this.right = right;
    }

    public char getValue() {
        return value;
    }

    public int getProbability() {
        return probability;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}
