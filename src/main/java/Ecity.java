import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ecity implements Shop {
    private Map<Product, Integer> mapProduct = new HashMap<>();
    private Map<Integer, Product> mapId = new HashMap<>();

    public Map<Product, Integer> getMapProduct() {
        return mapProduct;
    }
    private void setMapProduct(Map<Product, Integer> mapProduct) {
        this.mapProduct = mapProduct;
    }


    public void addProduct(List<Product> list) {
        for (int i = 0; i < list.size(); i++) {
            addProduct(list.get(i));
        }
    }

    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        if (!mapProduct.containsKey(product)) {
            mapProduct.put(product, 1);
        } else {
            mapProduct.put(product, mapProduct.get(product) + 1);
        }
        mapId.put(product.getId(), product);
    }



    public Check getCheck(List<Integer> listId) throws EmptyСheckException {

        Check check = new Check();
        Integer countOfProducts;
        if (listId == null) {
            return check;
        }
        if (listId.size() == 0) {
            throw new EmptyСheckException ();
        }
        for (int i = 0; i < listId.size(); i++) {
            Product soldProduct = mapId.get(listId.get(i));
            countOfProducts = mapProduct.get(soldProduct );
            check.addProductInCheck (soldProduct);
            if (countOfProducts == null) {
            }
            else if (countOfProducts > 1) {
                mapProduct.put(soldProduct, countOfProducts  - 1);
            }
            else {
                mapProduct.remove(soldProduct);
                mapId.remove(soldProduct);
            }

        }
        return check;
    }



    public void printCheck(Check check) {
        check.createCheck();
    }
}
