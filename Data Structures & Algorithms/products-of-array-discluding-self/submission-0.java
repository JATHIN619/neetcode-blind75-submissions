class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int target = 1;
            for(int j = 0; j<nums.length; j++){
                if(i != j){
                    target = target * nums[j];
                }
            }
            result[i] = target;
        }
        return result;
    }
}  
