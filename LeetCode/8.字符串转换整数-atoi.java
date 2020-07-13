/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
// class Solution {
//     public int myAtoi(String str) {
//         char[] strChar = str.toCharArray();
//         int len = str.length();
//         boolean negative = false, nextIsNumber = false;
//         long ans = 0;
//         for (int i = 0; i < len; ++i) {
//             switch (strChar[i]) {
//             case ' ' :
//                 i = nextIsNumber ? len : i;
//                 break;
//             case '-' :
//                 if (nextIsNumber) {
//                     i = len;
//                     break;
//                 }
//                 nextIsNumber = true;
//                 negative = true;
//                 break;
//             case '+' :
//                 if (nextIsNumber) {
//                     i = len;
//                     break;
//                 }
//                 nextIsNumber = true;
//                 negative = false;
//                 break;
//             default :
//                 if ((strChar[i] < '0' || strChar[i] > '9')) {
//                     i = len;
//                 } else {
//                     nextIsNumber = true;
//                     if (ans * 10 + strChar[i] - 48 > Integer.MAX_VALUE) {
//                         return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
//                     } else {
//                         ans = ans * 10 + strChar[i] - 48;
//                     }
//                 }
//             }
//         }
//         ans = negative ? -ans : ans;
//         return (int)ans;
//     }
// }
// // @lc code=end
class Automata{
    private int state=0;
    private int[][] table={{0,1,2,3},{3,3,2,3},{3,3,2,3},{3,3,3,3}};
    long ans=0;
    int sign=1;

    public int gets(char c){
        if(c==' ')return 0;
        if(c=='+'||c=='-')return 1;
        if(Character.isDigit(c))return 2;
        return 3;
    }

    public void get(char c){
        state=table[state][gets(c)];
        if(state==2){
            ans=ans*10+(c-'0');
            ans= sign==1 ? Math.min(ans,Integer.MAX_VALUE):Math.min(ans,-(long)Integer.MIN_VALUE);
        }
        if(state==1&&c=='-')sign=-1;
    }

}
class Solution {
    public int myAtoi(String str) {
        Automata auto=new Automata();
        char[] temp=str.toCharArray();
        for(char c:temp)
        auto.get(c);

        return auto.sign*(int)auto.ans;
    }
}

