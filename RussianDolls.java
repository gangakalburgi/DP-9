/*
algoeithm is same as LIS problem. But the first stpe would be sort the array according to width.

TC: O(n^2)
SC:O(n)
*/
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        if(envelopes.length == 0 || envelopes == null)return 0;
        
        //sort the envelopes according to width
        Arrays.sort(envelopes,(a,b) -> a[0]-b[0]);
        
        int[]dp = new int[envelopes.length];
        Arrays.fill(dp,1);
        
        //use similar approach as LIS
        int maxLen =1;
        for(int i = 1;i < envelopes.length;i++){
            for(int j = 0;j < i;j++){
                if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    maxLen = Math.max(dp[i],maxLen);
                }
            }
        }
        return maxLen;
        
    }
}