import java.util.ArrayList;
import java.util.List;

public class MyRunnable implements Runnable {

    List<Integer> list;
    String msg;

    MyRunnable(List<Integer> list, String msg){
        this.list = list;
        this.msg = msg;
    }

    @Override
    public void run() {
        list.add(300);
        System.out.println(msg);
    }
}
