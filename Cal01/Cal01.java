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
        System.out.println("Okay, let's add... " + FirstNum + " + " + SecondNum + " = " + (FirstNum + SecondNum));
		return;
    }
	
    void Subtract(String strFNum, String strSNum){
        Double FirstNum = Double.parseDouble(strFNum);
        Double SecondNum = Double.parseDouble(strSNum);
        System.out.println("Okay, let's subtract... " + FirstNum + " - " + SecondNum + " = " + (FirstNum - SecondNum));
		return;
    }
	
    void Multiplication(String strFNum, String strSNum){
        Double FirstNum = Double.parseDouble(strFNum);
        Double SecondNum = Double.parseDouble(strSNum);
        System.out.println("Okay, let's multiply... " + FirstNum + " * " + SecondNum + " = " + (FirstNum * SecondNum));
		return;
    }
	
    void Division(String strFNum, String strSNum){
		if(strSNum.contains("0")){
			System.out.println("For some reason, I am not allowed to do this opperation.");
			return;		// 7. Prvent the division by zero.
		}
        Double FirstNum = Double.parseDouble(strFNum);
        Double SecondNum = Double.parseDouble(strSNum);
        System.out.println("Okay, let's divide... " + FirstNum + " / " + SecondNum + " = " + (FirstNum / SecondNum));
		return;
    }
	
    void PowerOf(String strFNum, String strSNum){
		// 8. Add custom function to the DoSomeMath class of your choosing. 
        Double FirstNum = Double.parseDouble(strFNum);
        Double SecondNum = Double.parseDouble(strSNum);
		
		// this site was helpful
		// https://stackoverflow.com/questions/19734408/how-to-find-power-of-power-of-a-number-like-2109-in-java
        System.out.println("let's find the power... " + FirstNum + " raised to " + SecondNum + " = " + Math.pow(FirstNum, SecondNum));
		return;
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
            System.out.println("  5. PowerOf");
            System.out.println("  to quit press 'q'");
            System.out.print("Choose one:");

            // gether users menu entry
            String rawanswer = ManageKeyboard();
            //System.out.println("\nyour input was: " + rawanswer + " and this isInteger value: " + isInteger(rawanswer));

            // ArrayList<String> al = new ArrayList<String>();
            String[] goodChoices = {"1", "2", "3", "4", "5"};		// Think I have to update this to make it work.
            List list1 = Arrays.asList(goodChoices);
            boolean isMenuItem = Arrays.asList(goodChoices).contains(rawanswer);

			
            // should i quit?
			// had to adjust the 5 to 6 to allow for both.  
			// You know what, let just make it a q.  Keep it simple!!
            if(rawanswer.equals("q")){
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
					
					// did not like the new line, so want the input to be on the same line.
                    System.out.print("What is your first number? ");
                    fNum = ManageKeyboard();
                    isNum = isInteger(fNum);
                    reDo = true;
                } while (isNum == false);

                // get second number
                reDo = false;
                do {
                    if(reDo) System.out.print("You got somehting else wrong, try reading the directions.");
					
					// did not like the new line, so want the input to be on the same line.
                    System.out.print("What is your second number? ");
                    sNum = ManageKeyboard();
                    isNum = isInteger(sNum);
                    reDo = true;
                } while (isNum == false);

				// this was the only location where new methods are needed to be called from.
                switch(rawanswer) {
                    case "1": domath.Add(fNum, sNum);
                    case "2": domath.Subtract(fNum, sNum);
                    case "3": domath.Multiplication(fNum, sNum);
                    case "4": domath.Division(fNum, sNum);
                    case "5": domath.PowerOf(fNum, sNum);
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
