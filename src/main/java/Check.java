import java.util.HashMap;
import java.util.Map;

public class Check {
    private HashMap<Product, Integer> mapCheck = new HashMap<>();
    private int totalPrice = 0;


    public int getTotalPrice() {
        return totalPrice;
    }


    public void createCheck() {
        for (Map.Entry<Product, Integer> p : mapCheck.entrySet()) {
            System.out.println(p.getKey().getName()  + p.getValue());
        }
        System.out.println(totalPrice);
    }


    public void addProductInCheck (Product product) {
        if (!mapCheck.containsKey(product)) {
            mapCheck.put(product, 1);
            totalPrice += product.getPrice();
        } else {
            mapCheck.replace(product, mapCheck.get(product) + 1);
            totalPrice += product.getPrice();
        }
    }
    public HashMap<Product, Integer> getMapCheck (){
        return mapCheck;
    }
}