import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        System.out.println("Simple Connection Example");
        System.out.println("-".repeat(80));

        // Implement solution to print all of the students in the database

        // Step 1: Get connection with the database
        String url = "jdbc:mysql://localhost:51512/cs_hu_310_final_project?verifyServerCertificate=false&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=True";
        String username = System.getenv("CS310_USERNAME");
        String password = System.getenv("CS310_PASSWORD");
        Connection connection = DriverManager.getConnection(url, username, password);

        // Step 2: Create a query and send that query to the database
        Statement statement = connection.createStatement();
        String sql = "SELECT concat_ws(\" \", first_name, last_name) as full_name FROM students;";
        ResultSet resultSet = statement.executeQuery(sql);

        // Step 3: Process the data
        // For each row...
        while(resultSet.next()){
            String full_name = resultSet.getString("full_name");
            System.out.println(full_name );
        }


        // Step 4: Close connections
        resultSet.close();
        statement.close();
        connection.close();
    }
}

