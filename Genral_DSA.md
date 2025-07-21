## Most Asked DSA Questions

### 1. Reverse a Linked List

**Explanation:**  
Reversing a linked list means changing the direction of the pointers so that the last node becomes the first node. This tests your understanding of pointers and linked list manipulation.

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
```

---

### 2. Find the Middle of a Linked List

**Explanation:**  
Use two pointers: the slow pointer moves one node at a time, while the fast pointer moves two nodes. When fast reaches the end, slow will be at the middle.

```java
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
```

---

### 3. Two Sum Problem

**Explanation:**  
Given an array of integers, return indices of two numbers that add up to a specific target. This problem checks your hashing skills.

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
}
```

---

### 4. Detect Cycle in a Linked List

**Explanation:**  
Use Floyd’s Cycle detection algorithm (Tortoise and Hare). If there’s a cycle, the fast and slow pointers will eventually meet.

```java
class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
```

---

### 5. Maximum Subarray Sum (Kadane’s Algorithm)

**Explanation:**  
Find the contiguous subarray with the largest sum. Kadane’s Algorithm is efficient and widely used for this.

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0], maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
```

---