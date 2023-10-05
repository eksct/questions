
import java.util.Scanner;

/**
 * 爆内存
 * **/
public class P7785 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] =  sc.nextInt();
        }
        int sum;
        int left;
        int right = n;
        int mid;
        for ( left = 0,mid = (left+right) >> 1;left < right;mid = (left+right) >> 1){
            sum = 0;
            for (int j = 0;j < n;j++){
                if (arr[j] >mid){
                    sum++;
                }
            }
            if (sum <= mid){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        System.out.println(mid);

//                    Arrays.stream(arr).filter(value -> value >= finalI).count();

    }
}
/**
 * c++
 * #include <bits/stdc++.h>
 * using namespace std;
 * #define mid(a,b)  (a + b) >> 1;
 * int main(){
 *     int n;
 *     cin >> n;
 *     int arr[n];
 *     for (int i = 0; i <n ; ++i) {
 *         cin >> arr[i];
 *     }
 *     int mid = 0;
 *     int left = 0;
 *     int right = n;
 *     mid = mid(left,right);
 *     for ( ; left < right; ) {
 *
 *         int sum = 0;
 *         for (int j = 0; j <n ; ++j)
 *             if (arr[j] > mid) sum++;
 *         if (sum <= mid) right = mid;
 *         else left = mid+1;
 *         mid = mid(left,right);
 *     }
 *     cout << mid << endl;
 *
 *     return 0;
 * }
 * **/
