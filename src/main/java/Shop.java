import java.util.List;

public interface Shop {

        void addProduct(Product product);
        Check getCheck(List<Integer> id) throws EmptyСheckException;
    }

