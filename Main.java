import java.util.*;
public class Main {
    public static void main(String[] args) {
        int lower = 1;
        int upper =100;
        Random randomData =new Random();
        int  target = randomData.nextInt(lower,upper+1);
        System.out.printf("Guess a number between %d and %d :",lower,upper);
        Scanner userInput =new Scanner(System.in);
        int guess;
        int counter = 0;
        do{
            guess= userInput.nextInt();
            counter++;
            if(guess > target)
            {
                System.out.println("Guess lower !");

            } else if (guess < target) {
                System.out.println("guess higher !");
            }
        }while(guess!=target);
        System.out.println("correct! It took you " +counter + " tries");
    }
}