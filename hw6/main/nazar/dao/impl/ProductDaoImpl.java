package nazar.dao.impl;
import nazar.dao.ProductDao;
import nazar.domain.Bucket;
import nazar.domain.Product;
import nazar.utils.ConnectionUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ProductDaoImpl implements ProductDao {
    private static String READ_ALL = "select * from product";
    private static String CREATE = "insert into product ('name','description','price') values (?,?,?)";
    private static String READ_BY_ID = "select * from product where id =?";
    private static String UPDATE_BY_ID = "update product set name =?, description =?, price =?, where id =?";
    private static String DELETE_BY_ID = "delete from product where id - ?";
    private Connection connection;
    private PreparedStatement preparedStatement;
    public ProductDaoImpl() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        connection = ConnectionUtils.openConection();
    }
    public Product create(Product product) {
        try {
            preparedStatement = connection.prepareStatement(CREATE);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3,product.getPrice());
            preparedStatement.executeUpdate();
            ResultSet r = preparedStatement.getGeneratedKeys();
            product.setId(r.getInt(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }
    public Product read(Integer id) {
        Product product = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            Integer product_id = result.getInt("id");
            String name = result.getString("name");
            String description = result.getString("description");
            Double purchase_prise =result.getDouble("purchase_prise");
            product = new Product(product_id,name,description,purchase_prise);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }
    public Product update(Product product) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3,product.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }
    public void delete(Integer id) {
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public List<Product> readAll() throws SQLException {
        List<Product> productRecords = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                Integer productid = result.getInt("id");
                String name = result.getString("name");
                String description = result.getString("description");
                Double purchase_prise =result.getDouble("purchase_prise");

                productRecords.add(new Product(productid,name,description,purchase_prise));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productRecords;
    }
}