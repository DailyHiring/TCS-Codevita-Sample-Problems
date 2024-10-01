import java.util.*;

class Problem2 {
    
    static int sortExceptK(int brr[], int k, int n) {

        Arrays.sort(brr);
        // Store last element (originally k-th)
        int last = brr[n];
        // Move all elements from k-th to one position ahead.
        for (int i = n; i > k; i--) {
            brr[i] = brr[i - 1];
        }
        // Restore k-th element
        brr[k] = last;
        return 0;
    }

    public static void swap(int[] brr, int x, int y) {
        int temp = brr[x];
        brr[x] = brr[y];
        brr[y] = temp;
    }
    // function to sort all the boxes except the box at kth postion

    public static void main(String[] args) throws java.lang.Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int arr[] = new int[n];
        int brr[] = new int[n];
        int i = 0;
        int answer = 0;
        while (i < n) {
            arr[i] = s.nextInt();
            brr[i] = arr[i];
            i++;
        }

        sortExceptK(brr, k - 1, n - 1);
        for (i = 0; i < n; i++) {
            // To find the original position of each box before swapping
            int j;
            for (j = i; j < n; j++) {
                // if position of block is found then break from the loop
                if (brr[i] == arr[j])
                    break;
            }
            // no need of swapping if original position is same as the sorted position
            if (j == i)
                continue;
            // if minimum weight box is not at its correct position
            if (i == 0) {
                // add cost of swap of operation to answer
                answer += arr[i] * arr[j];
                // swap the boxes
                swap(arr, i, j);
                continue;
            }
            // Take minimum weight box as the intermediate box for swapping
            answer += 2 * Math.min(arr[i], arr[j]) * brr[0] + Math.max(arr[j], arr[i]) * brr[0];
            // swap the boxes
            swap(arr, i, j);
        }
        // minimum effort
        System.out.println(answer);
    }
}