
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author river
 */
public class moviedb {

    public static void main(String[] args) {
        final String QUERY = "select id, name, rating, "
                + "premier from films";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/movie", "river", "mucis");
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                System.out.println(
                        +rs.getInt("id") + ", "
                        + rs.getString("name") + ", "
                        + rs.getString("rating") + ", "
                        + rs.getDouble("premier"));
            }
        } catch (SQLException ex) {
            System.out.println("Retrieve SQLException: " + ex.getMessage());

        }
    }
}
