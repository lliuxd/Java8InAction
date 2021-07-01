package leetCode;

import java.math.BigDecimal;

public class 整数反转 {
    public static void main(String[] args) {
        int x = 1534236469;
//        System.out.println(Integer.MAX_VALUE);

//        System.out.println(reverse(x,""));
        System.out.println(reverseP(x));
    }



    public static int reverse(int x,int y){

        boolean sign = false;
        if(x<0){
            sign = true;
            x = x*-1;
        }

        String str =  String.valueOf(x);
        String resultStr = "";
        for (int i = 1; i <= str.length(); i++) {
            resultStr += String.valueOf(str.charAt(str.length()-i));
        }
        int result = 0;
        try {
            result = Integer.parseInt(resultStr);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        } finally {

        }
        if(sign){
            result=  result*-1;
        }

       return result;
    }



    //test Bigdecimal
    public static int reverse(int x) {
        //length 就是进位 * 10
        boolean sign = false;
        if(x<0){
            sign = true;
            x = x*-1;
        }
        String str = String.valueOf(x);
        BigDecimal result = BigDecimal.ZERO;
        for (int i = 0; i < str .length(); i++) {
            String num = String.valueOf(str.charAt(i));
            BigDecimal base = new BigDecimal(num);
            BigDecimal newPower = new BigDecimal(10).pow(i);
            BigDecimal resultValue = base.multiply(newPower);
            result = result.add(resultValue);
        }
        if(sign){
            result = result.negate();
        }
        return result.intValue();
    }


    public static int reverse(int x,String s) {
        if(x>Integer.MAX_VALUE||x<Integer.MIN_VALUE)
            return 0;
        int flag=x<0?-1:1;
        x = x * flag;
        int result=0;

        while(x > 0){
            int k = result;
            k *= 10;
            //取最小位数值
            int n = x % 10;
            k += n;
            //溢出
            if(k/10!=result)return 0;
            x = x / 10;
            result = k;
        }
        return result * flag;
    }
















    public static int reverseP(int x){
        if(x>Integer.MAX_VALUE || x<Integer.MIN_VALUE){
            return 0;
        }
        int flag = x>0?1:-1;
        x = x * flag;
        int result = 0;
        while (x>0){
            int k = result;
            // min
            int n = x%10;
            k *= 10;
            k += n;
            if(k/10 != result){
                return 0;
            }
            x = x/10;
            result = k;
        }
        return result;
    }
}
