public class Phone {
    private String processor;
    private double price;
    private int memory;
    private int camera;

    public Phone(String processor, double price, int memory, int camera) {
        this.processor = processor;
        this.price = price;
        this.memory = memory;
        this.camera = camera;
    }

    // Getters and setters

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "processor='" + processor + '\'' +
                ", price=" + price +
                ", memory=" + memory +
                ", camera=" + camera +
                '}';
    }
}

