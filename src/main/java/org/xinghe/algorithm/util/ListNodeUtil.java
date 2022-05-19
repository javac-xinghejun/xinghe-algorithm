package org.xinghe.algorithm.util;

import org.xinghe.algorithm.basics.ListNode;

/**
 * 描述
 *
 * @author 星河君❀❀ 2022/5/9 20:10
 * @see [相关类/方法]
 * @since [版本号]
 */
public class ListNodeUtil {


    public static String getListNodeVal(ListNode node){
        String s = "";
        while (node != null){
            s = s.concat(String.valueOf(node.val));
            node = node.next;
        }

        return s;
    }
    public static ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
