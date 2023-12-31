// Minimum Swaps to Sort (GFG)

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Solution {
    // Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[]) {
        int count = 0;
        int[] num1 = Arrays.copyOf(nums, nums.length);
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        Arrays.sort(num1);

        for (int i = 0; i < nums.length; i++) {
            if (num1[i] != nums[i]) {

                int b = map.get(num1[i]);

                nums[i] = nums[i] ^ nums[b];
                nums[b] = nums[i] ^ nums[b];
                nums[i] = nums[i] ^ nums[b];

                map.put(nums[i], i);
                map.put(nums[b], b);
                count++;
            }
        }

        return count;
    }
}