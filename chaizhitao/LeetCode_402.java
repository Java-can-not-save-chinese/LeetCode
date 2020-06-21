402. 移掉K位数字
给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。

注意:

num 的长度小于 10002 且 ≥ k。
num 不会包含任何前导零。
示例 1 :

输入: num = "1432219", k = 3
输出: "1219"
解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
示例 2 :

输入: num = "10200", k = 1
输出: "200"
解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
示例 3 :

输入: num = "10", k = 2
输出: "0"
解释: 从原数字移除所有的数字，剩余为空就是0。

class Solution {
  public static String removeKdigits(String num, int k) {
	
		int count = 0;
		for(int i = 0;i < k; i++) {
			char max = num.charAt(0);
			//System.out.println("max" + max);
			for(int j = 1; j < num.length(); j++) {
				if(max > num.charAt(j)) {
					num = num.substring(0, j - 1) + num.substring(j);
					count++;
					//System.out.println(num);
					break;
				} else {
					max = num.charAt(j);
				}
			}
		}
		if(count < k) {
			if(k - count >= num.length()) {
				num = "0";
			} else {
				num = num.substring(0, num.length() - k + count);
			}
		}
		while( num.length() > 0 && num.charAt(0) == '0') {
			num = num.substring(1, num.length());
		}
		if(num.length() == 0) {
			num = "0";
		}
		return num;
	
	}
}
