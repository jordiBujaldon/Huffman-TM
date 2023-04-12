public class Main {
    public static void main(String[] args) {
        char[] characters = {'d', 'K', 'Q', 'J', 't', 'n'};
        int[] probabilities = {30, 20, 20, 15, 10, 5};
        MessageGenerator generator = new MessageGenerator(characters, probabilities);
        String message = generator.generateRandomMessage(1200);
        Huffman huffman = new Huffman(message);
        String encodedMessage = huffman.encode();
        String decodedMessage = huffman.decode(encodedMessage);

        System.out.println("Mensaje original: " + message);
        System.out.println("Mensaje codificado: " + encodedMessage);
        System.out.println("Mensaje decodificado: " + decodedMessage);
    }
}