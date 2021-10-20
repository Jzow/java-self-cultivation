public class MinArraySum {
    public int minMoves(int[] nums) {
        int minNum = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums){
            res += num - minNum;
        }
        return res;
    }
}
