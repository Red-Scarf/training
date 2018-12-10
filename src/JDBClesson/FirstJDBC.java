package JDBClesson;

public class FirstJDBC {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1.

        Class.forName("oracle.jdbc.OracleDriver");

        String url = "127.0.0.1";
        String user = "system";
        String password = "oracle";

    }
}
