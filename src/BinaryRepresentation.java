public class BinaryRepresentation {
    public static void main(String args[]) {
        String binRep = "111111";
        System.out.println(Integer.parseInt(binRep, 2));
        System.out.println(binaryToInteger(binRep, binRep.length() - 1, 0));
        System.out.println(binaryToInteger2(binRep));
        System.out.println(binaryToInteger2Fix(binRep));
        System.out.println(Integer.toBinaryString(Integer.parseInt(binRep, 2)));
    }

    // iterative approach 1
    public static int binaryToInteger(String binary) {
      char[] digits = binary.toCharArray();
      int counter = digits.length - 1;
      int ans = 0;
      for (int i = 0; i < digits.length; i ++) {
          ans += Character.getNumericValue(digits[i]) *  Math.pow(2, counter);
          counter --;
      }
      return ans;
    }

    // iterative approach 2
    public static int binaryToInteger2(String binary) {
        int base = 0;
        int ans = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
           ans += Math.pow(2, base) * Character.getNumericValue(binary.charAt(i));
           ++base;
        }
        return ans;
    }

    public static int binaryToInteger2Fix(String binary) {
        int base = 1;
        int ans = 0;
        for(int i = binary.length() - 1; i >= 0; i--) {
            // when char(binary.length - 1), base will be just 1 and 1 will be added.
            // for ex) "100001", the last digit is "1". that'd be 2^0 = 1 pattern.
            if (binary.charAt(i) == '1') {
                ans += base;
            }
            base *= 2;
        }
        return ans;
    }

    //brought from Integer.parseInt
    //ToDo try to understand the algorism
    public static int parseInt(String s, int radix) {
        if (s == null) {
            throw new NumberFormatException("null");
        } else if (radix < 2) {
            throw new NumberFormatException("radix " + radix + " less than Character.MIN_RADIX");
        } else if (radix > 36) {
            throw new NumberFormatException("radix " + radix + " greater than Character.MAX_RADIX");
        } else {
            boolean negative = false;
            int i = 0;
            int len = s.length();
            int limit = -2147483647;
            if (len <= 0) {
                throw new RuntimeException("hello");
            } else {
                char firstChar = s.charAt(0);
                if (firstChar < '0') {
                    if (firstChar == '-') {
                        negative = true;
                        limit = -2147483648;
                    } else if (firstChar != '+') {

                        throw new RuntimeException("hello");
                    }

                    if (len == 1) {
                    }

                    ++i;
                }

                int multmin = limit / radix;

                int result;
                int digit;
                for(result = 0; i < len; result -= digit) {
                    digit = Character.digit(s.charAt(i++), radix);
                    if (digit < 0 || result < multmin) {
                        throw new RuntimeException("hello");
                    }

                    result *= radix;
                    if (result < limit + digit) {
                        throw new RuntimeException("hello");
                    }
                }

                return negative ? result : -result;
            }
        }
    }

    // recursive approach
    public static int binaryToInteger(String binRep, int counter, int index) {
        if (index == binRep.length() - 1) {
            return Character.digit(binRep.charAt(index), 2) * 1;
        }
        return ((int)Math.pow(2, counter) * Character.digit(binRep.charAt(index), 2)) + binaryToInteger(binRep, --counter, ++index);
    }
}
