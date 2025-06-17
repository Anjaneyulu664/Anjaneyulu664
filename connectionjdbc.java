import java.io.*;
import java.sql.*;

public class connectionjdbc {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/filedb";
        String user = "root";
        String password = "SQLroot@9143";
        String filePath = " ./table.text";

        String sql = "INSERT INTO files (filename, filedata) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             FileInputStream fis = new FileInputStream(new File(filePath))) {

            pstmt.setString(1, new File(filePath).getName());
            pstmt.setBinaryStream(2, fis, (int) new File(filePath).length());

            int row = pstmt.executeUpdate();
            if (row > 0) {
                System.out.println("File inserted successfully.");
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
