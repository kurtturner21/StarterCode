### The Objective
The objective of this project is to expose the student aspects of code review such as debugging code, feature requests, markdown documents and pull requests.  

Complete the tasks below to earn full credit for this project

For a guide on markdown use this [resource](http://commonmark.org/help/).

### Tasks (10 points each)
1. Add comments to the top of the Cal01.java that documents your name and what you are doing to the code. 
2. Debug the Cal01.java code to remove all errors. 
3. Document in this markdown document what you are doing correct errors. 
4. Add subtraction function to the DoSomeMath class.
5. Add multiplication function to the DoSomeMath class.
6. Add division function to the DoSomeMath class.
7. Prvent the division by zero.
8. Add custom function to the DoSomeMath class of your choosing. 
9. Add comments to the code to help readability. 
10. After using the link to create your own Github Repo create a Pull Request to submit your changes. 

### if you want to debug your quit statement:
```
    // should i quit?
    if(rawanswer.equals("q")) { 
        System.out.println("I can quit!!!: " + rawanswer + "    var class tyep:" + rawanswer.getClass().getName());
        break;
    }else { 
        System.out.println("I can't quit now..." + rawanswer + "    var class tyep:" + rawanswer.getClass().getName());
    }
```


### 3. Document in this markdown document what you are doing correct errors.
### These are the changes made to debug the code:
```
 import java.io.Console;
 -import java.util.Array;
 +import java.util.Arrays;
  import java.util.List;
  
  /**
   * Created by turner on 9/11/2017.
   * Note that this code has errors and students are to review this code and fix the errors.
   * Yes this code is public and is mostly for first time Java Programmers. 
   */
 + 
 +/*
 +Hello, my name is John Turner.
 +The date of my code review is 10/03/2017
 +I am following the directions of the README.md 
 +*/
  
  // this class allows for many methods given two numbers 
  class DoSomeMath{
 @@ -15,11 +21,27 @@ void Add(String strFNum, String strSNum){
          Double SecondNum = Double.parseDouble(strSNum);
          System.out.println("Okay, lets add... " + FirstNum + " + " + SecondNum + " = " + (FirstNum + SecondNum));
      }
 +    void Subtract(String strFNum, String strSNum){
 +        Double FirstNum = Double.parseDouble(strFNum);
 +        Double SecondNum = Double.parseDouble(strSNum);
 +        System.out.println("Okay, lets add... " + FirstNum + " - " + SecondNum + " = " + (FirstNum - SecondNum));
 +    }
 +    void Multiplication(String strFNum, String strSNum){
 +        Double FirstNum = Double.parseDouble(strFNum);
 +        Double SecondNum = Double.parseDouble(strSNum);
 +        System.out.println("Okay, lets multiply... " + FirstNum + " * " + SecondNum + " = " + (FirstNum * SecondNum));
 +    }
 +    void Division(String strFNum, String strSNum){
 +		if(strSNum == "0") return;
 +        Double FirstNum = Double.parseDouble(strFNum);
 +        Double SecondNum = Double.parseDouble(strSNum);
 +        System.out.println("Okay, lets divide... " + FirstNum + " / " + SecondNum + " = " + (FirstNum / SecondNum));
 +    }
  }
  
  public class Cal01 {
      public static void main(String[] args) throws java.io.IOException{
 -        DoSomeMath domath = new DoSomeMath; // doing math object
 +        DoSomeMath domath = new DoSomeMath(); // doing math object
  
          // declare keyboard variables
          char choice;
 @@ -28,8 +50,8 @@ public static void main(String[] args) throws java.io.IOException{
              System.out.println("\nHello, I would like to do some Math for you:");
              System.out.println("  1. Add");
              System.out.println("  2. Subtract");
 -            System.out.println("  3. Divide");
 -            System.out.println("  4. Multiply");
 +            System.out.println("  3. Multiply");
 +            System.out.println("  4. Divide");
              System.out.println("  5. Quit? press 'q'");
              System.out.print("Choose one:");
  
 @@ -46,16 +68,16 @@ public static void main(String[] args) throws java.io.IOException{
              if(rawanswer.equals("q") | rawanswer.equals("5")){
                  break;
              } else if (isMenuItem) {
 -                String.out.println("\nYou want to run some math!!!");
 +                System.out.println("\nYou want to run some math!!!");
                  String fNum;
                  String sNum;
 -                boolean reDo; isNum;
 +                boolean reDo, isNum;
  
                  // get first number
                  reDo = false;
                  do {
 -                    if(reDo) String.out.println("You got somehting wrong, try reading the directions.");
 -                    String.out.println("What is your first number: ");
 +                    if(reDo) System.out.println("You got somehting wrong, try reading the directions.");
 +                    System.out.println("What is your first number? ");
                      fNum = ManageKeyboard();
                      isNum = isInteger(fNum);
                      reDo = true;
 @@ -64,15 +86,18 @@ public static void main(String[] args) throws java.io.IOException{
                  // get second number
                  reDo = false;
                  do {
 -                    if(reDo) String.out.println("You got somehting else wrong, try reading the directions.");
 -                    String.out.println("What is your second number: ");
 +                    if(reDo) System.out.println("You got somehting else wrong, try reading the directions.");
 +                    System.out.println("What is your second number? ");
                      sNum = ManageKeyboard();
                      isNum = isInteger(sNum);
                      reDo = true;
                  } while (isNum == false);
  
                  switch(rawanswer) {
                      case "1": domath.Add(fNum, sNum);
 +                    case "2": domath.Subtract(fNum, sNum);
 +                    case "3": domath.Multiplication(fNum, sNum);
 +                    case "4": domath.Division(fNum, sNum);
                  }
  
  
 @@ -89,7 +114,7 @@ public static void main(String[] args) throws java.io.IOException{
      static String ManageKeyboard(){
          // pulled out the functionality of the keyboard into one class
          Console cnsl = null;
 -        String answer = '';
 +        String answer = "";
          try{
              cnsl = System.console();
```
test
