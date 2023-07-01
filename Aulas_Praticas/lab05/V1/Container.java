public class Container {
    String type;                // Type of Container
    State state;                // State of the portion the given container can store
    Temperature temp;           // Temperature of the portion the given container can store
    Portion portion;            // Portion that the container is going to store

    public Container(Portion portion, String type, State state, Temperature temp) {
        this.type = type;
        this.state = state;
        this.temp = temp;
        this.portion = portion;
    }

    @Override
    public String toString() {
        return (this.type + " with portion = " + this.portion.toString());
    }

    public static Container create(Portion portion) {
        Temperature temp = portion.getTemperature();   
        State state = portion.getState();             

        if (state == State.Liquid) {
            if (temp == Temperature.COLD) {
                return new Container(portion,"PlasticBottle", state, temp);

            } else if (temp == Temperature.WARM) {
                return new Container(portion,"TermicBottle", state, temp);

            } else {
                return null; 
            }

        } else if (state == State.Solid) {
            if (temp == Temperature.COLD) {
                return new Container(portion,"PlasticBag", state, temp);

            } else if (temp == Temperature.WARM) {
                return new Container(portion,"Tupperware", state, temp);

            } else {
                return null;
            }

        }
        return null;
    }
}
