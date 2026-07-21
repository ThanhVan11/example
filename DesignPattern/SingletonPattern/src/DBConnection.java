public class DBConnection {
    private static final DBConnection instance = new DBConnection();
    private String connection;

    private DBConnection() {
        this.connection = "Connected to MySQL";
        System.out.println("Tạo kết nối DB ngay khi load class...");
    }

    public static DBConnection getInstance() {
        return instance;
    }

    public void query(String sql) {
        System.out.println("Executing: " + sql + " via " + connection);
    }
}
