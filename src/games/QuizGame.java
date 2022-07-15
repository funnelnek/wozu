package games;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {
        int count = 0;
        int correct = 0;
        int incorrect = 0;
        String report = "";
        Scanner input = new Scanner(System.in);
        File questions = new File("src/resources/games-questions.txt");

        try {
            Scanner file = new Scanner(questions);

            while(file.hasNextLine()) {
                String[] qA = file.nextLine().split(",");
                String question = qA[0];
                String answer = qA[1].strip();

                System.out.println(count + ": " + question);
                System.out.print("Enter answer: ");

                String response = input.nextLine();

                if (response.equalsIgnoreCase(answer)) {
                    report += (count + 1) + ": " + question + "\n";
                    correct++;
                } else {
                    report += (count + 1) + ": " + question + " [expected: " + answer + " actual: " + response + "]\n";
                    incorrect++;
                }

                count++;
            }

            System.out.println("\nResult " + correct + "/" + (count) + "   ************");
			System.out.println(report);

        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
