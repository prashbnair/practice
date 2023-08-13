package practice.ds;

public class Leet {

    public static void main(String[] args) {
        System.out.println(reverseWords("  the sky is   blue  "));
        System.out.println(reverseWords("the sky is blue"));
    }

    private static String reverseWords(String s) {
        String[] arr = s.split(" ");
        String[] result = new String[arr.length];
        int j = 0;
        for(int i = arr.length - 1; i >=0 ; i--) {
            if(arr[i] != " ") {
                result[j] = arr[i];
                j++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.length; i++){
            sb.append(result[i]);
            if (i != result.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
