void OrderProductsByPriority(String[] productCodes) {
  int a = 0;
  int b = productCodes.length - 1;
  for (int i = 0; i <= b; i++) {
    int p = getPriority(productCodes[i]);
    while (p == 1 && i > a) {
      swap(productCodes, i, a);
      a++;
    }
    while (p == 3 && i < b) {
      swap(productCodes, i, b);
      b--;
    }
  }
}

void swap(String[] a, int i, int j) {
  String tmp = a[j];
  a[j] = a[i];
  a[i] = tmp;
}
