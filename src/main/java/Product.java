public class Product {
    private final int id;
    private final int price;
    private final String name;

    public Product (int id, int price, String name){
        this.id = id;
        this.price = price;
        this.name = name;
    }



    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                price == product.price &&
                name.equals(product.name);
    }




    @Override
    public String toString() {
        return "Product{" +
                "id:" + id +
                ", price:" + price +
                ", name:'" + name + '\'' +
                '}';
    }

}


