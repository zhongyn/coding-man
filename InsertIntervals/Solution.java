/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int len = intervals.size();
        if (len == 0) {
            result.add(newInterval);
            return result;
        }
        int a = newInterval.start;
        int b = newInterval.end;

        for (int i = 0; i < len; i++) {
            Interval it = intervals.get(i);
            if (a > it.end) {
                result.add(it);
            } else {
                if (b < it.start) {
                    result.add(newInterval);
                } else {
                    Interval cur = a < it.start ? newInterval : it;
                    if (b <= it.end) {
                        cur.end = b;
                    }
                    int j = i;
                    while (j < len && b > intervals.get(j).end) {
                        j++;
                    }
                }
                int next = j;
                if (j == len) {
                    cur.end = b;
                } else if (b >= intervals.get(j).start) {
                    cur.end = intervals.get(j).end;
                    next++;
                } else if (a == it.start) {
                    cur.end = b;
                }
                result.add(cur);
                while (next < len) {
                    result.add(intervals.get(next));
                    next++;
                }
                break;
            }
        }
        if (a > intervals.get(len - 1).end) {
            result.add(newInterval);
        }
        return result;
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int len = intervals.size();
        int a = newInterval.start;
        int i = 0;
        while (i < len && a > intervals.get(i).start) {
            i++;
        }
        intervals.add(i, newInterval);

        Interval pre = intervals.get(0);
        result.add(pre);
        for (int j = 1; j <= len; j++) {
            Interval cur = intervals.get(j);
            if (cur.start <= pre.end) {
                pre.end = Math.max(pre.end, cur.end);
            } else {
                result.add(cur);
                pre = cur;
            }
        }
        return result;
    }
}