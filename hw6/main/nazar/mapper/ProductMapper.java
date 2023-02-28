package nazar.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import nazar.domain.Product;
public class ProductMapper {
    public static Product map(ResultSet result) throws SQLException {
        String name = result.getString("name");
        String description = result.getString("description");
        Double price = result.getDouble("price");
        return new Product(name, price, description);
    }
}