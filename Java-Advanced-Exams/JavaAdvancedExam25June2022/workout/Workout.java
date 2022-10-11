package JavaAdvancedExam25June2022.workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private List<Exercise> exercises;
    String type;
    int exerciseCount;

    public Workout (String type, int exerciseCount){
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise (Exercise exercise){
        if (this.exercises.size() < exerciseCount){
        this.exercises.add(exercise);
        }
    }


    public boolean removeExercise (String name, String muscle){
        boolean forRemove = false;
        Exercise exerciseForRemove = null;
        for (Exercise exercise : this.exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)){
                forRemove = true;
                exerciseForRemove = exercise;
            }

        }
        if (forRemove){
            this.exercises.remove(exerciseForRemove);
            return true;
        }else {
            return false;
        }
    }

    public Exercise getExercise (String name, String muscle){
        Exercise exercise = null;

        for (Exercise exercise1 : this.exercises) {
            if (exercise1.getName().equals(name) && exercise1.getMuscle().equals(muscle)){
                exercise = exercise1;
            }
        }

        return exercise;
    }

    public Exercise getMostBurnedCaloriesExercise(){
        if (this.exercises.isEmpty()){
            return null;
        }else {
            int mostBurnedCalories = Integer.MIN_VALUE;
            Exercise most = null;
            for (Exercise exercise : this.exercises) {
                int currentExercise = exercise.getBurnedCalories();
                if (currentExercise >= mostBurnedCalories){
                    mostBurnedCalories = currentExercise;
                    most = exercise;
                }
            }
            return most;
        }
    }

    public int getExerciseCount (){
        return this.exercises.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Workout type: " + this.type);
        sb.append("\n");
        for (Exercise exercise : this.exercises) {
            sb.append(exercise);
            sb.append("\n");
        }

        return sb.toString().trim();
    }
}
