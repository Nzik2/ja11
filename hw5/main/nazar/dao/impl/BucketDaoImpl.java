package nazar.dao.impl;
import nazar.dao.BucketDao;
import nazar.domain.Bucket;
import nazar.utils.ConnectionUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class BucketDaoImpl implements BucketDao {
    private static String READ_ALL = "select * from bucket";
    private static String CREATE = "insert into bucket ('userid','productid','purchasedate') values (?,?,?)";
    private static String READ_BY_ID = "select * from bucket where id =?";
    private static String DELETE_BY_ID = "delete from bucket where id =?";
    private Connection connection;
    private PreparedStatement preparedStatement;
    public BucketDaoImpl() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        connection = ConnectionUtils.openConection();
    }
    public Bucket create(Bucket bucket) {
        try {
            preparedStatement = connection.prepareStatement(CREATE,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,bucket.getUserid());
            preparedStatement.setInt(2,bucket.getProductid());
            preparedStatement.setDate(3,new Date(bucket.getPurchasedate().getTime()));
            preparedStatement.executeUpdate();
            ResultSet r = preparedStatement.getGeneratedKeys();
            r.next();
            bucket.setId(result.getInt(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bucket;
    }
    public Bucket read(Integer id) {
        Bucket bucket = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            Integer bucketid = result.getInt("id");
            Integer userid = result.getInt("userid");
            Integer productid = result.getInt("productid");
            java.util.Date purchasedate = result.getDate("purchasedate");
            bucket = new Bucket(bucketid,userid,productid,purchasedate);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bucket;
    }
    public Bucket update(Bucket bucket) {
        throw new IllegalStateException("There is no update for bucket");
    }
    public void delete(Integer id){
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public List<Bucket> readAll(){
        List<Bucket> bucketsRecords = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                Integer bucketid = result.getInt("id");
                Integer userid = result.getInt("userid");
                Integer productid = result.getInt("productid");
                java.util.Date purchase_date = result.getDate("purchasedate");
                bucketsRecords.add(new Bucket(bucketid,userid,productid,purchasedate));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bucketsRecords;
    }
}