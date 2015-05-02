class Solution {

    public int readNBytes(char[] buf, int n) {
        char[] buffer = new char[4];
        boolean eof = false;
        int readBytes = 0;

        while (!eof && readBytes < n) {
            int bufferSize = read4(buffer);
            if (bufferSize < 4) {
                eof = true;
            }
            int bytes = Math.min(bufferSize, n - readBytes);
            System.arraycopy(buffer, 0, buf, readBytes, bytes);
            readBytes += bytes;
        }
        return readBytes;
    }

    private char[] buffer = new char[4];
    private int offset = 0;
    private int bufferSize = 0;

    public int multiReadNBytes(char[] buf, int n) {
        boolean eof = false;
        int readBytes = 0;

        while (!eof && readBytes < n) {
            int size = bufferSize > 0 ? bufferSize : read4(buffer);
            if (bufferSize == 0 && size < 4) {
                eof = true;
            }
            int bytes = Math.min(size, n - readBytes);
            System.arraycopy(buffer, offset, buf, readBytes, bytes);
            offset = (offset + bytes) % 4;
            bufferSize = size - bytes;
            readBytes += bytes;
        }
        return readBytes;
    }
}