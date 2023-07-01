public class Liquid implements Portion {
    String name;                    // Liquid Name
    State state = State.Liquid;     // Liquid State
    Temperature temp;               // Liquid Temperature
    String fruit = null;            // Liquid Flavour -- If Liquid is FruitJuice it also has a flavour

    public Liquid(String name, Temperature temp) {
        this.temp = temp;
        this.name = name;
    }

    public Liquid(String name, Temperature temp, String flavour) {
        this.temp = temp;
        this.name = name;
        this.fruit = flavour;
    }

    @Override
    public String toString() {
        if (fruit == null) { // Checks if 'flavour' has been initialized in the constructor.
            return (this.name + ": Temperature " + this.temp + ", State " + this.state);
        } else { // If 'flavour' has a value
            return (this.name + ": " + this.fruit + ", Temperature " + this.temp + ", State " + this.state );
        }
    }

    public Temperature getTemperature() { 
        return this.temp;
    }

    public State getState() {
        return this.state;
    }
}