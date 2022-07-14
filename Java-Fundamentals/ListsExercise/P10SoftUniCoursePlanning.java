package ListsExercise;

import java.util.*;
import java.util.stream.Collectors;

public class P10SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> courses = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String line = scanner.nextLine();

        while (!line.equals("course start")) {
            String[] input = line.split(":");
            String command = input[0];

            switch (command) {
                case "Add":
                    String lesson = input[1];
                    boolean isHere = courses.contains(lesson);
                    if (!isHere) {
                        courses.add(lesson);
                    }
                    break;
                case "Insert":
                    lesson = input[1];
                    int index = Integer.parseInt(input[2]);

                    isHere = courses.contains(lesson);
                    if (!isHere) {
                        if (index >= 0 && index < courses.size()){
                        courses.add(index, lesson);
                        }
                    }
                    break;
                case "Remove":
                    lesson = input[1];
                    String lessonEx = "Exercise-" + lesson;
                    courses.remove(lesson);
                    courses.remove(lessonEx);
                    break;
                case "Swap":
                    String firstLesson = input[1];
                    String secondLesson = input[2];

                    String firstLessonEx = firstLesson + "-Exercise";
                    String secondLessonEx = secondLesson + "-Exercise";

                    if (courses.contains(firstLesson) && courses.contains(secondLesson)){
                        Collections.swap(courses,courses.indexOf(firstLesson),courses.indexOf(secondLesson));
                    }
                    if (courses.contains(firstLessonEx)){
                        courses.remove(firstLessonEx);
                        courses.add(courses.indexOf(firstLesson) + 1,firstLessonEx);
                    }
                    if (courses.contains(secondLessonEx)){
                        courses.remove(secondLessonEx);
                        courses.add(courses.indexOf(secondLesson) + 1,secondLessonEx);
                    }



                    break;
                case "Exercise":
                    lesson = input[1];
                    String exercise = lesson + "-Exercise";
                    if (courses.contains(lesson) && !courses.contains(exercise)){
                        courses.add(courses.indexOf(lesson) + 1, exercise);
                    } else if (!courses.contains(lesson)){
                         courses.add(lesson);
                         courses.add(exercise);
                    }
//                    lesson = input[1];
//                    boolean exist = courses.contains(lesson);
//                    if (exist) {
//                        int lessonIndex = courses.indexOf(lesson);
//                        String exercise = lesson + "-Exercise";
//                        courses.add(lessonIndex + 1, exercise);
//                    } else {
//                        String exercise = lesson + "-Exercise";
//                        courses.add(lesson);
//                        courses.add(exercise);
//
//                    }


                    break;
            }

            line = scanner.nextLine();
        }

        for (int i = 0; i < courses.size(); i++) {
            System.out.printf("%d.%s\n", i + 1, courses.get(i));
        }
    }
}
