package WorkingWithAbstractionLab.P03StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> Students;

    public StudentSystem() {
        this.Students = new HashMap<>();
    }

    public Map<String, Student> getStudents() {
        return this.Students;
    }

    public void ParseCommand(String[] args) {

        String command = args[0];
        String name = args[1];
        if (command.equals("Create")) {
            int age = Integer.parseInt(args[2]);
            double grade = Double.parseDouble(args[3]);
            if (!Students.containsKey(name)) {
                var student = new Student(name, age, grade);
                Students.put(name, student);
            }

        } else if (command.equals("Show")) {

            Student student = Students.get(name);
            if (student != null) {
                System.out.println(student.getInfo());
            }

        }
    }
}
