import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//https://drken115.hatenablog.com/entry/2019/12/14/171657
public class BitFullSearchEx {
    public static void main(String args[]) {
        //全体集合
        int [] nums = {1, 5, 3, 6, 2, 7};

        //和
        int W = 9;

        /*
        問題：　集合と正の整数Wが与えられる。
        集合のなかから、何個か選んで総和をWとすることができるか確認する
         */
        boolean exist = false;
        System.out.println("Iterating " + (1 << nums.length) + " times");
        for (int i = 0; i < (1 << nums.length); i ++) {
            int [] tmp = convertToIndexes(i, nums.length);
            System.out.println(tmp.length);
            int sum = 0;
            for (int index : tmp) {
                sum += nums[index];
            }
            if (sum == W) exist = true;
        }

        System.out.println(exist);
    }

    public static int[] convertToIndexes(int bin, int digits) {
        return IntStream.range(0, digits).filter(digit -> (bin & (1 << digit)) > 0).toArray();
    }
}
