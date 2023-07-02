package 排序;
/**
 * 堆排序
 * */
public class heap_sort {
    private int heapSize;

    public void heapsort(int arr[]){
        heapSize =arr.length;
        for (int i=(heapSize>>1)-1;i>=0;i--)
            Down(i,arr);
        while (heapSize > 1){
            int temp = arr[0];
            arr[0] = arr[heapSize-1];
            arr[--heapSize] = temp;
            Down(0,arr);
        }
    }
    private void Down(int down,int[] arr){
        int element = arr[down];
        int mid = heapSize >> 1;
        while (down < mid){
            int childIndex = down<< 1 | 1;
            int child = arr[childIndex];
            int rightindex = childIndex+1;
            if (rightindex < heapSize && arr[rightindex] > child){
                child = arr[childIndex = rightindex];
            }
            if (element >= child)break;
            arr[down] = child;
            down = childIndex;
        }
        arr[down] = element;
    }
}
