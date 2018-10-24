/**
 * Created by uyiqgyy on 2018/9/5.
 */
public class test {

    public static int maxSubArray(int[] nums) {
        int[] sum = new int[10];
        sum[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sum[i] = sum[i-1] + nums[i];
            if(sum[i] < nums[i]) {
                sum[i] = nums[i];
            }
            if(max < sum[i]) {
                max = sum[i];
            } else {
                if(sum[i] < 0) sum[i] = 0;
            }
        }
        return max;

    }

    public static void main(String[] args){
        int[] nums = {-2,1};

        int max = maxSubArray(nums);

        System.out.print(max);
    }
}
