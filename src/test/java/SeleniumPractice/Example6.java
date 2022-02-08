package SeleniumPractice;

public class Example6 {
    
    public static void main(String[] args) {
        
        String actHour = "12:45:54PM";
        StringBuffer sb = new StringBuffer(actHour);
        if(actHour.substring(8, 10).equals("PM")){
            String twelvehour = actHour.substring(0, 2);
            int militaryhour = 12+Integer.valueOf(twelvehour);
            sb.replace(0, 2, String.valueOf(militaryhour));
            sb.replace(8, 10, "");
            System.out.println(sb.toString());
        }
        else{
            if(actHour.substring(8, 10).equals("AM") && actHour.substring(0, 2).equals("12")){
                sb.replace(0, 2, "00");
                sb.replace(8, 10, "");
                System.out.println(sb.toString());
            }
            else{
                sb.replace(8, 10, "");
                System.out.println(sb.toString());
            }
        }
    }
}
