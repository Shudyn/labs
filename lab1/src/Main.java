import java.io.IOException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int task= sc.nextInt();
    switch (task) {
      case 1:
          System.out.println("Enter number:");
          int number1 = sc.nextInt();
          int last_digit = number1 % 10;
          System.out.println("Last Number: " + last_digit); 
        break;

      case 2:
        System.out.println("Enter 3 digit number");

        int number2 = sc.nextInt();
  
        int third_digit = number2 % 10;
        number2 = number2 / 10;
        int second_digit = number2 % 10;
        number2 = number2 / 10;
        int first_digit = number2 % 10;
  
        System.out.println("Digit sum: " + (first_digit+second_digit+third_digit));
        break;

      case 3:
        int result3;
        System.out.println("Enter any number:");
        int number3 = sc.nextInt();
  
        if (number3 > 0) {
          result3 = number3 + 1;
        }
        else {
          result3 = number3;
        }
  
        System.out.println("Result: " + result3);
        break;
      case 4:
        int result4;
        System.out.println("Enter any number:");
        int number4 = sc.nextInt();
        if (number4 > 0) {
          result4 = number4 + 1;
        }
        else if (number4 < 0){
          result4 = number4 - 2;
        }
        else{
          result4 = 10;
        }
        System.out.println("Result: " + result4);
        break;
      case 5:
        System.out.println("Enter first number:"); 
        int number51 = sc.nextInt();
        System.out.println("Enter second number:"); 
        int number52 = sc.nextInt();
        System.out.println("Enter third number:"); 
        int number53 = sc.nextInt();
        
        if (number51 < number52)
          if (number51 < number53)
            System.out.println("Result: " + number51);
          else
            System.out.println("Result: " + number53);
        else
          if (number52 < number53)
            System.out.println("Result: " + number52);
          else
            System.out.println("Result: " + number53);
       break;
      case 6:
        String chetnost;
        String otricatelnost;
        System.out.println("Enter any number:"); 
        int number6 = sc.nextInt();
        if (number6 == 0) {
          System.out.println("Ноль"); 
          break;
        }
          
        if (number6 % 2 == 0){
          chetnost = "четное";
        }
          
        else {
          chetnost = "нечетное";
        }
          
        
        if (number6 > 0) {
          otricatelnost = " положительное";
        }
          
        else{
          otricatelnost = " отрицательное";
        }
          
        System.out.println(chetnost + otricatelnost + " число"); 
        break;
      case 7:
        System.out.println("Enter city code:"); 
        int number7 = sc.nextInt();
        switch(number7) {
          case 905:
            System.out.println(4.15*10);
            break;
          case 194:
            System.out.println(1.98*10); 
            break;
          case 491:
            System.out.println(2.69*10);
            break;
          case 800:
            System.out.println(5*10); 
            break;
          }
      case 8:
        int[] numbers8 = {1,-10,5,6,45,23,45,-34,0,32,56,-1,2,-2};
        int max8 = numbers8[0];
        int possum8 = 0;
        int negchetsum = 0;
        int poscount = 0;
        int midnegarif = 0;
        int midnegarifcount = 0;

        for (int i = 0; i < numbers8.length; i++){
          if (numbers8[i] > max8){
            max8 = numbers8[i];
          }
          if (numbers8[i] > 0){
            possum8 = possum8 + numbers8[i];
            poscount = poscount + 1;
          }
          else if (numbers8[i] < 0){
            if (numbers8[i] % 2 == 0){
              negchetsum = negchetsum + numbers8[i];
            }
            midnegarif = midnegarif + numbers8[i]; //divide later
            midnegarifcount = midnegarifcount + 1;
          }
        }
        midnegarif = midnegarif / midnegarifcount;
        System.out.println("Max:" + max8 + " Positive sum:" + possum8 + " negative chet sum:" + negchetsum);
        System.out.println("Positives count:" + poscount + " Negative average:" + midnegarif); 
        break;
      
      case 9:
        int[] numbers9 = {15,10,51, 6, 5,3, 10,-34,0,32,56, 12,24, 52};
        int[] reversenumbers9 = new int[numbers9.length];
        for (int i = numbers9.length-1; i > 0; i--){
          reversenumbers9[numbers9.length - i] = numbers9[i];
          System.out.print(reversenumbers9[numbers9.length - i] + " ");
        }
        reversenumbers9[numbers9.length-1] = numbers9[0];
        System.out.print(reversenumbers9[numbers9.length-1] + " ");
        break;
        
      case 10:
        int[] numbers10 = {15,10,51, 6, 5,3, 10,-34,0,32,56, 12,0, 52};
        int[] newnumbers10 = new int[numbers10.length];
        int zeroscount = 0;
        for (int i = 0; i < numbers10.length; i++){
          if (numbers10[i] != 0){
            newnumbers10[i-zeroscount] = numbers10[i];
            System.out.print(newnumbers10[i-zeroscount] + " ");
          }
          else {
            zeroscount = zeroscount + 1;
            System.out.print(zeroscount + " "); 
          }
        }
        for (int i = numbers10.length-zeroscount; i < numbers10.length; i++){
          newnumbers10[i] = 0;
          System.out.print(newnumbers10[i] + " ");
        }
        break;
      }
  }
}
