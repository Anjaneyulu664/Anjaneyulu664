import java.sql.*;

public class CreateInsertTable {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/aitscollege"; // your DB name
        String dbUser = "root"; 
        String dbPassword = "SQLroot@9143";
        String filepath="CreateInsertTable.java";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
                System.out.println("Connected to MySQL database.");

                Statement stmt = conn.createStatement();

                // Optional: Create tables (comment out if already created)
                String createDept = """
                    CREATE TABLE IF NOT EXISTS DEPT (
                        DEPTNO INT PRIMARY KEY,
                        DNAME VARCHAR(14),
                        LOC VARCHAR(13)
                    );
                """;

                String createEmp = """
                    CREATE TABLE IF NOT EXISTS EMP (
                        EMPNO INT PRIMARY KEY,
                        ENAME VARCHAR(10),
                        JOB VARCHAR(9),
                        MGR INT,
                        HIREDATE DATE,
                        SAL DECIMAL(7,2),
                        COMM DECIMAL(7,2),
                        DEPTNO INT,
                        FOREIGN KEY (DEPTNO) REFERENCES DEPT(DEPTNO)
                    );
                """;

                String createBonus = """
                    CREATE TABLE IF NOT EXISTS BONUS (
                        ENAME VARCHAR(10),
                        JOB VARCHAR(9),
                        SAL DECIMAL(10,2),
                        COMM DECIMAL(10,2)
                    );
                """;

                String createSalgrade = """
                    CREATE TABLE IF NOT EXISTS SALGRADE (
                        GRADE INT,
                        LOSAL DECIMAL(10,2),
                        HISAL DECIMAL(10,2)
                    );
                """;

                stmt.execute(createDept);
                stmt.execute(createEmp);
                stmt.execute(createBonus);
                stmt.execute(createSalgrade);

                System.out.println("Tables created or already exist.");

                // Insert into DEPT
                String insertDept = "INSERT INTO DEPT (DEPTNO, DNAME, LOC) VALUES (?, ?, ?)";
                try (PreparedStatement psDept = conn.prepareStatement(insertDept)) {
                    Object[][] deptData = {
                        {10, "ACCOUNTING", "NEW YORK"},
                        {20, "RESEARCH", "DALLAS"},
                        {30, "SALES", "CHICAGO"},
                        {40, "OPERATIONS", "BOSTON"}
                    };

                    for (Object[] row : deptData) {
                        psDept.setInt(1, (int) row[0]);
                        psDept.setString(2, (String) row[1]);
                        psDept.setString(3, (String) row[2]);
                        psDept.addBatch();
                    }
                    psDept.executeBatch();
                    System.out.println("Inserted DEPT data.");
                }

                // Insert into EMP
                String insertEmp = "INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement psEmp = conn.prepareStatement(insertEmp)) {
                    Object[][] empData = {
                        {7839, "KING", "PRESIDENT", null, "1981-11-17", 5000.00, null, 10},
                        {7566, "JONES", "MANAGER", 7839, "1981-04-02", 2975.00, null, 20},
                        {7698, "BLAKE", "MANAGER", 7839, "1981-05-01", 2850.00, null, 30},
                        {7782, "CLARK", "MANAGER", 7839, "1981-06-09", 2450.00, null, 10},
                        {7788, "SCOTT", "ANALYST", 7566, "1987-04-19", 3000.00, null, 20},
                        {7902, "FORD", "ANALYST", 7566, "1981-12-03", 3000.00, null, 20},
                        {7369, "SMITH", "CLERK", 7902, "1980-12-17", 800.00, null, 20},
                        {7499, "ALLEN", "SALESMAN", 7698, "1981-02-20", 1600.00, 300.00, 30},
                        {7521, "WARD", "SALESMAN", 7698, "1981-02-22", 1250.00, 500.00, 30}
                    };

                    for (Object[] row : empData) {
                        psEmp.setInt(1, (int) row[0]);
                        psEmp.setString(2, (String) row[1]);
                        psEmp.setString(3, (String) row[2]);

                        if (row[3] == null) {
                            psEmp.setNull(4, Types.INTEGER);
                        } else {
                            psEmp.setInt(4, (int) row[3]);
                        }

                        psEmp.setDate(5, Date.valueOf((String) row[4]));
                        psEmp.setDouble(6, (double) row[5]);

                        if (row[6] == null) {
                            psEmp.setNull(7, Types.DECIMAL);
                        } else {
                            psEmp.setDouble(7, (double) row[6]);
                        }

                        psEmp.setInt(8, (int) row[7]);

                        psEmp.addBatch();
                    }
                    psEmp.executeBatch();
                    System.out.println("Inserted EMP data.");
                }

                // Insert into BONUS
                String insertBonus = "INSERT INTO BONUS (ENAME, JOB, SAL, COMM) VALUES (?, ?, ?, ?)";
                try (PreparedStatement psBonus = conn.prepareStatement(insertBonus)) {
                    Object[][] bonusData = {
                        {"KING", "PRESIDENT", 5000.00, null},
                        {"BLAKE", "MANAGER", 2850.00, null},
                        {"CLARK", "MANAGER", 2450.00, null},
                        {"ALLEN", "SALESMAN", 1600.00, 300.00},
                        {"WARD", "SALESMAN", 1250.00, 500.00}
                    };

                    for (Object[] row : bonusData) {
                        psBonus.setString(1, (String) row[0]);
                        psBonus.setString(2, (String) row[1]);
                        psBonus.setDouble(3, (double) row[2]);

                        if (row[3] == null) {
                            psBonus.setNull(4, Types.DECIMAL);
                        } else {
                            psBonus.setDouble(4, (double) row[3]);
                        }

                        psBonus.addBatch();
                    }
                    psBonus.executeBatch();
                    System.out.println("Inserted BONUS data.");
                }

                // Insert into SALGRADE
                String insertSalgrade = "INSERT INTO SALGRADE (GRADE, LOSAL, HISAL) VALUES (?, ?, ?)";
                try (PreparedStatement psSalgrade = conn.prepareStatement(insertSalgrade)) {
                    Object[][] salgradeData = {
                        {1, 700.00, 1200.00},
                        {2, 1201.00, 1400.00},
                        {3, 1401.00, 2000.00},
                        {4, 2001.00, 3000.00},
                        {5, 3001.00, 9999.00}
                    };

                    for (Object[] row : salgradeData) {
                        psSalgrade.setInt(1, (int) row[0]);
                        psSalgrade.setDouble(2, (double) row[1]);
                        psSalgrade.setDouble(3, (double) row[2]);
                        psSalgrade.addBatch();
                    }
                    psSalgrade.executeBatch();
                    System.out.println("Inserted SALGRADE data.");
                }

                System.out.println("All data inserted successfully.");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
