package net.coderchen.practice.search;

/**
 * @author Liuyuchen
 * @date 2019/09/16
 * 字符串匹配
 * 在字符串A中匹配字符串B，则A为主串，B为模式串
 * 主串长度记作n，模式串长度记作m
 */
public class StringMatching {

    public static void main(String[] args) {
        //主串
        String mainString = "I wrote a hello world program when I first met coding.";
        //模式串
        String patternString = "hello world";
        boolean result = matchingByBF(mainString, patternString);
        System.out.println(result);
    }

    /**
     * BF算法
     * @param mainString
     * @param patternString
     * @return
     */
    private static boolean matchingByBF(String mainString, String patternString){
        int n = mainString.length();
        int m = patternString.length();
        //检索范围：0至n-m+1
        outer : for (int i = 0; i < n-m+1; i++) {
            inner : for (int j = 0; j < m; j++) {
                if(mainString.charAt(i+j) != patternString.charAt(j)){
                    break inner;
                }
                if(j == m-1){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * RK算法
     * @param mainString
     * @param patternString
     * @return
     */
    private static boolean matchingByRK(String mainString, String patternString){
        return false;
    }
}
