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
    public static boolean matchingByBF(String mainString, String patternString){
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
    public static boolean matchingByRK(String mainString, String patternString){
        //计算主串中各个子串的哈希值
        return false;
    }

//    /**
//     * BM算法 坏字符规则 + 好后缀规则
//     * @param mainString
//     * @param patternString
//     * @return
//     */
//    public static boolean matchingByBM(String mainString, String patternString){
//        int n = mainString.length();
//        int m = patternString.length();
//        //散列表
//        int[] hashTable = new int[256];
//        generateHashTable(patternString, hashTable);
//
//        //当前模式串和主串对齐的第一个字符在主串中的下标
//        int i = 0;
//        while(i < n-m){
//            int j;
//            // 模式串从后往前匹配
//            for (j = m - 1; j >= 0; --j) {
//                if (mainString.charAt(i + j) != patternString.charAt(j)) {
//                    // 坏字符对应模式串中的下标是 j
//                    break;
//                }
//            }
//            //匹配成功
//            if (j < 0) {
//                return true;
//            }
//            // 这里等同于将模式串往后滑动 j-bc[(int)a[i+j]] 位
//            i = i + (j - hashTable[(int)mainString.charAt(i + j)]);
//        }
//
//        return false;
//    }
//
//    /**
//     * 为模式串生成散列表
//     */
//    private static void generateHashTable(String patternString, int[] hashTable){
//        //初始化散列表
//        for (int i = 0; i < hashTable.length; i++) {
//            hashTable[i] = -1;
//        }
//        //模式串中的每一个字符，映射到哈希表中，value为字符在模式串中的下标
//        int length = patternString.length();
//        for (int i = 0; i < length; i++) {
//            int c = patternString.charAt(i);
//            hashTable[c] = i;
//        }
//    }
//
//    // b 表示模式串，m 表示长度，suffix，prefix 数组事先申请好了
//    private void generateGS(String b, int m, int[] suffix, boolean[] prefix) {
//        for (int i = 0; i < m; ++i) { // 初始化
//            suffix[i] = -1;
//            prefix[i] = false;
//        }
//        for (int i = 0; i < m - 1; ++i) { // b[0, i]
//            int j = i;
//            int k = 0; // 公共后缀子串长度
//            while (j >= 0 && b.charAt(j) == b.charAt(m-1-k)) { // 与 b[0, m-1] 求公共后缀子串
//                --j;
//                ++k;
//                suffix[k] = j+1; //j+1 表示公共后缀子串在 b[0, i] 中的起始下标
//            }
//            if (j == -1) {
//                prefix[k] = true; // 如果公共后缀子串也是模式串的前缀子串
//            }
//        }
//    }
//
//    // a,b 表示主串和模式串；n，m 表示主串和模式串的长度。
//    public int bm(char[] a, int n, String b, int m) {
//        int[] bc = new int[256]; // 记录模式串中每个字符最后出现的位置
//        generateHashTable(b, bc); // 构建坏字符哈希表
//        int[] suffix = new int[m];
//        boolean[] prefix = new boolean[m];
//        generateGS(b, m, suffix, prefix);
//        int i = 0; // j 表示主串与模式串匹配的第一个字符
//        while (i <= n - m) {
//            int j;
//            for (j = m - 1; j >= 0; --j) { // 模式串从后往前匹配
//                if (a[i+j] != b.charAt(j)) {
//                    break; // 坏字符对应模式串中的下标是 j
//                }
//            }
//            if (j < 0) {
//                return i; // 匹配成功，返回主串与模式串第一个匹配的字符的位置
//            }
//            int x = j - bc[(int)a[i+j]];
//            int y = 0;
//            if (j < m-1) { // 如果有好后缀的话
//                y = moveByGS(j, m, suffix, prefix);
//            }
//            i = i + Math.max(x, y);
//        }
//        return -1;
//    }
//
//    // j 表示坏字符对应的模式串中的字符下标 ; m 表示模式串长度
//    private int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
//        int k = m - 1 - j; // 好后缀长度
//        if (suffix[k] != -1) {
//            return j - suffix[k] +1;
//        }
//        for (int r = j+2; r <= m-1; ++r) {
//            if (prefix[m-r] == true) {
//                return r;
//            }
//        }
//        return m;
//    }


}
