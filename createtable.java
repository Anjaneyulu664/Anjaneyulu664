import java.io.*;
import java.sql.*;

public class createtable{
    public static void main(String[] args) {
        
        String jdbcURL = "jdbc:mysql://localhost:3306/attendence"; 
        String dbUser = "root"; 
        String dbPassword = "SQLroot@9143"; 
        String filePath = "D:\\visualstudio programs\\javaprograms"; 

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (
                Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
                BufferedReader br = new BufferedReader(new FileReader(filePath));
                Statement stmt = conn.createStatement()
            ) {
                System.out.println("Connected to MYSQL database.");

                StringBuilder sqlBuilder = new StringBuilder();
                String line;

                while ((line = br.readLine()) != null) {
                    line = line.trim();
                    if (line.isEmpty() || line.startsWith("--")) continue;

                    sqlBuilder.append(line).append(" ");

                    if (line.endsWith(";")) {
                        String sql = sqlBuilder.toString().replace(";", "").trim();
                        try {
                            stmt.execute(sql);

                            if (sql.toUpperCase().startsWith("CREATE TABLE")) {
                                String[] words = sql.split("\\s+");
                                int idx = 0;
                                for (int i = 0; i < words.length; i++) {
                                    if (words[i].equalsIgnoreCase("TABLE") && i + 1 < words.length) {
                                        idx = i + 1;
                                        break;
                                    }
                                }
                                String tableName = words[idx].replaceAll("[\"'`;]", "");
                                System.out.println("Table " + tableName + " created successfully.");
                            } else {
                                System.out.println("Executed SQL: " + sql);
                            }

                        } catch (SQLException ex) {
                            System.out.println("Failed to execute: " + sql);
                            ex.printStackTrace();
                        }
                        sqlBuilder.setLength(0);
                    }
                }

                System.out.println("All statements processed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

