## Recursion

#### QuickSort

1. Pivot Selection
2. Partitioning ( get the pivot index )
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
#### MergeSort
1.Divide the array into subparts.
2.Merge sortted list.
```
public class QuickSort {
    public static void merge(int[] arr,int low,int mid,int high){
        int[] b = new int[arr.length];
        int k = low;
        int i = low,j = mid + 1;
        while (i <= mid && j <= high) {
            if(arr[i] <= arr[j]){
                b[k++] = arr[i++];
            }
            else{
                b[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            b[k++] = arr[i++]; 
        }
        while (j <= high) {
            b[k++] = arr[j++];
        }
        for(int m = low;m < high;m++){
            arr[m] = b[m];
        }

    }
   
    public static void mergeSort(int[] arr,int low,int high){
        if( low == high)
          return;
        int mid = low + ( high - low )/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr,low,mid,high);
    }
    public static void main(String[] args) {
        int[] arr = {
            1,6,7,2,4,9
        };
        int n = arr.length;
        mergeSort(arr,0,n - 1);
        for(int i = 0;i < n;i++){
            System.out.println(arr[i]);
        }
    
    }
}

```