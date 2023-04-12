import java.util.Random;

public class MessageGenerator {

    private char[] characters;
    private int[] probabilities;

    private final Random random = new Random();

    public MessageGenerator(char[] characters, int[] probabilities) {
        assert characters.length == probabilities.length;
        this.characters = characters;
        this.probabilities = probabilities;
    }

    public String generateRandomMessage(int size) {
        StringBuilder message = new StringBuilder();

        for (int i = 0; i < size; i++) {
            message.append(getRandomChar());
        }

        return message.toString();
    }

    private char getRandomChar() {
        int randomNumber = random.nextInt(100);
        int sumProbability = 0;

        for (int i = 0; i < characters.length; i++) {
            sumProbability += probabilities[i];

            if (randomNumber < sumProbability) {
                return characters[i];
            }
        }

        return characters[characters.length - 1];
    }
}
