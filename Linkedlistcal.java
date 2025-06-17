import java.util.LinkedList;
import java.util.Scanner;

public class Linkedlistcal {

    public static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    public static double applyOperation(double a, double b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
            default: return 0;
        }
    }

    public static boolean isParenthesesBalanced(String expression) {
        int openCount = 0, closeCount = 0;

        for (char c : expression.toCharArray()) {
            if (c == '(') openCount++;
            else if (c == ')') closeCount++;
        }

        return openCount == closeCount;
    }

    public static String fixParentheses(String expression, Scanner sc) {
        int openCount = 0, closeCount = 0;

        for (char c : expression.toCharArray()) {
            if (c == '(') openCount++;
            else if (c == ')') closeCount++;
        }

        if (openCount > closeCount) {
            System.out.println("You have a missing closing parenthesis. Where would you like to place it? (Enter position index)");
            int position = sc.nextInt();
            sc.nextLine();
            expression = expression.substring(0, position) + ")" + expression.substring(position);
        } else if (closeCount > openCount) {
            System.out.println("You have a missing opening parenthesis. Where would you like to place it? (Enter position index)");
            int position = sc.nextInt();
            sc.nextLine();
            expression = expression.substring(0, position) + "(" + expression.substring(position);
        }

        return expression;
    }
    

    public static double evaluateExpression(String expression, LinkedList<Double> evenNumbers, LinkedList<Double> oddNumbers) {
        LinkedList<Double> values = new LinkedList<>();
        LinkedList<Character> operators = new LinkedList<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == ' ') continue;

            if (Character.isDigit(c)) {
                double num = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                i--;

                if ((int)num % 2 == 0) {
                    evenNumbers.add(num);
                } else {
                    oddNumbers.add(num);
                }

                values.add(num);
            } else if (c == '(') {
                operators.add(c);
            } else if (c == ')') {
                while (!operators.isEmpty() && operators.getLast() != '(') {
                    double b = values.removeLast();
                    double a = values.removeLast();
                    char op = operators.removeLast();
                    values.add(applyOperation(a, b, op));
                }
                operators.removeLast();
            } else {
                while (!operators.isEmpty() && precedence(operators.getLast()) >= precedence(c)) {
                    double b = values.removeLast();
                    double a = values.removeLast();
                    char op = operators.removeLast();
                    values.add(applyOperation(a, b, op));
                }
                operators.add(c);
            }
        }

        while (!operators.isEmpty()) {
            double b = values.removeLast();
            double a = values.removeLast();
            char op = operators.removeLast();
            values.add(applyOperation(a, b, op));
        }

        return values.removeLast();
    }

    public static void printLinkedList(String label, LinkedList<Double> list) {
        System.out.print(label + ": ");
        for (Double num : list) {
            System.out.print(num + " -> ");
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hey! Welcome to the Linked List Calculator.");

        while (true) {
            System.out.print("Enter a mathematical expression (use parentheses if needed): ");
            String expression = sc.nextLine();

            if (!isParenthesesBalanced(expression)) {
                expression = fixParentheses(expression, sc);
                System.out.println("Updated expression: " + expression);
            }

            LinkedList<Double> evenNumbers = new LinkedList<>();
            LinkedList<Double> oddNumbers = new LinkedList<>();

            double result = evaluateExpression(expression, evenNumbers, oddNumbers);
            System.out.println("Result: " + result);
            printLinkedList("Even Numbers", evenNumbers);
            printLinkedList("Odd Numbers", oddNumbers);

            System.out.print("Do you want to perform another calculation? (yes): ");
            String answer = sc.nextLine().trim().toLowerCase();
            if (!answer.equals("yes")) {
                System.out.println("Exiting Calculator. Goodbye!");
                break;
            }
        }
        sc.close();
    }
}