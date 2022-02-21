package JavaPracticePrograms;

import java.util.Arrays;

public class Example4 {

    public static void main(String[] args){

            String[] str = {"java", "python", "csharp", "java", "ruby", "csharp"};
 
            boolean set;
            for(int i=0;i<str.length;i++){
                set = true;
                for(int j=0;j<i;j++){
                    if(str[i].equals(str[j])){
                        set = false;
                        break;
                    }
                }
                if(set==true){
                    System.out.println(str[i]);
                }
            }
        }
    }
