

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P1135奇怪的电梯 {
    static int level[] ;
    static int levelst[] ;
    static boolean[] levels;
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] line = sc.readLine().split(" ");
        int leve = Integer.parseInt(line[0]);
        int stand = Integer.parseInt(line[1]);
        int end = Integer.parseInt(line[2]);
        level = new int[leve+5];
        levelst = new int[leve+5];
        levels = new boolean[leve+5];
        line = sc.readLine().split(" ");
        for (int i=1;i<=leve;i++){
            level[i]= Integer.parseInt(line[i-1]);
        }
        if (stand ==end){
            System.out.println(0);
            return;
        }else if (leve < end || end < 1 || leve < stand){
            System.out.println(-1);
            return;
        }
        System.out.println( count(stand,end,leve));
    }
    public static int count(int stand,int end,int levelt){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(stand);
        while (!queue.isEmpty()){
            int s= queue.poll();
            levels[s] = true;
            if (s + level[s] >0 && levelt >=s + level[s]){
                queue.add(s+level[s]);
                levels[queue.peek()] =true;
                levelst[s + level[s]] =s;
            }
            if (s + level[s]==end){
                return print(stand,end);
            }
            if(s - level[s] > 0){
                queue.add(s-level[s]);
                levels[queue.peek()] =true;
                levelst[s - level[s]] =s;
            }
            if (s - level[s]==end){
                return print(stand,end) ;
            }
        }
        return -1;
    }
    public static int print(int stand,int end){
        int j = levelst[end];
        int js=1;
        while (j !=stand){
            js++;
            j = levelst[j];
        }
        return js;
    }
}
