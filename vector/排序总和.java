import java.util.Arrays;

public class 排序总和 {
    public static void Quick_Sort(int[] arr,int start,int end){
        if (start >= end) return;
        int left =start; int pivot = arr[start];int right = end;
        int temp=0;
        while (left < right){
            while(left < right && pivot <= arr[right]){
                right--;
            }
            while (left < right && pivot >= arr[left]){
                left++;
            }
             temp = arr[left];
            arr[left] = arr[right];
            arr[right] =temp;
        }
        arr[start] = arr[left];
        arr[left] =pivot;
        Quick_Sort(arr,start,right-1);
        Quick_Sort(arr,right+1,end);
    }
    static int[] MERGEtemp ;

//    public static void MERGE_SORT(int arr[],int start,int end){
//        if (end -start <= 1) return;
//        int ni=0;
//        int left = start; int right =end; int mid = left + end >> 1 ;
//        MERGE_SORT(arr,start,mid);
//        MERGE_SORT(arr,mid+1,end);
//    }

    public static void main(String[] args) {
        int[] arr = new int[]{
                10,9,12,125,27,7,5,0
        };
        Quick_Sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{
                10,9,12,125,27,7,5,0
        };
        MERGEtemp =new int[arr.length];
//        MERGE_SORT(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
