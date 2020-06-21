/**
* 注意判断star是否可用
    
    1. 遇到左括号直接放入栈
    2. 遇到右括号先判断栈中是否有有匹配，有匹配就出站
        2.1 如果栈中的元素为空那么此时的star全部也无用了，所以直接设为0
        2.2 如果没有匹配的就看是否有rightStar可用，有就rightStar--
        2.3 如果以上两者不满足则代表右括号无法匹配返回false
    3. 如果是star， 那么直接将starNum（用于匹配左括号）和righStarNum进行加1
    4.最后判断当前的starNum是否大于栈的大小，如果是则直接设为和栈一样大
    5. 最终利用starNum消除栈中元素
    6. 如果最后栈为空这位true
*/
class Solution {

    public boolean checkValidString(String s) {
        Stack<Character> stack = new Stack<>();
        int starNum = 0;
        int righStarNum = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                if (stack.size() != 0 && stack.peek() == '(') {
                    stack.pop();
                    if (stack.size() == 0) starNum = 0;
                }
                else if(righStarNum > 0)  {
                    righStarNum--;
                    if (starNum != 0) starNum--;
                }
                else return false;
            }
            else {
                starNum++;
                ++;
            }
            if (starNum > stack.size()) starNum = stack.size();
        }

        while(stack.size() != 0 && starNum != 0) {
            stack.pop();
            starNum--;
        }
        return stack.size() == 0 ? true : false;
    }

}