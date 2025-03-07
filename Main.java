 import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner keyboard = new Scanner(System.in)) {
            Calculator calculator = new Calculator(); 
            while (true) {
                displayWelcomeMessage();
                String selection = getValidInput(keyboard, "Click 1 to continue.", 1);
                if (selection.equals(1 + "")) {
                    displayCalculatorMessage();
                }

                selection = getValidInput(keyboard, "Click 1 to continue.", 1);
                if (selection.equals(1 + "")) {
                    String career = getCareerChoice(keyboard);
                    if (career.equalsIgnoreCase("Business + Personal Finance")) {
                        handleBusinessFinanceContent(keyboard, calculator);
                    }
                }
            }
        }
    }

    private static void displayWelcomeMessage() {
        System.out.println();
        System.out.println("Welcome to my app! Here, you can learn how to apply the content from Algebra 2&3 to a list of careers");
        System.out.println("you might want to follow without needing to learn the math.");
        System.out.println();
    }

    private static void displayCalculatorMessage() {
        System.out.println();
        System.out.println("Here you can also have a calculator for each of the content so you don't have to write down the math");
        System.out.println("on paper.");
        System.out.println();
    }

    private static String getValidInput(Scanner keyboard, String prompt, int validInput) {
        String selection;
        while (true) {
            System.out.println(prompt);
            selection = keyboard.next();
            keyboard.nextLine();
            if (selection.equals(validInput + "")) {
                break;
            } else {
                System.out.println("Invalid input, try again.");
            }
        }
        return selection;
    }

    private static String getCareerChoice(Scanner keyboard) {
        System.out.println("\nNow choose your career (type the exact name of the career):");
        listOfCareers();
        String career;
        while (true) {
            career = keyboard.nextLine();
            if (checkContainCareer(career)) {
                break;
            } else {
                System.out.println("Invalid career, try again.");
            }
        }
        return career;
    }

    private static void handleBusinessFinanceContent(Scanner keyboard, Calculator calculator) {
        System.out.println("\nChoose your content:");
        System.out.println("    1. Simple Interest");
        System.out.println("    2. Compound Interest");
        String content;
        while (true) {
            content = keyboard.nextLine();
            if (checkContainBusinessContent(content)) {
                break;
            } else {
                System.out.println("Invalid content, try again.");
            }
        }
        if (content.equalsIgnoreCase("Simple Interest")) {
            System.out.println("\nNice choice. This is an important piece of content for borrowing money from banks.");
            System.out.println();
            System.out.println("Would you like to learn how simple interest works?");
            content = keyboard.nextLine();
            checkYesNo(keyboard);
            if (content.equalsIgnoreCase("Yes")) {
                System.out.println("\nThe general formula for simple interest is I = PrT");
                System.out.println("where I equals the interest");
                System.out.println("P is the principal, or the money borrowed");
                System.out.println("r equals the interest rate in %");
                System.out.println("and T is the time (normally in years).");
                System.out.println("\nSimple Interest is really important for student loans. You may need to borrow money for college.");
                System.out.println("What even is simple interest to begin with? It is the money you need to pay back after using it for a certain time.");
                System.out.println("Let's say you borrow $30,000. The federal interest rate is 3.73%, and you need to use the money for 20 years.");
                System.out.println("I = $30000 * 3.73% * 20 = around $22,380, so after using the money you need to pay $22,380.");
                System.out.println("\nWould you like to now calculate the simple interest?");
                content = keyboard.nextLine();
                checkYesNo(keyboard);
                if (content.equalsIgnoreCase("Yes")) {
                    System.out.println("Enter how much money you need to borrow:");
                    double principal = keyboard.nextDouble();
                    keyboard.nextLine();
                    System.out.println("What is the federal interest rate?");
                    double rate = keyboard.nextDouble();
                    keyboard.nextLine();
                    System.out.println("Finally, how many years do you need to use it?");
                    int time = keyboard.nextInt();
                    keyboard.nextLine();
                    double interest = calculator.simpleInterestDealer(principal, rate, time); 
                    System.out.println("You need to pay back at or around $" + interest);
                }
            }
        } else if (content.equalsIgnoreCase("Compound Interest")) {
            System.out.println("Great choice! Compound interest is crucial for understanding investments and savings.");
            System.out.println();
        } 
    }

    public static boolean checkContainCareer(String career) {
        return career.equalsIgnoreCase("Business + Personal Finance");
    }

    private static String checkYesNo(Scanner keyboard) {
        String input;
        while (true) {
            input = keyboard.nextLine();
            if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no")) {
                break;
            } else {
                System.out.println("Invalid input, try again.\n");
            }
        }
        return input;
    }
    
    public static boolean checkContainBusinessContent(String content) {
        return content.equalsIgnoreCase("Simple Interest") || content.equalsIgnoreCase("Compound Interest");
    }

    public static void listOfCareers() {
        System.out.println("    1. Business + Personal Finance");
    }
}