public class HotelRoom {
    private final int DEFAULT_ROOM_NUM = 999;
    private final int DEFAULT_NUM_BEDS = 2;
    private final int MIN_BEDS = 2;
    private final int MAX_BEDS = 4;
    private final int MIN_ROOM_NUM = 100;
    private final int MAX_ROOM_NUM = 999;

    private int roomNum;
    private int numBeds;
    private boolean occupied;
    private String guest;

    public HotelRoom(int roomNum, int numBeds) {
        if (roomNumOk(roomNum)) {
            this.roomNum = roomNum;
        } else {
            this.roomNum = DEFAULT_ROOM_NUM;
        }

        if (numBedsOk(numBeds)) {
            this.numBeds = numBeds;
        } else {
            this.numBeds = DEFAULT_NUM_BEDS;
        }

        this.occupied = false;
        this.guest = "";
    }

    private boolean roomNumOk(int roomNum) {
        return roomNum >= MIN_ROOM_NUM && roomNum <= MAX_ROOM_NUM;
    }

    private boolean numBedsOk(int numBeds) {
        return numBeds >= MIN_BEDS && numBeds <= MAX_BEDS;
    }

    public int getRoomNum() { 
        return roomNum; 
    }
    public int getNumBeds() { 
        return numBeds;
    }
    public boolean isOccupied() { 
        return occupied; 
    }
    public String getGuest() { 
        return guest; 
    }

    public void setRoomNum(int roomNum) {
        if (roomNumOk(roomNum)) {
            this.roomNum = roomNum;
        }
    }

    public void setNumBeds(int numBeds) {
        if (numBedsOk(numBeds)) {
            this.numBeds = numBeds;
        }
    }

    public boolean equals(HotelRoom other) {
        return this.roomNum == other.roomNum && this.numBeds == other.numBeds;
    }

    public boolean before(HotelRoom other) {
        return this.roomNum < other.roomNum;
    }

    public boolean after(HotelRoom other) {
        return other.before(this);
    }

    public boolean checkIn(String guest) {
        if (!this.occupied) {
            this.occupied = true;
            this.guest = guest;
            return true;
        }
        return false;
    }

    public void checkOut() {
        this.occupied = false;
        this.guest = "";
    }

    public String toString() {
        if (!occupied) {
            return "Room " + roomNum + ", " + numBeds + " Beds: Available";
        } else {
            return "Room " + roomNum + ", " + numBeds + " Beds: Occupied by " + guest;
        }
    }
}
