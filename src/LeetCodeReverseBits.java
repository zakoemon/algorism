public class LeetCodeReverseBits {
    public static void main(String args[]) {
        reverseBits(45);
    }

    public static int reverseBits(int num) {
        char nums[] = new char[32];
        for (int i = 0; i < nums.length; i ++) {
           if ((num & (1 << i)) > 0) {
               nums[i] = '1';
           } else {
               nums[i] = '0';
           }
        }
        int nBit = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == '1') {
                nBit = i;
                break;
            }
            System.out.println("nbit : " + nBit);
        }
        //return Integer.parseInt(new String(nums));
        return Integer.parseInt(new String(nums).substring(nBit), 2);
    }
}
