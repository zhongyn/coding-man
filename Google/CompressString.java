class CompressString {
    public String compress(char[] s) {
        if (s.length == 0) {
            return "";
        }
        int count = 1;
        int id = 0;

        for (int i = 1; i < s.length; i++) {
            if (s[i] == s[i - 1]) {
                count++;
            } else {
                s[id++] = s[i - 1];
                s[id++] = (char) (count + '0');
                count = 1;
            }
        }

        s[id++] = s[s.length - 1];
        s[id++] = (char) (count + '0');

        return new String(s, 0, id);
    }

    public static void main(String[] args) {
        CompressString so = new CompressString();
        char[] a = {'a', 'a', 'a', 'a', 'a'};
        char[] b = {'a', 'a', 'a', 'b', 'b', 'b', 'c'};
        char[] c = {'a', 'a', 'b', 'b', 'b','g', 'd', 'd', 'd', 'd', 'd'};
        System.out.println(so.compress(a));
        System.out.println(so.compress(b));
        System.out.println(so.compress(c));
    }
}