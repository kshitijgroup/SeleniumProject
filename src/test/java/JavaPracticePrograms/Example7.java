package JavaPracticePrograms;

public class Example7 {
    
    public static void main(String[] args) {
        
        int arr[] = {1,4,2,5,3};
        int n = arr.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if((j-i+1)%2!=0){
                    for(int k=i;k<=j;k++){
                        sum += arr[k];
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
