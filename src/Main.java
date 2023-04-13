public class Main {
    public static void main(String[] args) {
        char[] characters = {'d', 'K', 'Q', 'J', 't', 'n'};
        int[] probabilities = {30, 20, 20, 15, 10, 5};
        MessageGenerator generator = new MessageGenerator(characters, probabilities);
        String message = generator.generateRandomMessage(1200);
        Huffman huffman = new Huffman(message);
        String encodedMessage = huffman.encode();
        String decodedMessage = huffman.decode(encodedMessage);
        double factorCompression = huffman.calculateCompressionFactor();
        double entropy = huffman.calculateEntropy();

        System.out.println("Mensaje original: " + message);
        System.out.println("Mensaje codificado: " + encodedMessage);
        System.out.println("Mensaje decodificado: " + decodedMessage);
        System.out.println("Factor de compresion: " + factorCompression);
        System.out.println("Entropía: " + entropy);

        //Factor de compresion para diferentes tamanos:
        //Para longitud de 1200 simbolos: 3.236682400539447
        //Para longitud de 1500 simbolos: 3.2626427406199023
        //Para longitud de 2500 simbolos: 3.3041467041136627
        //Para longitud de 5000 simbolos: 3.2781511227667597

        /*Como podemos observar, el factor de compresion que se alcanza con diferentes
         longitudes es muy parecida en todos los tamanos. Podemos decir entonces, que Huffman
         es capaz de comprimir los mensajes de una manera muy estable para cualquier
         longitud. Al tener un factor aproximado de 3, podemos decir que hemos reducido 1/3
         su tamano original, lo cual creemos que es bastante eficiente.

         El factor de compresion y la entropia guardan cierta relacion, ya que podemos decir que
         si el factor de compresion es igual a la entropia, podemos decir que el algoritmo que
         hemos implementado, es totalmente optimo. Si el factor de compresion, es mucho mas grande
         que la entropia, podriamos decir que el algoritmo no es eficiente. Contra mas distancia
         haya entre el factor de compresion y la entropia, menor sera la eficiencia.

         */


    }
}