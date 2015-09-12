import java.util.*;
public class Solution {
    private final static String[] ZERO_TO_NINTEEN = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", 
    "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final static String[] TWENTY_TO_NINTY = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final static String HUNDRED = "Hundred";
    private final static String[] THOUSAND_TO_BILLION = {"Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if (num == 0) {
            return ZERO_TO_NINTEEN[0];
        }

        List<String> res = new ArrayList<>();

        int place = -1;
        while (num > 0) {
            int n = num % 1000;
            if (n > 0) {  
                if (place >= 0) {
                    res.add(THOUSAND_TO_BILLION[place]);                    
                }
                res.addAll(convert(n));
            }
            num /= 1000;
            place++;
        }

        StringBuilder result = new StringBuilder();
        for (int i = res.size() - 1; i >= 0; i--) {
            result.append(res.get(i));
            result.append(" ");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    // convert a number 1-999 to string;
    public List convert(int num) {
        List<String> res = new ArrayList<>();

        int tens = num % 100;
        if (tens > 0 && tens <= 19) {
            res.add(ZERO_TO_NINTEEN[tens]);
        } else if (tens > 19) {
            int ones = tens % 10;
            if (ones > 0) {
                res.add(ZERO_TO_NINTEEN[ones]);
            }
            res.add(TWENTY_TO_NINTY[tens / 10 - 2]);
        }
        if (num > 99) {
            res.add(HUNDRED);
            res.add(ZERO_TO_NINTEEN[num / 100]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution so =  new Solution();
        System.out.println(so.numberToWords(1000));
    }
}