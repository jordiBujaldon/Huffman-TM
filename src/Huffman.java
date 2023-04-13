import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman {

    private String message;
    private Node root;
    private Map<Character, String> tableResult;

    public Huffman(String message) {
        this.message = message;
        this.root = buildTable(message);
        this.tableResult = new HashMap<>();
        addBinaryCodification(root, "");
    }

    public Map<Character, String> getTableResult() {
        return tableResult;
    }

    private Node buildTable(String message) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char value : message.toCharArray()) {
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getProbability));

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            pq.offer(node);
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            int sumFrequency = left.getProbability() + right.getProbability();
            Node parent = new Node(sumFrequency, left, right);
            pq.offer(parent);
        }

        return pq.poll();
    }

    private void addBinaryCodification(Node node, String code) {
        if (node.isLeaf()) {
            tableResult.put(node.getValue(), code);
        } else {
            addBinaryCodification(node.getLeft(), code + "0");
            addBinaryCodification(node.getRight(), code + "1");
        }
    }

    public String encode() {
        StringBuilder encodedData = new StringBuilder();

        for (char character : message.toCharArray()) {
            encodedData.append(tableResult.get(character));
        }

        return encodedData.toString();
    }

    public String decode(String encodedMessage) {
        StringBuilder decodedData = new StringBuilder();
        Node current = root;

        for (char character : encodedMessage.toCharArray()) {
            if (character == '0') {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
            if (current.isLeaf()) {
                decodedData.append(current.getValue());
                current = root;
            }
        }

        return decodedData.toString();
    }

    public double calculateCompressionFactor() {
        int originalLength = message.length() * 8; // 8 bits en asciii
        int encodedLength = 0;

        for (char character : message.toCharArray()) {
            encodedLength += tableResult.get(character).length();
        }

        return (double) originalLength / encodedLength;
    }

    public double calculateEntropy() {
        int messageLength = message.length();
        double entropy = 0;

        for (char value : tableResult.keySet()) {
            int frequency = 0;
            for (char c : message.toCharArray()) {
                if (c == value) {
                    frequency++;
                }
            }
            double probability = (double) frequency / messageLength;
            entropy += probability * (Math.log(probability) / Math.log(2));
        }

        return -entropy;
    }
}
