package leetCode;

import java.util.HashMap;
import java.util.Map;

public class 罗马数字转整数 {

    public static void main(String[] args) {
        romanToInt("MCMXCIV");
    }


    public static int romanToInt(String s) {
        Map<String,Integer> paramMap = new HashMap<>();
        paramMap.put("I",1);
        paramMap.put("V",5);
        paramMap.put("X",10);
        paramMap.put("L",50);
        paramMap.put("C",100);
        paramMap.put("D",500);
        paramMap.put("M",1000);
        paramMap.put("IV",4);
        paramMap.put("IX",9);
        paramMap.put("XL",40);
        paramMap.put("XC",90);
        paramMap.put("CD",400);
        paramMap.put("CM",900);
        int result = 0;
        //是否需要跳过
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if(flag){
                flag = false;
                continue;
            }
            String left = String.valueOf(s.charAt(i));
            String right = "";
            if(i<s.length()-1){
                right = String.valueOf(s.charAt(i+1));
            }
            // 判断左边是否小于右边
            int leftValue = paramMap.get(left);
            int rightValue = paramMap.get(right)==null?0:paramMap.get(right);
            int resultAdd = 0;
            if(leftValue<rightValue){
                flag = true;
                resultAdd = paramMap.get(left+right);
            }else{
                flag = false;
                resultAdd = leftValue;
            }
            result += resultAdd;
        }
        System.out.println(result);
        return result;
    }


    public int romanToIntStandard(String s) {
        int result=0;
        int length = s.length();
        for(int i = 0;i<length;i++){

            switch(s.charAt(i)){
                case 'I':
                    result+=1;
                    break;
                case 'V':
                    result+=5;
                    break;
                case 'X':
                    result+=10;
                    break;
                case 'L':
                    result+=50;
                    break;
                case 'C':
                    result+=100;
                    break;
                case 'D':
                    result+=500;
                    break;
                case 'M':
                    result+=1000;
                    break;
            }

            if(i!=0){
                if(((s.charAt(i)=='V' || s.charAt(i)=='X') && s.charAt(i-1)=='I')){
                    result = result -1*2;
                }

                if(((s.charAt(i)=='L' || s.charAt(i)=='C') && s.charAt(i-1)=='X')){
                    result = result -2*10;
                }

                if(((s.charAt(i)=='D' || s.charAt(i)=='M') && s.charAt(i-1)=='C')){
                    result = result -2*100;
                }

            }
        }
        return result;

    }
}
