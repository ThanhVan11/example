//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("--- BẮT ĐẦU CHẠY CHƯƠNG TRÌNH ---");

        DBConnection db1 = DBConnection.getInstance();
        db1.query("SELECT * FROM users");

        DBConnection db2 = DBConnection.getInstance();
        db2.query("SELECT * FROM orders");

        System.out.println("\n--- KIỂM TRA TÍNH DUY NHẤT ---");
        if (db1 == db2) {
            System.out.println("=> THÀNH CÔNG: db1 và db2 cùng trỏ về MỘT vùng nhớ duy nhất!");
        } else {
            System.out.println("=> THẤT BẠI: db1 và db2 là hai đối tượng khác nhau!");
        }
    }
}