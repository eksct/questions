package Sequential_structure;
/**
 * 输出菱形字符*/
public class B2025 {

    public static void main(String[] args) {
        for (int i=0;i < 2;i++){
            for (int x =0;x<2-i;x++){
                System.out.printf(" ");
            }
            for (int j=0;j < 2*i+1;j++){
                System.out.printf("*");
            }
            System.out.println();
        }
        for (int i=0;i < 3;i++){
            for (int j=0;j < i  ;j++){
                System.out.printf(" ");
            }
            for (int x=0;x < 5-2*i ;x++){
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}
