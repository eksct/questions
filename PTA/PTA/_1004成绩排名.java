package PTA;
import java.util.Arrays;
import java.util.Scanner;

public class _1004成绩排名 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] arr = new Student[n];
        for (int i =0 ;i< n;i++){
            arr[i]= new Student(sc.next(),sc.next(),sc.nextInt());
        }
        Arrays.sort(arr);
        System.out.printf("%s %s\n",arr[n-1].name,arr[n-1].xh);
        System.out.printf("%s %s\n",arr[0].name,arr[0].xh);

    }
}
class Student implements Comparable{
    String name;
    String xh;
    int cj;

    public Student(String name, String xh, int cj) {
        this.name = name;
        this.xh = xh;
        this.cj = cj;
    }
    @Override
    public int compareTo(Object o) {
        Student nt = (Student) o;
        return (this.cj-nt.cj);
    }
}
