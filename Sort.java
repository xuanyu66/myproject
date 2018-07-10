import java.util.Arrays;
import java.util.Random;

/**
 * @author leon on 2018/6/29.
 * @version 1.0
 */
public class Sort {

    static void mergeSort(int[] nums, int start, int end){
        if(start >= end){
            return;
        }
        int len = end - start, mid =start + (len >> 1);
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        mergeSort(nums, start1, end1);
        mergeSort(nums, start2, end2);
        int[] temp = new int[(end - start) + 1];
        int i = 0;
        while(start1 <= end1 && start2 <= end2){
            temp[i++] = nums[start1] <= nums[start2] ? nums[start1++] : nums[start2++];
        }
        while(start1 <= end1){
            temp[i++] = nums[start1++];
        }
        while(start2 <= end2){
            temp[i++] = nums[start2++];
        }
        for (i = start; i <= end ; i++) {
            nums[i] = temp[i - start];
        }
    }

    private static void quickSort(int[] nums, int start, int end){
        if(start >= end) {
            return;
        }
        int head = start, tail = end, pivot = nums[head + (tail - head) / 2];
        while(head <= tail){
            while(nums[head] < pivot){
                head++;
            }
            while(nums[tail] > pivot) {
                tail--;
            }
            if(head < tail){
                int temp = nums[head];
                nums[head] = nums[tail];
                nums[tail] = temp;
                head ++;
                tail --;
            }else if(tail == head){
                head++;
            }
        }
        quickSort(nums, start, tail);
        quickSort(nums, head, end);
    }

    public static void main(String[] args) {
        int[] a =new int[20];
        for(int i=0;i<a.length;i++) {
            a[i] = (int) (new Random().nextInt(100));
        }
        System.out.println(Arrays.toString(a));
        //mergeSort(a,0, a.length - 1);
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
