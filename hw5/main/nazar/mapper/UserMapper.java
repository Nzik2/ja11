package nazar.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import nazar.domain.User;
public class UserMapper {
    public static User map(ResultSet result) throws SQLException {
        String firstName = result.getString("first_name");
        String lastName = result.getString("last_name");
        String email = result.getString("email");
        return new User(first_name, last_name,email);
    }
}