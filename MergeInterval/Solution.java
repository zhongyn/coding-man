import java.util.*;

 class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class Solution {
    class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(new IntervalComparator());
        List<Interval> result = new ArrayList<>();
        if (intervals.size() == 0) {
            return result;
        }
        result.add(intervals.get(0));
        Interval prev = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.start <= prev.end) {
                if (cur.end > prev.end) {
                    prev.end = cur.end;
                }
            } else {
                result.add(cur);
                prev = cur;
            }
        }
        return result;
    }
}