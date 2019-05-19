
2 week
@@A
-[####5. Add Two Numbers II](https://leetcode.com/problems/add-two-numbers-ii/)
            之前都是用`C++`刷的题,现在用`java`
            写了N遍之后才发现`ListNode`容易丢,不改变的遍历一个`list`需要实例化一个遍历指针 :(
            大神 无比精妙
```
public class Solution {
##public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
-Stack<Integer>  s1 = new Stack<Integer> ();
-Stack<Integer>  s2 = new Stack<Integer> ();

-while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
-};
-while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
-}

-int sum = 0;
-ListNode list = new ListNode(0);
-while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
-}

-return list.val == 0 ? list.next : list;
##}
}
```
            我的<stack> ..拖泥带水
```
public class Solution3Stack {
@@public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
-Stack<Integer>  stack1 = new Stack<> ();
-Stack<Integer>  stack2 = new Stack<> ();

-ListNode head1 = l1;
-while (head1 != null) {
            stack1.push(head1.val);
            head1 = head1.next;
-}

-ListNode head2 = l2;
-while (head2 != null) {
            stack2.push(head2.val);
            head2 = head2.next;
-}

-Stack<Integer>  stack3 = new Stack<> ();
-int sum = 0;
-int addition = 0;
-while (!stack1.empty() || !stack2.empty()) {
            sum += addition;
            if (!stack1.empty()) {
                sum += stack1.pop();
            }
            if (!stack2.empty()) {
                sum += stack2.pop();
            }
            addition = sum / 10;
            stack3.push(sum % 10);
            sum = 0;
-}
-if(addition> 0){
            stack3.push(addition);
-}

-ListNode res = new ListNode(-1);
-ListNode headR = res;
-while (!stack3.empty()) {
            headR.next = new ListNode((int) stack3.pop());
            headR = headR.next;
-}
-return res.next;
@@}
}
```
@@R
-[Safe Object Publication in Java](https://vlkan.com/blog/post/201##/02/1##/java-safe-publication/)
            Safe Construction Practices
```
public class ThisEscape {
##public ThisEscape(EventSource source) {
-source.registerListener(
            new EventListener() {
                public void onEvent(Event event) {
                    doSomething(event);
                }
            });
##}
}
```
Here, **when ThisEscape publishes the EventListener, it implicitly publishes the enclosing ThisEscape instance** as well, because inner class instances contain a hidden reference to the enclosing instance.

If you are tempted to register an event listener or start a thread from a constructor, you can avoid the improper construction **by using a private constructor and a public factory method**, as shown in SafeListener below.

```
public class SafeListener {
@@private final EventListener listener;

@@private SafeListener() {
-listener = new EventListener() {
