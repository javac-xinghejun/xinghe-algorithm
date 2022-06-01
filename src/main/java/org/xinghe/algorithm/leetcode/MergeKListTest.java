package org.xinghe.algorithm.leetcode;


import org.xinghe.algorithm.datastructure.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/vvXgSW/
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/vvXgSW
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 星河君❀❀ 2022/5/9 20:10
 * @see [相关类/方法]
 * @since [版本号]
 */
public class MergeKListTest {
    public static ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];

            while (node != null) {
                list.add(node.val);
                node = node.next;
            }
        }
        Integer[] integers = list.toArray(new Integer[0]);
        Arrays.sort(integers);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int i = 0; i < integers.length; i++) {
            cur.next = new ListNode(integers[i]);
            cur = cur.next;
        }

        return dummy.next;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        // 假设第一个元素的第一个节点就是最小的
        ListNode firstListNode = lists[0];
        ListNode minNode = firstListNode;
        ListNode dummy = new ListNode(0);
        dummy.next = minNode;
        ListNode current = dummy.next;
        while (current.next != null) {
            // 从lists的index==1位置开始遍历
            for (int i = 1; i < lists.length; i++) {
                ListNode temp = lists[i];
                // 如果这个节点的值比最小节点的值小
                if (temp.val < current.val){
                    ListNode next = current.next;
                    current = temp;
//                    temp =
                }
                while (temp != null) {

                    temp = temp.next;
                }
            }
            current = current.next;
        }
//        for (int i = 0; i < lists.length; i++) {
//            ListNode node = lists[i];
//            if (minNode.val > node.val){
//                minNode = node;
//            }
//        }


        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            while (node != null) {
                list.add(node.val);
                node = node.next;
            }
        }
        Integer[] integers = list.toArray(new Integer[0]);
        Arrays.sort(integers);
//        ListNode dummy = new ListNode(0);
//        ListNode cur = dummy;
//        for (int i = 0; i < integers.length; i++) {
//            cur.next = new ListNode(integers[i]);
//            cur = cur.next;
//        }

        return dummy.next;
    }
}
