package BookShop;

public class Book {
    public String getName() {
        return name;
    }

    private String name;

    public int getPrice() {
        return price;
    }

    public int getDateCreate() {
        return dateCreate;
    }

    private int price;
    private int dateCreate;

    public Book(String name, int price, int dateCreate) {
        this.name = name;
        this.price = price;
        this.dateCreate = dateCreate;
    }

    public void checkBook(){
      while (true){
          break;
      }
    }

}
