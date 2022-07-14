package FinalExam1;

import java.util.*;

public class ThePianist {
    static class piece {
        String name;
        String author;
        String key;

        public piece(String name, String author, String key) {
            this.name = name;
            this.author = author;
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPieces = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> pieces = new LinkedHashMap<>();

        for (int i = 0; i < numberOfPieces; i++) {
            String[] currentPiece = scanner.nextLine().split("[\\|]");
            String piece = currentPiece[0];
            String author = currentPiece[1];
            String key = currentPiece[2];

            pieces.putIfAbsent(piece, new ArrayList<>());
            pieces.get(piece).add(author);
            pieces.get(piece).add(key);
        }

        String line = scanner.nextLine();

        while (!line.equals("Stop")) {
            String[] data = line.split("[\\|]");
            String command = data[0];
            switch (command) {
                case "Add":
                    String piece = data[1];
                    if (!pieces.containsKey(piece)) {
                        String composer = data[2];
                        String key = data[3];
                        pieces.put(piece, new ArrayList<>());
                        pieces.get(piece).add(composer);
                        pieces.get(piece).add(key);

                        System.out.printf("%s by %s in %s added to the collection!\n", piece, composer, key);
                    } else {
                        System.out.printf("%s is already in the collection!\n", piece);
                    }
                    break;
                case "Remove":
                    piece = data[1];
                    if (pieces.containsKey(piece)) {
                        pieces.remove(piece);
                        System.out.printf("Successfully removed %s!\n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n", piece);
                    }
                    break;
                case "ChangeKey":
                    piece = data[1];
                    if (pieces.containsKey(piece)) {
                        String newKey = data[2];
                        pieces.get(piece).set(1,newKey);
                        System.out.printf("Changed the key of %s to %s!\n",piece,newKey);
                    }else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n",piece);
                    }
                    break;

            }

            line = scanner.nextLine();
        }

        pieces.forEach((k,v)->{
            System.out.printf("%s -> ",k);
            System.out.printf("Composer: %s, ",v.get(0));
            System.out.printf("Key: %s\n",v.get(1));
        });
    }
}
