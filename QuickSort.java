
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