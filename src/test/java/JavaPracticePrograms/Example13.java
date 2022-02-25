package JavaPracticePrograms;

public class Example13 {
    
    public static void main(String[] args) {
        
        int arr[] = {2,1,2,3,4,5,6,7,8,9,10};
        int target = 15;
        boolean flag = true;
        int i=0;
        int j=i+1;
        int currSum = 0;
        for(i=0;i<arr.length;i++){
            currSum = arr[i];
            for(j=i+1;j<arr.length;j++){
                currSum = currSum + arr[j];
                if(currSum==target){
                    flag = false;
                    break;
                }
            }
            if(flag==false){
                System.out.println((i+1) +"," +(j+1));
                break;
            }
        }
        
        
    }
}
