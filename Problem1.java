
import java.util.*;

class Problem1{
    final static float PI = 3.14f;
    static int sx, sy, sz;
    public static void main(String[] args) {
        int i, N, x, y, z;
        int arr[] = new int[50];
        float sum = 0.0f;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        N = 3 * N;
        for(i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        sx = arr[0];
        sy = arr[1];
        sz = arr[2];
        for(i = 3; i < N ; i += 3){
            sum += shortDist(arr[i], arr[i+1], arr[i+2]);
        }
        System.out.printf("%.2f", sum);
    }
    private static float shortDist(int x, int y, int z) {
        float dis;
        if(z == sz && (y == sy || x == sx ) && sz != 0){
            if(x != sx){
                dis = (2 * PI * (Math.abs(x - sx))) / 6.0f;
            }else{
                dis = (2 * PI * (Math.abs(y - sy))) / 6.0f;
            }
        }else{
            dis = (int)(Math.sqrt(Math.pow(x - sx, 2) + Math.pow(y - sy, 2)) + Math.abs(z - sz));
        }
        sx = x;
        sy = y;
        sz = z;
        return dis;
    }
}

