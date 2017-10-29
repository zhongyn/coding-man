int compareVersion(String a, String b) {
  int num1 = 0;
  int num2 = 0;
  int i = 0;
  int j = 0;
  while (i < a.length - 1 || j < b.length - 1) {
    while (i < a.length - 1 && a.charAt(i) != '.') {
      num1 = num1 * 10 + (a.charAt(i) - '0');
      i++;
    }
    while (j < b.length - 1 && b.charAt(j) != '.') {
      num2 = num2 * 10 + (b.charAt(j) - '0');
      j++;
    }
    if (num1 > num2) {
      return 1;
    } else if (num1 < num2) {
      return -1;
    }
    num1 = 0;
    num2 = 0;
    i++;
    j++;
  }

  return 0;
}
