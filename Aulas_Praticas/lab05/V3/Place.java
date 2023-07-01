public class Place {
    private String location;

    public Place(String location){
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public String setLocation(String location){
        return location;
    }

    @Override
    public String toString() {
        return "Place [location=" + location + "]";
    }

    
}
