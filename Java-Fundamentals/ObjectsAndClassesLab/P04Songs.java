package ObjectsAndClassesLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P04Songs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] data = line.split("_");

            String type = data[0];
            String name = data[1];
            String duration = data[2];

            Song song = new Song();

            song.setType(type);
            song.setName(name);
            song.setDuration(duration);

            songs.add(song);

        }

        String typeList = scanner.nextLine();

        if (typeList.equals("all")) {
            for (Song song : songs) {
                System.out.println(song.getName());
            }
        } else {
            for (Song song : songs) {
                if (song.getType().equals(typeList)) {
                    System.out.println(song.getName());
                }
            }
        }

    }

        static class Song {
        private String type;
        private String name;
        private String duration;

        public String getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        public String getDuration() {return duration;}

        public void setType(String type) {
            this.type = type;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }
    }
}
