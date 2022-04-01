public class Detail {
    private String name;
    private int price;
    public boolean isChosen;

    public Detail() {
        name = "";
        price = 0;
        isChosen = false;
    }

    public Detail(String name, int price) {
        this.name = name;
        this.price = price;
        isChosen = false;
    }

    public void setDetail(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void showDetail() {
        System.out.println(name + "\tЦена:" + price + " рублей");
    }

    public int getPrice() {
        return price;
    }
}
