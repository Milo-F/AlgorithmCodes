/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;//进位判断
        ListNode tempListNode = new ListNode(0);//用于相加时移动的临时节点
        ListNode resultHead = tempListNode;//贮存结果头节点
        while(null != l1 || null != l2 || carry){//循环，当且仅当l1、l2都为空并且没有进位时进入加法运算，防止5+5=10
            //运算数检测完善
            if(l1 == null){
                l1 = new ListNode(0);//l1为空则补零
            }
            if(l2 == null){
                l2 = new ListNode(0);//l2为空则补零
            }
            //加法运算
            if(carry){//若有进位
                tempListNode.val = (l1.val+l2.val+1);
            }else{//若无进位
                tempListNode.val = (l1.val+l2.val);
            }
            if(tempListNode.val >= 10){//取余只取个位数
                tempListNode.val = tempListNode.val%10;
                carry = true;//保存进位
            }else{
                carry = false;
            }
            //下一步运算准备
            if(null != l1.next || null != l2.next || carry){//若下次运算存在
                tempListNode.next = new ListNode(0);//初始化下一个节点
            }
            tempListNode = tempListNode.next;//指向下一个节点
            l1 = l1.next;
            l2 = l2.next;
        }
        return resultHead;//返回结果
    }
}
// @lc code=end

