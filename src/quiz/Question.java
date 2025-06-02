package quiz;

public class Question {
    private String questionText;
    private String[] options;
    private char correctAnswer;

    public Question(String questionText, String[] options, char correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public void display() {
        System.out.println(questionText);
        char optionLetter = 'A';
        for (String option : options) {
            System.out.println(optionLetter + ") " + option);
            optionLetter++;
        }
    }

    public boolean isCorrect(char answer) {
        return Character.toUpperCase(answer) == correctAnswer;
    }
}

