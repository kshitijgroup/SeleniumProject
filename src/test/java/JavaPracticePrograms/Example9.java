package JavaPracticePrograms;

import java.util.ArrayList;
import java.util.List;

public class Example9 {
    
    public static void main(String[] args) {
        
        //Scanner sc = new Scanner(System.in);
        //String input = sc.nextLine();
        String input = "CoffeeMachineKshitijChaudhary";
        char[] c = input.toCharArray();
        int start = 0;
        List<String> al = new ArrayList<>();
        for(int end=1;end<c.length;end++){
            if(Character.isUpperCase(c[end])){
                al.add(input.substring(start, end));
                start = end;
            }
        }
        al.add(input.substring(start, c.length));
        System.out.println("Input is "+input);
        for(String word : al){
            System.out.println(word);
        }
        //sc.close();
    }
}
