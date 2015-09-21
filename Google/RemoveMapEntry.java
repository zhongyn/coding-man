public class RemoveMapEntry {
    Map<Integer, Integer> map = new TreeMap<>();
    public boolean predict(int val) {...}

    public void removeKey(int val) {
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getKey() == val) {
                it.remove();
            }
        }
    }
}