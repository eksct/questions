import java.util.Scanner;

public class L1_072 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [][] map = new int[3][3];
        int [] as = new int[10];
        int x=0,y=0;
        int [] sut = {0,0,0,0,0,0,10000,36,720,360,80,252,108,72,54,180,72,180,119,36,306,1080,144,1800,3600};
        for (int i = 0; i < 3;i++){
            for (int j = 0;j < 3;j++){
                map[i][j]=sc.nextInt();
                if (map[i][j]==0){y=i;x=j;}
                as[map[i][j]]++;
            }
        }
        for (int i =0;i<10;i++){
            if (as[i]==0){
                map[y][x]=i;
            }
        }
        for (int i=0;i<3;i++){
            System.out.println(map[sc.nextInt()-1][sc.nextInt()-1]);
        }
        int sct = sc.nextInt();
        switch (sct){
            case 1:
                System.out.printf("%d",sut[map[0][0]+map[0][1]+map[0][2]]);
                break;
            case 2:
                System.out.printf("%d",sut[map[1][0]+map[1][1]+map[1][2]]);
                break;
            case 3:
                System.out.printf("%d",sut[map[2][0]+map[2][1]+map[2][2]]);
                break;
            case 4:
                System.out.printf("%d",sut[map[0][0]+map[1][0]+map[2][0]]);
                break;
            case 5:
                System.out.printf("%d",sut[map[0][1]+map[1][1]+map[2][1]]);
                break;
            case 6:
                System.out.printf("%d",sut[map[0][2]+map[1][2]+map[2][2]]);
                break;
            case 7:
                System.out.printf("%d",sut[map[0][0]+map[1][1]+map[2][2]]);
                break;
            case 8:
                System.out.printf("%d",sut[map[0][2]+map[1][1]+map[2][0]]);
                break;
        }

    }
}
