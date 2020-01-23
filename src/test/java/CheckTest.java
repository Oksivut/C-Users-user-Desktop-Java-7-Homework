import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckTest {
    private Product product1;
    private Product product2;

    private Korona korona;
    private Check check;
    private List<Integer> listTest = new ArrayList<>();


    @Before
    public void create() {
        korona = new Korona();
        product1 = new Product (0001, 16,"Dictionary");
        product2 = new Product (0005, 18,"Dictionary");

    }

    @Test
    public void testAddProduct(){
        korona.addProduct(product1);
        listTest.add(product1.getId());
        check = korona.getCheck(listTest);
        assertTrue(check.getMapCheck().containsKey(product1));
    }

    @Test
    public void testPutNullProduct() {
        Product product = null;
        check = new Check();
        check.addProductInCheck(product);
        assertFalse(check.getMapCheck().containsKey(product));
    }

}
