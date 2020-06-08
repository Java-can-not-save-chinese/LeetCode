423. 从英文中重建数字
给定一个非空字符串，其中包含字母顺序打乱的英文单词表示的数字0-9。按升序输出原始的数字。

注意:

输入只包含小写英文字母。
输入保证合法并可以转换为原始的数字，这意味着像 "abc" 或 "zerone" 的输入是不允许的。
输入字符串的长度小于 50,000。
示例 1:

输入: "owoztneoer"

输出: "012" (zeroonetwo)
示例 2:

输入: "fviefuro"

输出: "45" (fourfive)

class Solution {
  public String originalDigits(String s) {

    char[] count = new char[26 + (int)'a'];
    for(char letter: s.toCharArray()) {
      count[letter]++;
    }

    int[] out = new int[10];

    out[0] = count['z'];
 
    out[2] = count['w'];

    out[4] = count['u'];

    out[6] = count['x'];

    out[8] = count['g'];

    out[3] = count['h'] - out[8];

    out[5] = count['f'] - out[4];

    out[7] = count['s'] - out[6];

    out[9] = count['i'] - out[5] - out[6] - out[8];
    out[1] = count['n'] - out[7] - 2 * out[9];

    StringBuilder output = new StringBuilder();
    for(int i = 0; i < 10; i++)
      for (int j = 0; j < out[i]; j++)
        output.append(i);
    return output.toString();
  }
}
