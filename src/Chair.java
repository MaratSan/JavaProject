public class Chair {
    private boolean reserved;
    private int price;

    public Chair(int price) {
        reserved = false;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved() {
        reserved = true;
    }

    public void unsetReserved() {
        reserved = false;
    }
}
