/**
 * Created by cdlichenglin on 2015/9/23.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return new ListNode(0);
        }

        ListNode result = new ListNode(0);
        ListNode head = result;

        int carry = 0;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = 0;
            if (sum >= 10) {
                carry = 1;
                sum = sum - 10;
            }
            head.next = new ListNode(sum);
            head = head.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode last = l1 == null ? l2 : l1;
        while (last != null) {
            int sum = last.val + carry;
            carry = 0;
            if (sum >= 10) {
                carry = 1;
                sum = sum - 10;
            }
            head.next = new ListNode(sum);
            head = head.next;
            last = last.next;
        }

        if (carry > 0) {
            head.next = new ListNode(carry);
        }


        return result.next;
    }

    public static void main (String[] args){
        AddTwoNumbers s = new AddTwoNumbers();
        ListNode l1 = new ListNode(9);
        ListNode l11 = new ListNode(3);
        ListNode l111 = new ListNode(7);
        l1.next = l11;
        l11.next = l111;
        ListNode l2 = new ListNode(2);
        ListNode l22 = new ListNode(6);
        ListNode l222 = new ListNode(6);
        l2.next = l22;
        l22.next = l222;

        long start = System.currentTimeMillis();

        ListNode result = s.addTwoNumbers(l1, l2);

        System.out.println("cost:" + (System.currentTimeMillis() - start) + " ms.");
        System.out.println("result:" + result);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }
}
