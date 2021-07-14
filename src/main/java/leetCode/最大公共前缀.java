package leetCode;

public class 最大公共前缀 {

    public static void main(String[] args) {
        String[] str = new String[]{"ab","a"};
        longestCommonPrefix(str);
    }

    public static String longestCommonPrefix(String[] strs) {

        String baseStr = strs[0];
        String result = "";
        boolean flag = false;
        for (int i = 0; i < baseStr.length(); i++) {
            char x = baseStr.charAt(i);
            for (int j = 1; j < strs.length; j++) {

                if(i+1>strs[j].length()){
                    flag = true;
                    break;
                }
                if(x!=strs[j].charAt(i)){
                    flag = true;
                    break;
                }
            }
            if(flag){
                return result;
            }
            result += String.valueOf(x);
        }
        return result;
    }



    public static String longestCommonPrefixCopy(String[] strs)
        {
            if (strs.length == 0)
            {
                return "";
            }
            if (strs.length == 1)    //只有一个则返回其唯一的一个字符串
            {
                return strs[0];
            }

            //不为空且字符串数量大于1
            //公共字符前缀是每个字符串都要有，所以后面的都必须有才算是公共前缀
            String ret = strs[0];   //定义第一个字符串为基准值，然后遍历字符串数组
            for (String str : strs)
            {
                //判断 str 是否以指定前缀 ret 开头，如果不是，则将ret 尾巴减去一个字符，在进入循环，是则退出循环
                while (!str.startsWith(ret))
                {
                    ret = ret.substring(0, ret.length() - 1);
                }
            }
            return ret;
        }

}
