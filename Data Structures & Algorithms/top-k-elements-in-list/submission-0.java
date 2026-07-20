class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        
        // Sort using built-in method (works without import)
        java.util.Arrays.sort(nums);
        
        // Count unique elements
        int uniqueCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) uniqueCount++;
        }
        
        // Store unique elements and frequencies
        int[] uniqueElements = new int[uniqueCount];
        int[] frequencies = new int[uniqueCount];
        
        int index = 0;
        int count = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                count++;
            } else {
                uniqueElements[index] = nums[i-1];
                frequencies[index] = count;
                index++;
                count = 1;
            }
        }
        uniqueElements[index] = nums[nums.length - 1];
        frequencies[index] = count;
        
        // Find top k frequent elements
        int[] result = new int[k];
        boolean[] used = new boolean[uniqueCount];
        
        for (int i = 0; i < k; i++) {
            int maxFreq = -1;
            int maxIndex = -1;
            
            for (int j = 0; j < uniqueCount; j++) {
                if (!used[j] && frequencies[j] > maxFreq) {
                    maxFreq = frequencies[j];
                    maxIndex = j;
                }
            }
            
            result[i] = uniqueElements[maxIndex];
            used[maxIndex] = true;
        }
        
        return result;
    }
}