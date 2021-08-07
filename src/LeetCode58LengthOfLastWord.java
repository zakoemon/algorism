public class LeetCode58LengthOfLastWord {

    public static void main(String args[]) {
        LeetCode58LengthOfLastWord clazz = new LeetCode58LengthOfLastWord();
        System.out.println(clazz.lengthOfLastWord(" "));
    }

    public int lengthOfLastWord(String s) {
        char[] line = s.toCharArray();
        if (line.length == 1 && line[line.length - 1] == ' ') {
            return 0;
        }

        int index = line.length - 1;
        int counter = line.length - 1;
        while (counter >= 0) {
            if (line[counter] != ' ') {
                index = counter;
                break;
            };
            counter --;
        }

        int length = 0;
        while (index >= 0) {
            if (line[index] != ' ') {
                length ++;
            } else {
                break;
            }
            index --;
        }

        return length;
    }
}
