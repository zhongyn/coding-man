public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int 
        int share = Math.max(0, Math.min(C, G) - Math.max(A, E)) * Math.max(0, (Math.min(D, H) - Math.max(B, F)));
        return ((C - A) * (D - B) + (G - E) * (H - F)) - share;
    }
}