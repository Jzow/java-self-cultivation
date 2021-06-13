/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

/*
 * https://leetcode-cn.com/problems/first-bad-version/solution/javajian-dan-er-fen-fa-zhao-dao-di-yi-ge-mlzz/
 * 查询错误版本号的题解
 * 此题通过二分查找解答
 */
public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        int first = 1, end = n;
        while(first < end){
            // 这里end - first 是为了防止溢出
            int mid = first + (end - first) / 2;
            if(isBadVersion(mid)){
                end = mid;
            }else{
                first = mid + 1;
            }
        }
        return first;
    }
}
