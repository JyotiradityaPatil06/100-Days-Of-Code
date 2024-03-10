// Leetcode 2540. Minimum Common Value

class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums1)
            map.put(num, map.getOrDefault(num, 0) + 1);
        for (int num : nums2)
            if (map.containsKey(num))
                return num;

        return -1;
    }
}