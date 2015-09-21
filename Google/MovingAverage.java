import java.util.*;
public class MovingAverage {
    private int x;
    private float aver = 0;
    private Deque<Float> q;

    public MovingAverage(int x) {
        this.x = x;
        this.q = new LinkedList<>(x);
    }

    public void readNum(float num) {
        if (q.size() < x) {
            aver = (aver * q.size() + num) / (q.size() + 1);
        } else {
            aver += (num - q.remove()) / x;
        }
        q.add(num);
    }

    public float getAverage() {
        return aver;
    }

    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage(3);
        ma.readNum(1);
        System.out.println(ma.getAverage());
        ma.readNum(2);
        System.out.println(ma.getAverage());
        ma.readNum(3);
        System.out.println(ma.getAverage());
        ma.readNum(4);
        System.out.println(ma.getAverage());
        ma.readNum(5);
        System.out.println(ma.getAverage());
        ma.readNum(6);
        System.out.println(ma.getAverage());
    }
}