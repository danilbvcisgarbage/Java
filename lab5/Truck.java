import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

class Truck {
    private List<Coffee> cargo;  // Список кави у фургоні

    public Truck() {
        cargo = new ArrayList<>();
    }

    public void addCoffee(Coffee coffee) {
        cargo.add(coffee);
    }

    public void sortByPriceWeight() {
        Collections.sort(cargo, new Comparator<Coffee>() {
            @Override
            public int compare(Coffee coffee1, Coffee coffee2) {
                return Double.compare(coffee1.getPrice() / coffee1.getWeight(), coffee2.getPrice() / coffee2.getWeight());
            }
        });
    }

    public Coffee findCoffeeByQualityRange(double minQuality, double maxQuality) {
        for (Coffee coffee : cargo) {
            if (coffee.getQuality() >= minQuality && coffee.getQuality() <= maxQuality) {
                return coffee;
            }
        }
        return null; // Якщо не знайдено
    }

    public void printCargo() {
        for (Coffee coffee : cargo) {
            System.out.println(coffee);
        }
    }
}
