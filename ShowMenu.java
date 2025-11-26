public class ShowMenu {
    static void showMenu() {
        System.out.println("\nСписок товаров:");
        for (int i = 0; i < Products.productNames.length; i++) {
            System.out.println((i + 1) + " - " + Products.productNames[i] + " (" + Products.productPrices[i] + " руб)");
        }
        System.out.println(Main.EXIT_CODE + " - Выход");
    }
}
