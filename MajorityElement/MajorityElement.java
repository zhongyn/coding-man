import java.util.*;

public class MajorityElement {
    public int majorityElement(int[] num) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            if (!map.containsKey(num[i])) {
                map.put(num[i], 1);
            } else {
                map.put(num[i], map.get(num[i]) + 1) ;
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > num.length / 2) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,1,1,1,1};
        MajorityElement m = new MajorityElement();
        System.out.println(m.majorityElement(a));
    }
}