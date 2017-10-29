int divide(int dividen, int divisor) {
  if (dividend == Integer.MIN_VALUE && divisor == -1) {
    return Integer.MAX_VALUE;
  }

  long a = Math.abs(long(dividend));
  long b = Math.abs(long(divisor));

  int sum = 0;
  while (a >= b) {
    long tmp = b;
    int count = 1;
    while ((tmp << 1) < a) {
      tmp <<= 1;
      count <<= 1;
    }
    sum += count;
    a -= tmp;
  }

  if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
    return -sum;
  }
  return sum;
}
