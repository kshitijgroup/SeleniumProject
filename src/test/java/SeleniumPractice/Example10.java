package SeleniumPractice;

import java.util.Arrays;

public class Example10 {
    
    public static void main(String[] args) {
        
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = nums1.length;
        int n = nums2.length;

        int u = m-1;
        for(int i=0;i<n;i++){
            nums1[u] = nums2[i];
            u--;
        }
        Arrays.sort(nums1);
        
        for(int k=0;k<m;k++){
            System.out.print(nums1[k] +" ");
        }
        
    }
}
