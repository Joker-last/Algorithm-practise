/*

ACM 模式：输入输出模板
给你输入两个整数 a 和 b，请你计算它们的和。

数据规模：
-1000 <= a, b <= 1000

输入格式：
输入包含多行数据，每行包含两个用空格分隔的整数。
你的每行输出对应着每行输入的求和结果。

示例输入:
1 2
-3 -4

示例输出:
3
-7

*/
import java.util.*;

// -- core code template start
class Solution {
    public int add(int a, int b) {
        return a + b;
    }
}
// -- core code template end

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int result = new Solution().add(a, b);
            System.out.println(result);
        }
        sc.close();
    }
}