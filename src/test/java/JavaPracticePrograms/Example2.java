package JavaPracticePrograms;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        
        int arr1[] = {1, 3, 5, 6, 7 , 11};
        int arr2[] = {0, 2, 4, 6, 8, 9, 10};
        int n = arr1.length;
        int m = arr2.length;
        // code here
        int low = 0;
        int high = 0;

        while (low < n && high < m) {
            if (arr1[low] < arr2[high]) {
                System.out.print(arr1[low] + " ");
                low++;
            } else if (arr2[high] < arr1[low]) {
                System.out.print(arr2[high] + " ");
                high++;
            } else {
                System.out.print(arr2[high] + " ");
                high++;
                low++;
            }
        }

        if (low < n) {
            for (int i = low; i < n; i++) {
                System.out.print(arr1[i] + " ");
            }
        }
        if (high < m) {
            for (int i = high; i < m; i++) {
                System.out.print(arr2[i] + " ");
            }
        }
    }
}