import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

//    public static void main(String[] args) {
//        Calculator c = new Calculator();
//        String text = "1,2,3,4:5";
//
//        /* split, sum 처리 */
//        int sum = c.sum(text);
//
//        System.out.print("문자열 " + text +" 을(를) 분리하여 숫자만 더한 값? : " + sum);
//    }


    /**
     * Split Method
     *
     * @param text 분리할 String 문자열
     * @return 분리 후 String[] 배열 리턴
     */
    public String[] splitText(String text){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()) {
            String customDelimeter = m.group(1);
            String[] tokens = m.group(2).split(customDelimeter);
        }
        return text.split(",|:");
    }

    /**
     * sum Method
     *
     * @param text sum 수행할 numbers Array
     * @return sum 리턴
     */
    public int sum(String text){
        int result = 0;
        String[] numberStrings;

        if(text == null || text.isEmpty())
            return 0;

        numberStrings = splitText(text);

        for(String n : numberStrings)
            result += parsePositiveNumber(n);

        return result;
    }

    /**
     * 음수 : RuntimeException 예외를 던진다.
     * 양수 : integer 값 리턴
     *
     * @param n numbers Array 문자열 n을 하나씩 받아온다.
     * @return Integer 캐스팅 한 String n
     */
    public int parsePositiveNumber(String n) {
        int num = Integer.parseInt(n);
        if (num < 0)
            throw new RuntimeException();
        return num;
    }
}