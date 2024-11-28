public class CoffeeTruckApp {
    public static void main(String[] args) {
        Truck truck = new Truck();

        // Додавання кави до фургона
        truck.addCoffee(new BeanCoffee("Arabica", 1.0, 0.8, 10.5, 8.5));
        truck.addCoffee(new GroundCoffee("Robusta", 1.2, 1.0, 12.0, 7.2));
        truck.addCoffee(new InstantCoffeeInCan("Instant Gold", 0.5, 0.4, 5.0, 9.0));
        truck.addCoffee(new InstantCoffeeInPouch("Quick Brew", 0.3, 0.25, 4.5, 8.0));

        // Виведення всіх товарів
        System.out.println("Cargo before sorting:");
        truck.printCargo();

        // Сортування за ціною/вагою
        truck.sortByPriceWeight();
        System.out.println("\nCargo after sorting by price/weight:");
        truck.printCargo();

        // Пошук кави за якістю
        Coffee foundCoffee = truck.findCoffeeByQualityRange(8.0, 9.0);
        if (foundCoffee != null) {
            System.out.println("\nFound coffee with quality in range [8.0, 9.0]: " + foundCoffee);
        } else {
            System.out.println("\nNo coffee found in the quality range.");
        }
    }
}
