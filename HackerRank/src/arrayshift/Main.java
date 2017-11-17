package arrayshift;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++)
        {
            a[a_i] = in.nextInt();
        }
        int output[] = shiftLeft(a, k);

        for (int i = 0; i < output.length; i++)
        {
            System.out.print(output[i] + " ");
        }

        in.close();
    }

    public static int[] shiftLeft(int[] nums, int k)
    {
        for (int i = 0; i < k; i++)
        {
            if (nums == null || nums.length <= 1)
            {
                return nums;
            }
            int start = nums[0];
            System.arraycopy(nums, 1, nums, 0, nums.length - 1);
            nums[nums.length - 1] = start;
        }
        return nums;
    }
}
