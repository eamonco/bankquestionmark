import java.sql.*;

public class App
{
    public static void main(String[] args)
    {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        }
        catch (Exception ex) {
            // handle the error
            System.out.println(ex);
        }

        Connection conn = null;

        try
        {
            String url = "jdbc:mysql://localhost/bankDatabase";
            String user = "root";
            String password = "ch@ngeme1";

            conn = DriverManager.getConnection(url, user, password);

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from account");

            while(rs.next()) {
                String out = String.format("name: %s, sex: %s", rs.getString("name"), rs.getString("sex"));
                System.out.println(out);
            }

            st.close();
            conn.close();
        }
        catch(SQLException e) {
            System.out.println(e);
        }
    }
}