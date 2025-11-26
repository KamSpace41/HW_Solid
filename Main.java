import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static final int EXIT_CODE = 0;
    static final int MIN_PRODUCT = 1;
    static final int MAX_PRODUCT = 12;

    static ArrayList<String> basket = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runShop();
    }


    static void runShop() {
        System.out.println("=== МАГАЗИН ===");

        while (true) {
            showMenu();
            int choice = getChoice();

            if (choice == EXIT_CODE) {
                checkout();
                break;
            }

            if (isValidProduct(choice)) {
                addToBasket(choice);
            } else {
                System.out.println("Неверный выбор!");
            }
        }
    }


    static void showMenu() {
        System.out.println("\nСписок товаров:");
        for (int i = 0; i < Products.productNames.length; i++) {
            System.out.println((i + 1) + " - " + Products.productNames[i] + " (" + Products.productPrices[i] + " руб)");
        }
        System.out.println(EXIT_CODE + " - Выход");
    }


    static int getChoice() {
        System.out.print("Выбери товар: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }


    static boolean isValidProduct(int choice) {
        return choice >= MIN_PRODUCT && choice <= MAX_PRODUCT;
    }


    static void addToBasket(int productIndex) {
        int index = productIndex - 1;
        basket.add(Products.productNames[index] + " - " + Products.productPrices[index] + " руб");
        System.out.println(Products.productNames[index] + " добавлен в корзину!");
    }


    static void checkout() {
        if (basket.isEmpty()) {
            System.out.println("Корзина пуста. Пока!");
            return;
        }

        System.out.println("\n=== ТВОЯ КОРЗИНА ===");
        double total = 0;

        // DRY: Используем данные из массивов не повторяя код
        for (String item : basket) {
            System.out.println(item);
            String priceStr = item.split(" - ")[1].replace(" руб", "");
            total += Double.parseDouble(priceStr);
        }

        System.out.println("Всего: " + total + " руб");
        System.out.print("Оплатить? (да/нет): ");

        if (scanner.nextLine().equalsIgnoreCase("да")) {
            System.out.println("Спасибо за покупку!");
        } else {
            System.out.println("Заказ отменён");
        }
    }
}


