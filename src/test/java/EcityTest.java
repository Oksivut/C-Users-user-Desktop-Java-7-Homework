import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class EcityTest {
        private Product product1;
        private Product product2;

        private Ecity ecity;
        private Check check;
        private List<Integer> listProduct = new ArrayList<>();

        @Before
        public void init() {
           ecity = new Ecity();
            check = new Check();
            product1 = new Pen(0003, 5, "Senator");
            product2 = new Pencil(0002, 17, "Nixon");


            ecity.addProduct(product1);
            ecity.addProduct(product2);

            listProduct .add(0003);
            listProduct .add(0002);

        }

        @Test
        public void testAddProductNotNull(){
            Product pen = null;
            Check checkActual = new Check();
            checkActual.addProductInCheck(pen);
            Assert.assertEquals(0, check.getTotalPrice(), 0);
        }



        @Test
        public void testAddProduct() {
            ecity.addProduct(product1);
            ecity.addProduct(product2);

            assertTrue(ecity.getMapProduct().containsKey(product2));
        }


        @Test
        public void testGetCheck() throws EmptyСheckException {
            check = ecity.getCheck(listProduct);
            Assert.assertEquals(22, check.getTotalPrice(), 0);
        }



    }