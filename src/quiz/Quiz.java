package quiz;

import java.io.*;
import java.util.*;

public class Quiz {
    private List<Question> questions = new ArrayList<>();
    private int score = 0;

    public void loadQuestions(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String questionText = line;
                String[] options = new String[4];
                for (int i = 0; i < 4; i++) {
                    options[i] = br.readLine().substring(3);
                }
                char correctAnswer = br.readLine().trim().toUpperCase().charAt(0);
                questions.add(new Question(questionText, options, correctAnswer));
                br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error reading questions: " + e.getMessage());
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        for (Question question : questions) {
            question.display();
            System.out.print("Your answer (A, B, C, D): ");
            char userAnswer = scanner.next().toUpperCase().charAt(0);
            if (question.isCorrect(userAnswer)) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Wrong!\n");
            }
        }
        System.out.println("🎯 Quiz finished! Your score: " + score + "/" + questions.size());
    }
}
