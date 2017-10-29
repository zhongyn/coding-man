List<Integer> reverseFibonacci(int a, int b) {
  List<Integer> res = new ArrayList<>();
  res.add(a);
  res.add(b);
  while (b != 0) {
    int size = res.size();
    int next = a - b;
    res.add(next);
    a = b;
    b = next;
  }
  return res;
}
