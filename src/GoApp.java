import java.util.Collections;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

public class GoApp {
    public static Exercise exer1 = new Exercise();
    public static Converter conv1;
    public static String a;
    public static String b;

    public static void main(String[] args) {
        //System.out.println("Ваш пример: " + exer1.getPrimer());
        //System.out.println("Первое число: " + exer1.getNum1());
        //System.out.println("Второе число: " + exer1.getNum2());
        //System.out.println("Знак операции: " + exer1.getOperation());
        a = exer1.getNum1();
        b = exer1.getNum2();
        for(int i = 0; i < Converter.ROME.length; i++){
            if (a.equals(Converter.ROME[i])){
                for (int j = 0; j < Converter.ROME.length; j++){
                    if(b.equals(Converter.ROME[j])){
                        conv1 = new Converter();
                        a = Converter.getValue1();
                        b = Converter.getValue2();
                        Calculator calc1 = new Calculator();
                        Calculator.computation();
                        System.out.println("Ответ: " + conv1.arabToRoman(Calculator.getAnswer()));
                        System.exit(0);
                    }
                }
            }
        }
        Calculator calc1 = new Calculator();
        Calculator.computation();
        if( 0 < Calculator.getNum1() & Calculator.getNum1() < 11 & 0 < Calculator.getNum2() & Calculator.getNum2() < 11){
            System.out.println("Ответ: " + Calculator.getAnswer());
        } else {
            System.out.println("Введен неверный пример");
        }
    }
}
class Exercise {
    private String num1;
    private String num2;
    private String primer;
    private String operation;
    private String getExercise(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите пример ");
        return in.nextLine().replaceAll(" ", "");
    }
    public Exercise(){
        primer = getExercise();
        try {
            String[] nums = primer.split("[+\\-*/]");
            num1 = nums[0];
            num2 = nums[1];
            if(primer.contains("+")){
                operation = "+";
            } if(primer.contains("-")){
                operation = "-";
            } if (primer.contains("*")){
                operation = "*";
            } if (primer.contains("/")) {
                operation = "/";
            }
        } catch (Exception ex) {
            System.out.println("Неверно введен пример");
            System.exit(0);
        }
    }
    public String getPrimer(){
        return primer;
    }
    public String getNum1(){
        return num1;
    }
    public String getNum2(){
        return num2;
    }
    public String getOperation(){
        return operation;
    }
}
class Converter {
    private static String value1;
    private static String value2;
    public static final String[] ARAB = new String[]{"10", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    public static final String[] ROME = new String[]{"X", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private static void convertNum1(){
        for (int i = 0; i < ROME.length; i++){
            if(GoApp.exer1.getNum1().equals(ROME[i])) {
                value1 = ARAB[i];
            }
        }
    }
    private static void convertNum2(){
        for (int i = 0; i < ROME.length; i++){
            if(GoApp.exer1.getNum2().equals(ROME[i])) {
                value2 = ARAB[i];
            }
        }
    }
    public Converter(){
        convertNum1();
        convertNum2();
    }
    public static String getValue1(){
        return value1;
    }
    public static String getValue2(){
        return value2;
    }
    public static String arabToRoman(int k){
        if (k < 0){
            return "Недопустимое значение для римского числа";
        }
        StringBuilder result = new StringBuilder();
        for(Integer key : units.descendingKeySet()){
            while (k >= key){
                k -= key;
                result.append(units.get(key));
            }
        }
        return result.toString();
    }
    private static final NavigableMap<Integer, String> units;
    static {
        NavigableMap<Integer, String> initMap = new TreeMap<>();
        initMap.put(100, "C");
        initMap.put(90, "XC");
        initMap.put(50, "L");
        initMap.put(40, "XL");
        initMap.put(10, "X");
        initMap.put(9, "IX");
        initMap.put(5, "V");
        initMap.put(4, "IV");
        initMap.put(1, "I");
        units = Collections.unmodifiableNavigableMap(initMap);
    }
}
class Calculator {
    private static int answer;
    private static int num1;
    private static int num2;

    private static int strToInt1() {
        int a2 = 0;
        try{
            a2 = Integer.parseInt(GoApp.a);
        } catch (Exception ex){
            System.out.println("Неверно введен пример");
            System.exit(0);
        }
        return a2;
    }
    private static int strToInt2(){
        int b2 = 0;
        try{
            b2 = Integer.parseInt(GoApp.b);
        } catch (Exception ex){
            System.out.println("Неверно введен пример");
            System.exit(0);
        }
        return b2;
    }
    public Calculator(){
        num1 = strToInt1();
        num2 = strToInt2();
    }
    public static int computation(){
        String c = GoApp.exer1.getOperation();
        switch(c){
            case "+":
                answer = num1 + num2;
                break;
            case "-":
                answer = num1 - num2;
                break;
            case "*":
                answer = num1*num2;
                break;
            case "/":
                answer = num1/num2;
                break;
        }
        return answer;
    }
    public static int getAnswer(){
        return answer;
    }
    public static int getNum1(){
        return num1;
    }
    public static int getNum2(){
        return num2;
    }
}
