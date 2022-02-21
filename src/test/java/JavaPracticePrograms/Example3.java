package JavaPracticePrograms;

public class Example3 {
    
    public static void main(String[] args) {
        
        int arr[] = {-4,3,-9,0,4,1};
        float pos = 0;
        float neg = 0;
        float zero = 0;
        float n = arr.length;
        for(Integer i : arr){
            if(i>0){
                pos++;
            }
            else if(i<0){
                neg++;
            }
            else{ 
                zero++;
            }
        }
        System.out.format("%.6f",(pos/n));
        System.out.println();
        System.out.printf("%.6f",(neg/n));
        System.out.println();
        System.out.printf("%.6f",(zero/n));
        
    }
}
