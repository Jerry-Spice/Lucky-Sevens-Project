/**
 *  A class that models the game of Lucky Sevens. 
 *  
 *  @author: Your Name
 *  @AP Computer Science A, Virtual Virginia
 */
import java.lang.Math;

public class LuckySevens
{
    //lvl 1 requirements 
    private int balance;
    private int numOfTurns;
    
    //lvl 2 requirements
    private int maxBalance;
    private int maxBalTurn;
    private int sumSeven;
    
    private int snakeEyes;
    private int aceDuce;
    private int four;
    private int five;
    private int six;
    private int eight;
    private int nine;
    private int ten;
    private int yo;
    private int boxcars;
    
    public LuckySevens(int userBalance) {
        //balance init
        if (userBalance < 0) {
            balance = 0;
        } else {
            balance = userBalance;
        }
        //turns init
        numOfTurns = 0;
        //other inits
        maxBalance = balance;
        maxBalTurn = 0;
        sumSeven = 0;
        //lvl 3 inits
        snakeEyes = 0;
        aceDuce = 0;
        four = 0;
        five = 0;
        six = 0;
        eight = 0;
        nine = 0;
        ten = 0;
        yo = 0;
        boxcars = 0;
    }
    
    public int rollDie() {
        //random - range [0,1) * 6 -> range [0,6) +1 range [0,7) -> range [0,6]
        return (int)((Math.random() * 6) +1);
    }
    
    public void playTurn() {
        numOfTurns ++; // add a turn
        int d1 = rollDie();
        int d2 = rollDie();
        int sum = d1+d2;
        //lvl 2
        if (sum >= maxBalance) {
            maxBalance = sum;
            maxBalTurn = numOfTurns;
        }
        //lvl 1
        if (sum == 7) {
            balance += 4; // if 7 is rolled add 4
            //lvl 2
            sumSeven++;
        } else {
            balance--; // otherwise lose a dollar
        }
        //lvl 3 conditionals
        switch (sum) {
            case 2:
                snakeEyes++;
                break;
            case 3:
                aceDuce++;
                break;
            case 4:
                four++;
                break;
            case 5:
                five++;
                break;
            case 6:
                six++;
                break;
            case 8:
                eight++;
                break;
            case 9:
                nine++;
                break;
            case 10:
                ten++;
                break;
            case 11:
                yo++;
                break;
            case 12:
                boxcars++;
                break;
        }
    }
    
    public void playGame() {
        while (balance > 0) {
            playTurn();
        }
        //get gmae report and log it to console
        System.out.println(getGameReport());
    }
    
    public String getGameReport() {
        String msg = "";
        double percent = ((double)sumSeven/(double)numOfTurns)*100.0;
        // debug message | System.out.println((double)sumSeven/(double)numOfTurns);
        //total rounds
        msg+= String.format("The player lasted %d rounds. ", numOfTurns);
        
        //sevenSum
        msg+= String.format("Seven appeared %d", (int)percent);
        msg+= "% of the time.\n";
        
        //maxmoney + max money turn
        msg += String.format("On turn #%d ", (int)maxBalTurn);
        msg += String.format("you had a max balance of $%d!\n", (int)maxBalance);
        
        //lvl 3 mesages
        msg+= "--------Rolling Stats--------\n";
        msg+= String.format("Snake Eyes (2) | %d\n", getSnakeEyes());
        msg+= String.format("Ace Duce (3)   | %d\n", getAceDuce());
        msg+= String.format("Four           | %d\n", getFour());
        msg+= String.format("Five           | %d\n", getFive());
        msg+= String.format("Six            | %d\n", getSix());
        msg+= String.format("Eight          | %d\n", getEight());
        msg+= String.format("Nine           | %d\n", getNine());
        msg+= String.format("Ten            | %d\n", getTen());
        msg+= String.format("Yo (11)        | %d\n", getYo());
        msg+= String.format("Boxcars (12)   | %d\n", getBoxcars());
        msg+= "-----------------------------";
        return msg;
    }
    
    public int getNumOfTurns() {
        return numOfTurns;
    }
    
    public int getBalance() {
        return balance;
    }
    //lvl 2
    public int getMaxBalance() {
        return maxBalance;
    }
    public int getMaxBalTurn() {
        return maxBalTurn;
    }
    public int getSumSeven() {
        return sumSeven;
    }
    
    //lvl 3
    public int getSnakeEyes() {return snakeEyes;}
    public int getAceDuce() {return aceDuce;}
    public int getFour() {return four;}
    public int getFive() {return five;}
    public int getSix() {return six;}
    public int getEight() {return eight;}
    public int getNine() {return nine;}
    public int getTen() {return ten;}
    public int getYo() {return yo;}
    public int getBoxcars() {return boxcars;}
    
}
