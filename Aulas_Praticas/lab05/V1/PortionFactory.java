public class PortionFactory {
    public static Portion create (String food, Temperature temperature) {
        if (temperature == Temperature.COLD) {
            if (food == "Meat") {
                return new Solid("Tuna", temperature);
            } else if (food == "Beverage") {
                return new Liquid("FruitJuice", temperature, "Orange");
            }
        } else if (temperature == Temperature.WARM) {
            if (food == "Meat") {
                return new Solid("Pork", temperature);
            } else if (food == "Beverage") {
                return new Liquid("Milk", temperature);
            }
        }
        return null; // Input wasn't valid, so null is returned
    }
}
