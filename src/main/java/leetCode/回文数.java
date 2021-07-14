package leetCode;

public class 回文数 {


    public static void main(String[] args) {
        System.out.println(isPalindrome(12121));
    }


    public static boolean isPalindrome(int x) {
        String x_str = String.valueOf(x);
        String result ="";
        for (int i = 0; i < x_str.length(); i++) {
            char charact = x_str.charAt(x_str.length()-1-i);
            result += String.valueOf(charact);
        }
        return x_str.equals(result);
    }

    public boolean isPalindromeStand(int x){
        if (x < 0){
            return false;
        }
        int first = x;
        int n = 0;
        while(x != 0){
            n = n * 10 + x % 10;
            x = x / 10;
        }
        if (n == first){
            return true;
        }
        return false;
    }
}
