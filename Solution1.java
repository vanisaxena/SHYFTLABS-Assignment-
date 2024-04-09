// Time Complexity : E.S + B.S = O(log n)
// Exponential Search : O(log n) 
// Binary Search : O(log n)

public class Solution1 {
    public static int correct_index(int[] arr, int low, int high) {
        int ans = high;
        
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (arr[mid] == -1) {
                ans = Math.min(ans, ans);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    // Firstly, we are applying exponential search for searching the bounding region.
    public static int negative_index(int[] arr) {
        int maxi = Integer.MAX_VALUE;
        int i = 0;
        if (arr[0] == -1)
            return 0;
        i = 1;
        while (arr[i] != -1 && i < maxi)
            i = i*2;
        //  Calling binary search function to know the starting index of -1 in the bounding region.
        return correct_index(arr, i/2, i);
    }
    // We are taking two test cases for this code.
    public static void main(String[] args) {
        int[] arr1 = {3, 4, 1, 2, 7, 8, 20, 33, -1, -1, -1, -1};
        System.out.println("The starting index of -1 : " + negative_index(arr1));
        
        int[] arr2 = {-1, -1, -1, -1};
        System.out.println("The starting index of -1 : " + negative_index(arr2));
    }
}
