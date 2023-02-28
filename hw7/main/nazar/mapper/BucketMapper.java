package nazar.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import nazar.domain.Bucket;
public class BucketMapper {
    public static Bucket map(ResultSet result) throws SQLException {
        Integer id = result.getInt("id");
        Integer userid = result.getInt("userid");
        Integer productid = result.getInt("productid");
        java.util.Date purchasedate = result.getDate("purchasedate");
        return new Bucket(bucketid, userid, productid, purchasedate);
    }

}