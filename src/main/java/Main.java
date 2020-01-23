import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, EmptyСheckException {
       Product book = new Book (0001, 16,"Dictionary");
       Product pencil = new Pencil(0002, 17, "Nixon");
       Product pen= new Pen(0003, 5, "Senator");
       Product  pen2 = new Pen(0005, 19, "Parker");

       List<Product> list1=new ArrayList();

             list1.add (pen);


        List <Integer> id = new ArrayList();
        id.add (0003);

        List <Integer> id2= new ArrayList();
        id2.add(0003);
        id2.add(0005);


        Korona korona = new Korona();
        korona.printCheck(korona.getCheck( id ) );

        CSV csv= new CSV();
        csv.addProductInFile(pencil, "productsInShopCSV.csv");
        try{
            korona.addProduct(csv.productsFromFile("productsInShopCSV.csv"));
        }catch (FileNotFoundException e) {
            System.out.println("Input problem");
        } catch (NumberFormatException e) {
            System.out.println(e);
            korona.addProduct(pencil);
        }


        JsonWrite jsonWrite = new JsonWrite();
        JsonRead jsonRead = new JsonRead();
        jsonWrite.addProduct (pen, "productsJson.json");
        Ecity ecity = new Ecity();
        try{
            ecity.addProduct(jsonRead.createListProduct("productsJson.json"));
        }catch (FileNotFoundException e){
            System.out.println("Input problem");
            System.out.println(e);
            ecity.addProduct(pen);
        }


        }


     }















