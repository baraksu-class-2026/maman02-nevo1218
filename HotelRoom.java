public class HotelRoom {
    private int roomNum;
    private int numBeds;
    private boolean occupied;
    private String guest;

    public HotelRoom(int roomNum, int numBeds) {
        this.roomNum = roomNum;
        this.numBeds = numBeds;
        this.occupied = false;
        this.guest = null;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public int getNumBeds() {
        return numBeds;
    }

    public void setNumBeds(int numBeds) {
        this.numBeds = numBeds;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public String getGuest() {
        return guest;
    }

    public void checkIn(String guest) {
        if (!occupied) {
            this.guest = guest;
            occupied = true;
        }
    }

    public void checkOut() {
        guest = null;
        occupied = false;
    }

    public boolean before(HotelRoom other) {
        return this.roomNum < other.roomNum;
    }

    public boolean after(HotelRoom other) {
        return this.roomNum > other.roomNum;
    }
}

