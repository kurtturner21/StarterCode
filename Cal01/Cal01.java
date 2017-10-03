import java.io.Console;
import java.util.Arrays;
import java.util.List;

/**
 * Created by turner on 9/11/2017.
 * Note that this code has errors and students are to review this code and fix the errors.
 * Yes this code is public and is mostly for first time Java Programmers. 
 */
 
/*
Hello, my name is John Turner.
The date of my code review is 10/03/2017
I am following the directions of the README.md 
*/

// this class allows for many methods given two numbers 
class DoSomeMath{
    void Add(String strFNum, String strSNum){
        Double FirstNum = Double.parseDouble(strFNum);
        Double SecondNum = Double.parseDouble(strSNum);
        System.out.println("Okay, lets add... " + FirstNum + " + " + SecondNum + " = " + (FirstNum + SecondNum));
    }
    void Subtract(String strFNum, String strSNum){
        Double FirstNum = Double.parseDouble(strFNum);
        Double SecondNum = Double.parseDouble(strSNum);
        System.out.println("Okay, lets add... " + FirstNum + " - " + SecondNum + " = " + (FirstNum - SecondNum));
    }
    void Multiplication(String strFNum, String strSNum){
        Double FirstNum = Double.parseDouble(strFNum);
        Double SecondNum = Double.parseDouble(strSNum);
        System.out.println("Okay, lets multiply... " + FirstNum + " * " + SecondNum + " = " + (FirstNum * SecondNum));
    }
    void Division(String strFNum, String strSNum){
		if(strSNum == "0") return;
        Double FirstNum = Double.parseDouble(strFNum);
        Double SecondNum = Double.parseDouble(strSNum);
        System.out.println("Okay, lets divide... " + FirstNum + " / " + SecondNum + " = " + (FirstNum / SecondNum));
    }
}

public class Cal01 {
    public static void main(String[] args) throws java.io.IOException{
        DoSomeMath domath = new DoSomeMath(); // doing math object

        // declare keyboard variables
        char choice;
        for(;;) {
            // dis play keyboard input
            System.out.println("\nHello, I would like to do some Math for you:");
            System.out.println("  1. Add");
            System.out.println("  2. Subtract");
            System.out.println("  3. Multiply");
            System.out.println("  4. Divide");
            System.out.println("  5. Quit? press 'q'");
            System.out.print("Choose one:");

            // gether users menu entry
            String rawanswer = ManageKeyboard();
            //System.out.println("\nyour input was: " + rawanswer + " and this isInteger value: " + isInteger(rawanswer));

            // ArrayList<String> al = new ArrayList<String>();
            String[] goodChoices = {"1", "2", "3", "4"};
            List list1 = Arrays.asList(goodChoices);
            boolean isMenuItem = Arrays.asList(goodChoices).contains(rawanswer);

            // should i quit?
            if(rawanswer.equals("q") | rawanswer.equals("5")){
                break;
            } else if (isMenuItem) {
                System.out.println("\nYou want to run some math!!!");
                String fNum;
                String sNum;
                boolean reDo, isNum;

                // get first number
                reDo = false;
                do {
                    if(reDo) System.out.println("You got somehting wrong, try reading the directions.");
                    System.out.println("What is your first number? ");
                    fNum = ManageKeyboard();
                    isNum = isInteger(fNum);
                    reDo = true;
                } while (isNum == false);

                // get second number
                reDo = false;
                do {
                    if(reDo) System.out.println("You got somehting else wrong, try reading the directions.");
                    System.out.println("What is your second number? ");
                    sNum = ManageKeyboard();
                    isNum = isInteger(sNum);
                    reDo = true;
                } while (isNum == false);

                switch(rawanswer) {
                    case "1": domath.Add(fNum, sNum);
                    case "2": domath.Subtract(fNum, sNum);
                    case "3": domath.Multiplication(fNum, sNum);
                    case "4": domath.Division(fNum, sNum);
                }


            } else {
                System.out.println(" I guess you cant read, so sad.");
            }


        } 
    }


    // manages all the keyboard entryes and returnes a string
    static String ManageKeyboard(){
        // pulled out the functionality of the keyboard into one class
        Console cnsl = null;
        String answer = "";
        try{
            cnsl = System.console();
            if(cnsl != null) answer = cnsl.readLine("");
        }
        catch(Exception ex) {ex.printStackTrace();}
        return answer;
    }
    

    // example found here:
    // https://stackoverflow.com/questions/5439529/determine-if-a-string-is-an-integer-in-java
    static boolean isInteger(String s) {
        return isInteger(s,10);
    }

    static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }
}
