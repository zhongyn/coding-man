class FirstUniqueChar {
    public char getFirstUniChar(String s) {
        // what should we  return if there is no unique char?
        final int size = 256;
        int[] count = new int[size];
        int[] order = new int[size];
        char[] arr = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            count[arr[i]]++;
            if (count[arr[i]] == 1) {
                order[arr[i]] = i;
            }
        }

        int res = -1;
        for (int i = 0; i < size; i++) {
            if (count[i] == 1) {
                res = (res == -1 || order[res] > order[i]) ? i : res;
            }
        }

        return res == -1 ? 'a' : (char) res;
    }

    public static void main(String[] args) {
        FirstUniqueChar so = new FirstUniqueChar();
        System.out.println(so.getFirstUniChar("wertrwre"));
        System.out.println(so.getFirstUniChar(""));
    }
}