public class Hall {
    private Chair[][] chairs;
    private int row;
    private int count;

    public Hall(int row, int count, int price) {
        chairs = new Chair[row][count];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < count; j++) {
                chairs[i][j] = new Chair(price);
            }
        }
        this.row = row;
        this.count = count;
    }
    public void editPrice(int row, int place, int price){
        chairs[row][place].setPrice(price);
    }

    public int resChair(int row, int place) {
        row = row - 1;
        place = place - 1;
        if (row >= this.row || place >= this.count || row < 0 || place < 0) {
            return -1;
        } else if (chairs[row][place].isReserved()) {
            return 0;
        } else {
            chairs[row][place].setReserved();
            return 1;
        }
    }

    /* Remove reservation for specific place
     * @param
     * @param
     * */
    public int unresChair(int row, int place) {
        row = row - 1;
        place = place - 1;
        if (row > this.row || place > this.count || row < 0 || place < 0) {
            return -1;
        } else if (!chairs[row][place].isReserved()) {
            return 0;
        } else {
            chairs[row][place].unsetReserved();
            return 1;
        }
    }

    public Chair[][] getChairs() {
        return chairs;
    }

    public int getRow() {
        return row;
    }

    public int getCount() {
        return count;
    }
}

