import java.sql.*;

public class DatabaseManagement {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/BankInfo";
    static final String USER = "root";
    static final String PASS = "password";
    static final String QUERY = "SELECT id, first, last, mid , amount FROM Registration";

    public void createTable() {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");
            stmt = conn.createStatement();
            String sql = "CREATE TABLE REGISTRATION " + "(id INTEGER not NULL, " + " first VARCHAR(255), " + " mid VARCHAR(255), " + " last VARCHAR(255), " + " amount INTEGER, " + " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
            //System.out.println("Created table in given database...");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public void insertRecords(int id, String user,String type, String password, double amount) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            String sql = "INSERT INTO Registration VALUES (" + id + ", '" + user + "', '" +type+"', '"+ password + "', " + amount + ")";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showRecords() {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");
            stmt = conn.createStatement();
            String sql = "SELECT id, first, last, amount FROM Registration";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                double amount = rs.getInt("amount");
                String first = rs.getString("first");
                String last = rs.getString("last");
                System.out.print(" ID: " + id);
                System.out.print(" Amount : " + amount);
                System.out.print(" User id :" + first);
                System.out.println("  Password: " + last);
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public int extractId (String user,String passWord) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "SELECT id, first, mid , last, amount FROM Registration";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                double amount = rs.getInt("amount");
                String userid = rs.getString("first");
                String type = rs.getString("mid");
                String password = rs.getString("last");
                if (userid.equals(user) && password.equals(passWord)) {
                    return id;
                }
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return 0;
    }

    public void showRecords(String user, String passWord) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");
            stmt = conn.createStatement();
            String sql = "SELECT id, first, mid , last, amount FROM Registration";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                double amount = rs.getInt("amount");
                String userid = rs.getString("first");
                String type = rs.getString("mid");
                String password = rs.getString("last");
                if (userid.equals(user) && password.equals(passWord)) {
                    System.out.print(" ID: " + id);
                    System.out.println(" Amount : " + amount);
                    System.out.println(" Id type "+type);
                    break;
                }
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public double extractBalance (String user , String passWord)
    {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "SELECT id, first, mid , last, amount FROM Registration";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                double amount = rs.getInt("amount");
                String userid = rs.getString("first");
                String type = rs.getString("mid");
                String password = rs.getString("last");
                if (userid.equals(user) && password.equals(passWord)) {
                    return amount;
                }
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return 0;
    }

    public void updateRecords(int idNumber, double amount) {
        System.out.println("Updating database result");
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            String sql = "UPDATE Registration " + "SET amount = " + amount + " WHERE id in (" + idNumber + ")";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
