public class FriendChallengeLookAndSay {

    public static void main(String args[]) {
        System.out.println(solution(8));
    }

    public static String solution(int n) {
        String start = "1";
        if (n == 1) return start;
        return rec(n, 2, start);
    }

    private static String rec(int n, int index, String look) {
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
