import java.util.Arrays;

class twofen {
    public  boolean twocheek(int a[],int n) {//二分查找数组内相同值
        System.out.println("排序后"+Arrays.toString(a));
        int mid = (a.length-1) / 2;
        int left=0, right=a.length-1;
        if(n >a[a.length-1]){
            System.out.println("数值过大");
            return false;
        }else if (n<a[0]){
            System.out.println("数值过小");
            return false;
        }
        while (a[mid]!=n) {
            if (left==right){
                System.out.println("找不到该数值");
                return false;
            }
            if (a[mid] > n) {
                right = right-1;
            } else
                left = left+1;
            mid = (right+left)/2;
        }
        System.out.println("相同值下标"+mid);
        return true;
    }
     public  int twosort(int a[],int n) {//二分插入
         System.out.println("排序后"+Arrays.toString(a));
        int b[] = new int[a.length+10];
        for (int i = 0;i<a.length;i++){
            b[i]=a[i];
        }
         int mid = (a.length-1) / 2;
         int left=0, right=a.length-1;
         while (left <=right) {
             if (a[mid] > n) {
                 right = right-1;
             } else
                 left = left+1;
             mid = (right+left)/2;
         }
         System.out.println("插入位置下标"+left);
         for (int i =a.length-1;i>=left;i--){
             b[i+1]=b[i];
         }
         b[left]=n;
         for (int i=0;b[i]!=0;i++){
             System.out.print(b[i] + " ");
         }
         return 0;
     }
}

