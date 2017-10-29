void rotateMatrix(int[][] matrix) {
  int size = matrix.length - 1;

  for (int i = 0; i < size/2; i++) {
    for (int j = 0; j < size; j++) {
      int tmp = matrix[i][j];
      matrix[i][j] = matrix[size - i][j];
      matrix[size - i][j] = tmp;
    }
  }

  for (int i = 0; i < size; i++) {
    for (int j = 0; j <= i; j++) {
      int tmp = matrix[i][j];
      matrix[i][j] = matrix[j][i];
      matrix[j][i] = tmp;
    }
  }
}
