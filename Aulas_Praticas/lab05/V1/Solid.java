public class Solid implements Portion {
    
    String name;                    // Solid name
    State state = State.Solid;      // Solid state
    Temperature temp;               // Solid temperature

    public Solid(String name, Temperature temp) {
        this.temp = temp;
        this.name = name;
    }

    public Temperature getTemperature() {
        return this.temp;
    }

    public State getState() {
        return this.state;
    }

    @Override
    public String toString() { return (this.name + ": Temperature " + this.temp + ", State " + this.state ); }
}