import java.sql.*;

public class insertionDeletion {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/attendence"; // your DB name
        String dbUser = "root";
        String dbPassword = "SQLroot@9143";
        String filepath="insertionDeletion.java";

        try (Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
             Statement stmt = conn.createStatement()) {

            // Delete operation
            String deleteSQL = "DELETE FROM employee WHERE id = 1";
            int rowsDeleted = stmt.executeUpdate(deleteSQL);
            System.out.println(rowsDeleted + " row(s) deleted.");

            // Update operation
            String updateSQL = "UPDATE employee SET age = 35 WHERE id = 2";
            int rowsUpdated = stmt.executeUpdate(updateSQL);
            System.out.println(rowsUpdated + " row(s) updated.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
