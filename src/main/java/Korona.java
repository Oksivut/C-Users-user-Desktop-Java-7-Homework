import java.util.ArrayList;
import java.util.List;

public class Korona implements Shop{
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        products.add(product);
    }


    public void addProduct(List<Product> list) {
        for (int i = 0; i < list.size(); i++) {
            addProduct(list.get(i));
        }
    }

    public Check getCheck(List<Integer> list) {
        if (list == null) {
            return null;
        }
        Check check = new Check();
        for (int i = 0; i < products.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == products.get(i).getId()) {
                    check.addProductInCheck (products.get(i));
                }
            }
        }
        return check;
    }
    public void printCheck(Check check) {
        check.createCheck();
    }
}