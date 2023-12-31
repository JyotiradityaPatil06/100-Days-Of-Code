// Largest subarray with 0 sum (GFG)

//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub {

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends

class GfG {
    int maxLen(int arr[], int n) {
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        int s = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            s = s + arr[i];

            if (h.containsKey(s))
                max = Math.max(max, i - h.get(s));
            else if (s == 0)
                max = i + 1;
            else
                h.put(s, i);
        }
        return max;
    }
}