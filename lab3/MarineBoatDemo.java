import java.util.Arrays;
import java.util.Comparator;

public class MarineBoatDemo {

    /**
     * Основний метод програми.
     */
    public static void main(String[] args) {
        // Створення масиву об'єктів класу MarineBoat
        MarineBoat[] boats = {
                new MarineBoat("Neptune", 2010, 10.0, 35, "Fishing"),
                new MarineBoat("Poseidon", 1999, 12.5, 50, "Cargo"),
                new MarineBoat("Orion", 2005, 15.0, 60, "Cruise"),
                new MarineBoat("Triton", 1999, 10.5, 40, "Patrol"),
                new MarineBoat("Aphrodite", 2015, 8.5, 20, "Leisure")
        };

        System.out.println("Original array:");
        printBoats(boats);

        // Сортування за роком випуску (year) за зростанням, а за довжиною (length) за спаданням
        Arrays.sort(boats, Comparator.comparingInt(MarineBoat::getYear)
                .thenComparing(Comparator.comparingDouble(MarineBoat::getLength).reversed()));

        System.out.println("\nSorted array:");
        printBoats(boats);

        // Створення об'єкта для пошуку
        MarineBoat searchBoat = new MarineBoat("Triton", 1999, 10.5, 40, "Patrol");
        int index = Arrays.asList(boats).indexOf(searchBoat);

        // Виведення результату пошуку
        if (index != -1) {
            System.out.println("\nBoat found at index " + index + ": " + boats[index]);
        } else {
            System.out.println("\nBoat not found.");
        }
    }

    /**
     * Метод для виведення масиву човнів у консоль.
     *
     * @param boats масив об'єктів MarineBoat
     */
    private static void printBoats(MarineBoat[] boats) {
        for (MarineBoat boat : boats) {
            System.out.println(boat);
        }
    }
}

/**
 * Клас, що представляє морський човен.
 */
class MarineBoat {
    private String name; // Назва човна
    private int year; // Рік випуску
    private double length; // Довжина човна (в метрах)
    private int capacity; // Максимальна кількість людей
    private String type; // Тип човна (наприклад, "Cargo", "Fishing")

    /**
     * Конструктор класу MarineBoat.
     *
     * @param name     назва човна
     * @param year     рік випуску
     * @param length   довжина човна
     * @param capacity максимальна кількість людей
     * @param type     тип човна
     */
    public MarineBoat(String name, int year, double length, int capacity, String type) {
        this.name = name;
        this.year = year;
        this.length = length;
        this.capacity = capacity;
        this.type = type;
    }

    // Геттери для полів
    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public double getLength() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }

    // Перевизначення toString для зручного виведення
    @Override
    public String toString() {
        return String.format("MarineBoat{name='%s', year=%d, length=%.1f, capacity=%d, type='%s'}",
                name, year, length, capacity, type);
    }

    // Перевизначення equals для порівняння об'єктів
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarineBoat boat = (MarineBoat) o;
        return year == boat.year &&
                Double.compare(boat.length, length) == 0 &&
                capacity == boat.capacity &&
                name.equals(boat.name) &&
                type.equals(boat.type);
    }
}
