class Solution {
    public java.util.List<java.util.List<String>> groupAnagrams(String[] strs) {
        java.util.List<java.util.List<String>> result = new java.util.ArrayList<>();
        boolean[] visited = new boolean[strs.length];
        
        for (int i = 0; i < strs.length; i++) {
            if (visited[i]) continue;
            
            java.util.List<String> group = new java.util.ArrayList<>();
            group.add(strs[i]);
            visited[i] = true;
            
            int left = i + 1;
            int right = strs.length - 1;
            
            while (left <= right) {
                if (!visited[left] && areAnagrams(strs[i], strs[left])) {
                    group.add(strs[left]);
                    visited[left] = true;
                }
                left++;
                
                if (left <= right && !visited[right] && areAnagrams(strs[i], strs[right])) {
                    group.add(strs[right]);
                    visited[right] = true;
                }
                right--;
            }
            
            result.add(group);
        }
        
        return result;
    }
    
    private boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        java.util.Arrays.sort(arr1);
        java.util.Arrays.sort(arr2);
        return java.util.Arrays.equals(arr1, arr2);
    }
}