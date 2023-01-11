package WorkingWithAbstractionExercise.P04TrafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> signals = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        List<TrafficLight> trafficLights = new ArrayList<>();

        for (String signal : signals) {
            Color current = Color.valueOf(signal);
            TrafficLight trafficLight = new TrafficLight(current);
            trafficLights.add(trafficLight);
        }

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.changeColor();
                System.out.print(trafficLight.getColor() + " ");
            }
            System.out.println();
        }
    }
}
