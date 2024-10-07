
import java.util.*;

class Problem1 {
    final static float PI = 3.14f;
    static int sx, sy, sz;          // Start coordinates of the beetle

    public static void main(String[] args) {
        int i, N, x, y, z;
        float sum = 0.0f;
        Scanner sc = new Scanner(System.in);

        // Input number of points to be visited by the beetle
        N = sc.nextInt();
        N = 3 * N;

        sc.nextLine();  // When you try to input string immediate after integer input it not read it.Thats why you need to add this line for read your next string input line

        // Input the coordinates of the points (comma-separated values)
        String[] coordinates = sc.nextLine().split(",");


        int arr[] = new int[N];    // Declaring Array of size N

        //Converting coordinates into integer and storing in arr Array
        for (i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(coordinates[i]);
        }

        // Initialize beetle's starting coordinates
        sx = arr[0];
        sy = arr[1];
        sz = arr[2];

        // Compute the distance traveled for each leg of the journey
        for (i = 3; i < N; i += 3) {
            sum += shortDist(arr[i], arr[i + 1], arr[i + 2]);
        }
        System.out.printf("%.2f", sum);     //Final Output
    }

    // Method to calculate the shortest distance between the current point and the next point
    private static float shortDist(int x, int y, int z) {
        float dis;

        // Case where the beetle moves on the same face (same z-coordinate and x or y changes)
        if (z == sz && (y != sy || x != sx) && sz != 0) {
            if (x != sx) {
                dis = (2 * PI * (Math.abs(x - sx))) / 6.0f;
            } else {
                dis = (2 * PI * (Math.abs(y - sy))) / 6.0f;
            }
        }
        
        // Case where the beetle moves on the same face (same x-coordinate and z or y changes)
        else if (x == sx && (z != sz || y != sy) && sx == 0) {
            if (z != sz) {
                dis = (2 * PI * (Math.abs(z - sz))) / 6.0f;
            } else {
                dis = (2 * PI * (Math.abs(y - sy))) / 6.0f;
            }

        } 
        
        // Case where the beetle moves on the same face (same y-coordinate and z or x changes)
        else if (y == sy && (z != sz || x != sx) && sy == 0) {
            if (z != sz) {
                dis = (2 * PI * (Math.abs(z - sz))) / 6.0f;
            } else {
                dis = (2 * PI * (Math.abs(x - sx))) / 6.0f;
            }

        }
        
        // Case where the beetle moves between different faces (shortest path). Euclidean distance formula
        else {
            dis = (int) (Math.sqrt(Math.pow(x - sx, 2) + Math.pow(y - sy, 2)) + Math.abs(z - sz));
        }

        // Update the beetle's position
        sx = x;
        sy = y;
        sz = z;

        return dis;
    }
}