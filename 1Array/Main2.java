/*
ACM 模式：T 组询问模板
请你计算一个长度为 n 的一维数组 nums 中所有元素之和。

数据范围：
1 <= n <=  10^5
1 <= nums[i] <= 10^9

输入格式:
第一行包含一个整数 T（1≤T≤100），表示询问的组数。
接下来依次描述这 T 组数据。每组数据的第一行包含一个整数 n，表示数组长度。第二行包含 n 个正整数，为数组元素。

输出格式:
输出共 T 行，每行一个整数，表示对应数组元素之和。

示例输入:
3
3
1 4 7
1
1000
2
1 2

示例输出:
12
1000
3

解释：
第一组数组为 [1, 4, 7]，元素和为 12；第二组数组为 [1000]，元素和为 1000；第三组数组为 [1, 2]，元素和为 3。
*/
import java.util.*;

// -- core code template start
class Solution {
    public long sumArray(int[] nums) {
        long sum = 0;
        for(int num : nums) {
            sum += num;
        }
        return sum;
    }
}
// -- core code template end

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();
        // 要一直读取到 EOF 才停止
        while (sc.hasNextInt()) {
            // 先读取 T
            int t = sc.nextInt();

            for (int i = 0; i < t; i++) {
                // 读取数组
                int n = sc.nextInt();
                int[] nums = new int[n];
                for (int j = 0; j < n; j++) {
                    nums[j] = sc.nextInt();
                }
                // 打印答案
                System.out.println(solution.sumArray(nums));
            }

        }
        sc.close();
    }
}
