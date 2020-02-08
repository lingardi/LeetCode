package com.example.leetcode.newcoder.offer;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class IsNumeric {
    public boolean isNumeric(char[] str) {
        if (str.length == 0)
            return false;
        boolean point = false;
        boolean exp = false;
        for (int i = 0; i< str.length; i++){
            if (str[i] == '+' || str[i] == '-'){
                //只有'+'、'-'或者后面不是数字
                if (i == str.length - 1 || !(str[i+1] >= '0' && str[i+1] <= '9' || str[i + 1] == '.')){
                    return false;
                }
                //'+'、'-'前一位必须是e、E
                if (i > 0 && (str[i - 1] == 'e' || str[i - 1] == 'E')) {
                    continue;
                }
                //'+'、'-'只出现在第一位
                if (i > 0){
                    return false;
                }
            }else if (str[i] == '.'){
                if (point || exp || !(i < str.length - 1 && str[i+1] >= '0' && str[i+1] <= '9')){
                    return false;
                }
                point = true;
            }else if (str[i] == 'e' || str[i] == 'E'){
                if (exp || i == str.length - 1 || !(str[i+1] >= '0' && str[i+1] <= '9' || str[i+1] == '+' || str[i+1] == '-')){
                    return false;
                }
                exp = true;
            }else if (str[i] >= '0' && str[i] <= '9'){

            }else {
                return false;
            }
        }
        return true;
    }
}
