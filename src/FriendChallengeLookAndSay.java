public class FriendChallengeLookAndSay {

    public static void main(String args[]) {

        System.out.println(solution(4));
    }

    public static String solution(int n) {
        return rec(n, 2, "1");
    }

    private static String rec(int n, int index, String look) {
        if (n == 1) return look;
        if (n == index) {
            return lookAndSay(look);
        }
        String say = lookAndSay(look);
        return rec(n, index + 1, say);
    }

    private static String lookAndSay(String previous) {
        char[] chars = previous.toCharArray();
        int counter = 1;
        char pre = 'n';
        char cur = 'n';

        StringBuilder builder = new StringBuilder();
        for (char c : chars) {
           cur = c;
           if (pre == 'n') {
               pre = c;
               continue;
           }
           if (c == pre) {
               counter ++;
           } else {
               builder.append(counter);
               builder.append(pre);
               counter = 1;
           }
           pre = c;
        }
        builder.append(counter);
        builder.append(cur);
        return builder.toString();
    }


}
