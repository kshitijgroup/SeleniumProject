package SeleniumPractice;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Example12 {
    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(new FileReader("/Users/kshitijchaudhary/Desktop/SublimeFiles/StringData.txt"));

        List<String> li = new ArrayList<>();
        List<String> res = new ArrayList<>();
        while(sc.hasNext()){
            li.add(sc.next());
        }

        System.out.println(li);

        String str[] = new String[li.size()];
        int ind=0;
        for(String val : li){
            str[ind] = val;
            ind++;
        }

        res = findUniquePrograms(str);

        System.out.print(res);
    }

    public static ArrayList<String> findUniquePrograms(String str[]){

        ArrayList<String> lis = new ArrayList<>();
        boolean flag = true;
        for(int i=0;i<str.length;i++){
            flag = true;
            int j;
            for(j=0;j<str.length;j++){
                if(i!=j && str[i].equalsIgnoreCase(str[j])){
                    flag = false;
                    break;
                }
            }

            if(flag==false){
                continue;
            }

            if(flag==true){
                lis.add(str[i]);
            }
            


        }
        return lis;
    }
}
