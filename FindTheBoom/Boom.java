class Boom {
    public int findTheBoom(int[] a) {
        List<Integer> num = new ArrayList<>();
        List<Integer> count = new ArrayList<>();

        int i = 0;
        while (i < a.length) {
            int j = i;
            while (j < a.length - 1 && a[j] == a[j + 1]) {
                j++;
            }
            num.add(a[j]);
            count.add(j - i + 1);
            i = j + 1;
        }

        for (int k = 0; k < num.size() - 2; k++) {
            if (num.get(k + 2) - num.get(k + 1) == 1 && num.get(k + 1) - num,get(k) == 1
                && count.get(k) > 1 && count.get(k + 1) > 1 && count.get(k + 2) > 1) {
                return true;
            }
        }

        return false;
    }
}