public class CheckSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int [] sum = new int [n + 1];
        for (int i = 1; i <= n; ++i){
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        Set<Integer> set = new HashSet<>();
        for (int j = 2; j <= n; ++j){
            set.add(sum[j - 2] % k);
            if(set.contains(sum[j] % k)){
                return true;
            }
        }
        return false;
    }
}
