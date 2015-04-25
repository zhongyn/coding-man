public class Roman {
    public String intToRoman(int num) {
        int level = 0;
        String roman = "";

        while (num != 0) {
            roman = convert(num % 10, level) + roman;
            num /= 10;
            level++;
        }

        return roman;
    }

    public String convert(int a, int level) {
        String s;
        if (level == 0) {
            s = helper('I', 'V', 'X', a);
        } else if (level == 1) {
            s = helper('X', 'L', 'C', a);
        } else if (level == 2) {
            s = helper('C', 'D', 'M', a);
        } else {
            s = helper('M', 'M', 'M', a);
        }
        return s;  
    }

    public String helper(char a, char b, char c, int num) {
        String s = "";
        int count = 0;

        if (num > 5 && num < 9) {
            count = num - 5;
        } else if (num < 4) {
            count = num;
        } else if (num == 4 || num == 9) {
            count = 1;
        }

        for (int i = 0; i < count; i++) {
            s += a;
        }

        if (num == 4) {
            s += b;
        } else if (num == 9) {
            s += c;
        } else if (num > 5 && num < 9) {
            s = b + s;
        }

        if (num == 5) {
            s = "" + b;
        }

        return s;
    }

    public int romanToInt(String s) {
        int level = 0;
        int num = 0;
        int sum = 0;
        int r = s.length() - 1;
        int p = r;
        char a, b;

        while (p >= 0) {

            if (p > 0) {
                a = s.charAt(p);
                b = s.charAt(p - 1);
                if (isGap(a, b, 'I', 'V', 'X') || 
                    isGap(a, b, 'X', 'L', 'C') || 
                    isGap(a, b, 'C', 'D', 'M') || 
                    isGap(a, b, 'M', 'Z', 'Z')) {
                    num = convert(s.substring(p, r + 1), level);                    
                    sum += num * (int) Math.pow(10, level);
                    level++;
                    r = p - 1;
                    p = r;
                }
            }
            if (p == 0) {
                num = convert(s.substring(p, r + 1), level);
                sum += num * (int) Math.pow(10, level);
                level++;
                r = p - 1;   
                p = r;
            }
            p--;

        }   
        return sum;
    }

    public int convert(String s, int level) {
        int a;
        if (level == 0) {
            a = helper('I', 'V', 'X', s);
        } else if (level == 1) {
            a = helper('X', 'L', 'C', s);
        } else if (level == 2) {
            a = helper('C', 'D', 'M', s);
        } else {
            a = helper('M', 'Z', 'Z', s);
        }
        return a;  
    }

    public int helper(char a, char b, char c, String s) {
        System.out.println(s);
        int num = 0;
        char ch;
        for (int i = s.length() - 1; i > -1; i--) {
            ch = s.charAt(i);
            if (ch == b) {
                num += 5;
            } else if (ch == c) {
                num += 10;
            } else {
                if (num == 5 || num == 10) {
                    num--;
                } else {
                    num++;
                }
            }
        }
        System.out.println(num);
        return num;
    }

    public boolean isGap(char a, char b, char c, char d, char e) {
        System.out.println(a);
        System.out.println(b);
        if ((a == c || a == d || a == e) && b != c && b != d) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int a = 48;
        String s = "MMCCCXCIX";
        Roman r = new Roman();
        // System.out.println(r.intToRoman(a));
        // System.out.println(r.helper('I', 'V', 'X', "IX"));
        System.out.println(r.romanToInt(s));
    }
}