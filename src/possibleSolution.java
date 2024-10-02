import java.sql.*;

public class possibleSolution {


    public static void main(String[] args) {


        System.out.println("Simple Connection Example");
        System.out.println("-".repeat(80));

        int databasePort = Integer.parseInt(System.getenv("CS310_PORT"));
        String databaseHost = System.getenv("CS310_HOST");
        String databaseUsername = System.getenv("CS310_USERNAME");
        String databasePassword = System.getenv("CS310_PASSWORD");
        String databaseName =  "examples";

        String databaseURL = String.format(
                "jdbc:mysql://%s:%s/%s?verifyServerCertificate=false&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=True",
                databaseHost,
                databasePort,
                databaseName);

        try {
            Connection connection = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
            Statement sqlStatement = connection.createStatement();

            String sql = "SELECT * FROM users;";

            ResultSet resultSet = sqlStatement.executeQuery(sql);
            while(resultSet.next()){
                System.out.println(resultSet.getString(1));
            }

        } catch (
                SQLException sqlException) {
            System.out.printf("SQLException was thrown while trying to connection to database: %s%n", databaseURL);
            System.out.println(sqlException.getMessage());
        }

    }
}
