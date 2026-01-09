class Order {
    private double price;
    private Status status;

    public Order(double price, Status status) {
        this.price = price;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Order{price=" + price + ", status=" + status + "}";
    }
}
