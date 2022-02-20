package SeleniumPractice;

public class Example11 {

    public static void main(String[] args) {

        String arr1[] = { "Java", "Python", "Ruby","Java", "C" };
        String arr2[] = { "Python", "Ruby", "Python" };
        String arr3[] = new String[arr1.length];

        boolean flag = true;
        boolean unique = true;

        int ind = 0;

        for (int i = 0; i < arr1.length; i++) {
            flag = true;
            for (int j = 0; j < i; j++) {
                if (arr1[i].equalsIgnoreCase(arr1[j])) {
                    flag = false;
                    break;
                }
            }

            if (flag == true) {
                for (int k = 0; k < arr2.length; k++) {
                    unique = true;
                    if (arr1[i].equalsIgnoreCase(arr2[k])) {
                        unique = false;
                        break;
                    }
                }
                if (unique == true) {
                    arr3[ind] = arr1[i];
                    ind++;
                }
            }
        }

        for (int i = 0; i < arr3.length; i++) {
            if(arr3[i]!=null){
                System.out.println(arr3[i]);
            }
        }
    }
}
