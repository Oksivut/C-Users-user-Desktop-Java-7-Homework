import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonRead {

    private List<Product> createProducts(String productsString) {
        String[] split = productsString.split("},\\{");

        List<String> processedString = new ArrayList<>();
        for (String s1 : split) {
            processedString.add(s1.replaceAll("\\{", "").replaceAll("}", ""));
        }
        List<Product> products = new ArrayList<>();
        for (String s1 : processedString) {
            products.add(createProduct(s1));
        }
        return products;
    }

    private Product createProduct(String productString) {
        String[] pairs = productString.split(",");

        String idString = pairs [0].split (":")[1];
        String priceString = pairs [1].split (":")[1];
        String nameString = pairs [2].split (":")[1];

        Product p = new Product( Integer.parseInt(idString), Integer.parseInt(priceString), nameString );

        return p;
    }



    public List<Product> createListProduct(String fileName) throws IOException {

        String accumulator = "";
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String string = "";
        while (string != null) {
            string = bufferedReader.readLine();
            if (string == null) break;
            accumulator += string;
        }


        accumulator = accumulator.replace("[", "");
        accumulator = accumulator.replace("]", "");
        accumulator = accumulator.replaceAll(" ", "");

        List<Product> productsList = createProducts(accumulator);

        return productsList;
    }
}
