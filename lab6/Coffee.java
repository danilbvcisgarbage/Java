// Узагальнений клас Coffee
abstract class Coffee {
    protected String name;      // Назва кави
    protected double volume;    // Обсяг кави
    protected double weight;    // Вага кави
    protected double price;     // Ціна кави
    protected double quality;   // Якість кави (наприклад, оцінка від 1 до 10)

    public Coffee(String name, double volume, double weight, double price, double quality) {
        this.name = name;
        this.volume = volume;
        this.weight = weight;
        this.price = price;
        this.quality = quality;
    }

    public double getPricePerKg() {
        return price / weight;  // Ціна за 1 кг кави
    }

    public double getPricePerLiter() {
        return price / volume;  // Ціна за 1 літр кави
    }

    public double getVolume() {
        return volume;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public double getQuality() {
        return quality;
    }

    @Override
    public String toString() {
        return String.format("%s (%.2f kg, %.2f liters, %.2f price, %.2f quality)", name, weight, volume, price, quality);
    }
}
