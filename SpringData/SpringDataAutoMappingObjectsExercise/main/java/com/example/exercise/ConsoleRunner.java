package com.example.exercise;

import com.example.exercise.exceptions.UserNotLoggedInException;
import com.example.exercise.exceptions.ValidationException;
import com.example.exercise.services.ExecutorService;
import com.example.exercise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private ExecutorService executorService;

    @Autowired
    public ConsoleRunner(ExecutorService executorService) {
        this.executorService = executorService;
    }




    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        String result;

        try {
            result = executorService.execute(command);
        }catch (ValidationException | UserNotLoggedInException exception){
            result = exception.getMessage();
        }

        System.out.println(result);

    }
}
