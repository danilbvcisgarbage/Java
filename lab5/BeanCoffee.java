// Клас для зернової кави
class BeanCoffee extends Coffee {

    public BeanCoffee(String name, double volume, double weight, double price, double quality) {
        super(name, volume, weight, price, quality);
    }

    @Override
    public String toString() {
        return "Bean " + super.toString();
    }
}

// Клас для меленої кави
class GroundCoffee extends Coffee {

    public GroundCoffee(String name, double volume, double weight, double price, double quality) {
        super(name, volume, weight, price, quality);
    }

    @Override
    public String toString() {
        return "Ground " + super.toString();
    }
}

// Клас для розчинної кави в банках
class InstantCoffeeInCan extends Coffee {

    public InstantCoffeeInCan(String name, double volume, double weight, double price, double quality) {
        super(name, volume, weight, price, quality);
    }

    @Override
    public String toString() {
        return "Instant Coffee in Can " + super.toString();
    }
}

// Клас для розчинної кави в пакетиках
class InstantCoffeeInPouch extends Coffee {

    public InstantCoffeeInPouch(String name, double volume, double weight, double price, double quality) {
        super(name, volume, weight, price, quality);
    }

    @Override
    public String toString() {
        return "Instant Coffee in Pouch " + super.toString();
    }
}
