package SeleniumPractice;

public class Example8 {

    public static void main(String[] args) {
        int[][] image = { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } };
        int row = image.length;
        int col = image[0].length;
        int[][] result = new int[row][col];
        int k=0;
        for (int[] part : image) {
            result[k] = invert(part);
            k++;
        }
        // for (int i = 0; i< image.length; i++)
        // {
        // image[i] = invert(image[i]);
        // }

        for(int[] i : image){
            for(int j : i){
                System.out.print(j + "\t");
            }
            System.out.println();
        }
        System.out.println(image);
    }

    public static int[] invert(int[] arr) {

        int j = 0;
        int brr[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                brr[j] = 1;
            }
            if (arr[i] == 1) {
                brr[j] = 0;
            }
            j++;
        }
        return brr;
    }
}
