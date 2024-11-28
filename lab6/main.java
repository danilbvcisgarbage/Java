public class main {
    public static void main(String[] args) {
        // Створення об'єктів Coffee
        Coffee espresso = new Coffee("Espresso", 0.3, 0.2, 50, 9) {};
        Coffee latte = new Coffee("Latte", 0.5, 0.4, 70, 8) {};

        // Створення списку CoffeeList
        CoffeeList<Coffee> coffeeList = new CoffeeList<>();
        coffeeList.add(espresso);
        coffeeList.add(latte);

        // Виведення даних
        System.out.println("Розмір списку: " + coffeeList.size());
        System.out.println("Перший елемент: " + coffeeList.get(0));
        System.out.println("Другий елемент: " + coffeeList.get(1));
    }
}
