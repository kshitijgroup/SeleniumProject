package JavaPracticePrograms;

public class Example {
    
    public static void main(String[] args) {
        
        int arr[] = {-12, 11, -13, -5, 6, -7, 5, -3, -6};

        int low=0;
        int mid = 0;
        int high = arr.length-1;
        while(mid<=high){
            if(arr[mid]<0){
                swap(mid, low, arr);
                low++;
                mid++;
            }
            else if(arr[mid]>0){
                swap(mid, high, arr);
                high--;
            }
            else{
                mid++;
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void swap(int low, int high, int arr[]){
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}
