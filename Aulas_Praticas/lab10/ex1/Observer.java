public abstract class Observer {
    
    protected Product produto;

    public abstract void update(double value, Product produto, String name);

    public abstract String getName();
}