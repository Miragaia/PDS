
import java.util.ArrayList;

public class Reservation {
    private SeatType type;
    private int size;
    private int number;
    private ArrayList<String> seatCodes;

    public Reservation(SeatType type, int size) {
        this.type = type;
        this.size = size;
        this.number = 0;
        this.seatCodes = new ArrayList<>();
    }

    public SeatType getType() {
        return type;
    }

    public void setType(SeatType type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<String> getSeatCodes() {
        return seatCodes;
    }

    public void setSeatCodes(ArrayList<String> seatCodes) {
        this.seatCodes = seatCodes;
    }

    public boolean addSeatCode(int row, int seat) {
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        String seatCode = letters[seat] + String.valueOf(row);
        if (this.seatCodes.size() < this.size) {
            if(!this.seatCodes.contains(seatCode)){
                this.seatCodes.add(seatCode);
                return true;
            }
        }
        return false;
    }
}

enum SeatType {
    EXECUTIVE, TOURIST
}