import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Лабораторна робота №1");
        System.out.println("Варіант 2");
        System.out.println();

        // Завдання 1
        System.out.println("===== Завдання 1 =====");
        System.out.println("F = 1 / (xy) + (x - y) / (x^2 + y^2)");
        System.out.println();

        System.out.println("1) Дійсні дані -> дійсний результат");
        System.out.print("Введіть x: ");
        double x1 = input.nextDouble();
        System.out.print("Введіть y: ");
        double y1 = input.nextDouble();

        double result1 = 1.0 / (x1 * y1)
                + (x1 - y1) / (x1 * x1 + y1 * y1);

        System.out.println("Результат = " + result1);
        System.out.println();

        System.out.println("2) Цілі дані -> дійсний результат");
        System.out.print("Введіть x: ");
        int x2 = input.nextInt();
        System.out.print("Введіть y: ");
        int y2 = input.nextInt();

        double result2 = 1.0 / (x2 * y2)
                + (double) (x2 - y2) / (x2 * x2 + y2 * y2);

        System.out.println("Результат = " + result2);
        System.out.println();

        System.out.println("3) Дійсні дані -> цілий результат");
        System.out.print("Введіть x: ");
        double x3 = input.nextDouble();
        System.out.print("Введіть y: ");
        double y3 = input.nextDouble();

        double result3 = 1.0 / (x3 * y3)
                + (x3 - y3) / (x3 * x3 + y3 * y3);

        int integerResult = (int) result3;

        System.out.println("Результат = " + integerResult);
        System.out.println();


        // Завдання 2
        System.out.println("===== Завдання 2 =====");

        System.out.print("Введіть кількість точок n: ");
        int n = input.nextInt();

        System.out.print("Введіть радіус r: ");
        double r = input.nextDouble();

        double[] a = new double[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            System.out.print("Введіть a[" + (i + 1) + "]: ");
            a[i] = input.nextDouble();
        }

        int count = 0;

        for (int i = 0; i < 2 * n; i += 2) {
            double x = a[i];
            double y = a[i + 1];

            if (x * x + y * y <= r * r) {
                count++;
            }
        }

        System.out.println("Кількість точок у крузі = " + count);
        System.out.println();


        // Завдання 3
        System.out.println("===== Завдання 3 =====");

        System.out.print("Введіть розмір матриці n: ");
        int size = input.nextInt();

        double[][] matrix = new double[size][size];

        System.out.println("Введіть елементи матриці:");

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("X[" + i + "][" + j + "] = ");
                matrix[i][j] = input.nextDouble();
            }
        }

        boolean[] logicalVector = new boolean[size];

        for (int i = 0; i < size; i++) {
            int negative = 0;
            int positive = 0;

            for (int j = 0; j < size; j++) {
                if (matrix[i][j] < 0) {
                    negative++;
                } else if (matrix[i][j] > 0) {
                    positive++;
                }
            }

            logicalVector[i] = negative > positive;
        }

        System.out.println("Логічний вектор L:");

        for (int i = 0; i < size; i++) {
            System.out.println("L[" + i + "] = " + logicalVector[i]);
        }

        System.out.println();


        // Завдання 4
        System.out.println("===== Завдання 4 =====");

        input.nextLine();

        System.out.print("Введіть текст: ");
        String text = input.nextLine();

        String[] words = text.split("[\\s,.;:!?()\\[\\]{}\"'-]+");

        int maxLength = 0;

        for (String word : words) {
            if (!word.isEmpty() && word.length() > maxLength) {
                maxLength = word.length();
            }
        }

        StringBuilder resultText = new StringBuilder();
        String[] parts = text.split("(?=[\\s,.;:!?()\\[\\]{}\"'-])|(?<=[\\s,.;:!?()\\[\\]{}\"'-])");

        for (String part : parts) {
            String cleanPart = part.replaceAll("[\\s,.;:!?()\\[\\]{}\"'-]", "");

            if (!cleanPart.isEmpty() && cleanPart.length() == maxLength) {
                continue;
            }

            resultText.append(part);
        }

        System.out.println("Текст після вилучення найдовших слів:");
        System.out.println(resultText.toString());

        input.close();
    }
}