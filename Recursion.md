## Recursion

#### QuickSort

1. Pivot Selection
2. Partitioning
3. Recursion
   
```
class Solution {
    static void quickSort(int arr[], int low, int high) {
        if (low >= high) return;
        int pivotIndex = partition(arr, low, high);
        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int index = low;
        
        for (int i = low; i < high; i++) {
            if (arr[i] < pivot) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index++;
            }
        }
        
        int temp = arr[index];
        arr[index] = arr[high];
        arr[high] = temp;
        
        return index;
    }
}

```

##### Reverse Linked List

```
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null)
           return head;
        
        ListNode last = reverseList(head.next); // find last node
        head.next.next = head; // reverse link
        head.next = null; // remove exsisting link
        return last; // tell others that i am last ( return last)
    }
}
```