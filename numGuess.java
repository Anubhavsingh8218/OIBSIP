
import java.util.Random;
import java.util.Scanner;

class numGuess{
    public static void main(String[] args) {
    try(Scanner sc = new Scanner(System.in)){
        Random  random = new Random();
        int guess, attempts = 0, min = 1, max = 100;
        
        int randomNumber = random.nextInt(min, max+1);
        System.out.println("NUMBER GUESSING GAME");
        System.out.printf("Enter the number between %d-%d\n",min,max);
    
        do { 
            System.out.print("Enter a guess: ");
            guess = sc.nextInt();
            attempts++;

            if(guess<randomNumber){
                System.out.println("Too Low! try again.");
            }
            else if(guess>randomNumber){
                System.out.println("Too High! try again.");
            }
            else{
                System.out.println("Correct! the number was "+randomNumber);
                System.out.println("Number of attempts: "+attempts);
            }
        } while (guess!=randomNumber);
    }
        
    }
}