package com.example.leetcode.leetcode.Sort;

public class Quick {
    /**
     * 快速排序最好的情况下是每次都正好将数组对半分，这样递归调用次数才是最少的。这种情况下比较次数为 CN=2CN/2+N，复杂度为 O(NlogN)。
     * 最坏的情况下，第一次从最小的元素切分，第二次从第二小的元素切分，如此这般。
     * 因此最坏的情况下需要比较 N2/2。为了防止数组最开始就是有序的，在进行快速排序时需要随机打乱数组。
     *
     * 基本实现思路：
     *
     * 1.从数列中挑出一个元素，称为 "基准"
     * 2.重新排序数列，所有元素比基准值小的摆放在基准前面，
     * 所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
     * 在这个分割之后，该基准是它的最后位置。这个称为分割操作。
     * 3.递归地把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * @param nums
     * @param low
     * @param high
     */
    public static void quickSort(int nums[], int low, int high){
        int left, right, base;
        if (low > high)
            return;
        left = low;
        right = high;
        base = nums[low];

        while (left < right){
            while (base <= nums[right] && left < right){
                right --;
            }
            while (base >= nums[left] && left < right){
                left ++;
            }

            if (left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        nums[low] = nums[left];
        nums[left] = base;
        //递归调用左半数组
        quickSort(nums, low, right -1 );
        //递归调用右半数组
        quickSort(nums, right+1, high);
    }

    public static void main(String[] args){
        int[] data = new int[]{4, 7, 2, 5, 6, 1, 3};
        quick(data,0, 6);

        for (int i = 0; i <data.length; i++){
            System.out.println(data[i]);
        }
    }


    public static int getMiddle(int[] nums, int low, int high) {
        int temp = nums[low];//数组的第一个作为中轴
        while (low < high){
            while (low < high && nums[high] > temp){
                high--;
            }
            nums[low] = nums[high]; // 比中轴小的移动到低端
            while (low < high && nums[low] < temp){
                low++;
            }
            nums[high] = nums[low];//比中轴大的移动到高端
        }
        nums[low] = temp; //中轴记录到尾
        return low; // 返回中轴位置
    }

    public static void quick(int[] nums, int low, int high){
        if (nums.length == 0)
            return;
        if (low < high){
            int middle = getMiddle(nums, low, high);
            quick(nums, low, middle - 1);
            quick(nums, middle + 1, high);
        }

    }
}


