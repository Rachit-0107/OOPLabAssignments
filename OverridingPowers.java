//Pilani has a very famous pizzeria called "Pizzeria" (yes, that's the name!). Since, BITSians frequent this place a lot, Pizzeria has come up with a membership card plan for BITSians.
//
//There are two types of cards: Silver and Gold. Each card can be initiated with some starting credits based on the amount payed while initiating the card (details in the code template).
//
//Buying a pizza from Pizzeria costs some amount of credits on the card registered for the customer. For the Silver card, the card can only be used if the remaining credits in the card are more than or equal to the credits about to be spent on the current transaction. Otherwise an error message is shown.
//
//The gold card however has some benefits (it is only given to students scoring an A grade in the OOP course :D). First, you get to have an additional number of free credits when initiating a Gold card. Moreover, you have an option to top-up the card when the need arises (details in the code template).
//
//Input Format
//
//For each testcase, you will be given a card type and the initiation amount  (in Rupees) in the first line. After this, you need to do some operations on the card. The next line contains an integer , the number of operations on the card.
//
//The next  lines contain the operations on the card.
//
//If the first integer in the line is 1, then call the print method on the respective card object to print the details about the card.
//
//If the first integer in the line is 2, then another integer  follows in this line. This indicates that you need to do a transaction involving  credits on the card. Use the deduct method on the respective card to achieve this.
//
//Constraints
//
// <=  <=   <=  <=   <=  <= 
//
//Output Format
//
//The output lines corresponding to each operation should begin on a new line. More details about the output for each operation can be found by looking at the code template and the example test cases. 




import java.io.*;
import java.util.*;
import java.util.Scanner; 

class Card{
	String name = "John Doe";	// card holder's name
  
  	int credits = 0;
   	
  	static void welcome(){
     	System.out.println("Hi, Card management in process...");	 
    }
  
  	void print(){
     	System.out.println("This card belongs to " + name);
    }
}

class SilverCard extends Card{
	SilverCard(int amountPaid){
     	/*  Implement the constructor to add additional credits for the card based on the 
        	amount paid.
        	Rs. 1000 - 1999 -> 5 additional credits
        	Rs. 2000 - 3999 -> 10 additional credits
        	Rs. 4000 - 9999 -> 15 additional credits
        	More than Rs. 10000 -> 20 additional credits
         */
        if(amountPaid>999 && amountPaid<2000)
        {
            this.credits+=5; 
        }
        else if(amountPaid>1999 && amountPaid<4000)
        {
            this.credits+=10; 
        } 
        else if(amountPaid>3999 && amountPaid<10000)
        {
            this.credits+=15; 
        }
        else
        {
            this.credits+=20; 
        }
    }
  
    /*
    	Create an overriden method for toString() to print the credits left in the card 
        along with the card holder's name.
    */ 
    void print(){
         System.out.println("Credits left in the card: " + this.credits);
         System.out.println("This card belongs to " + name);
    }
    
  
  	void deduct(int creditsSpent){
      	/*  
        	Instructions:
            
            1. If the number of credits spent is less than or equal to the number of credits left, 
            	then proceed with the transaction and do the appropriate updations.
            2. Else, print an error message saying "Insufficient balance".
        */ 
        if(creditsSpent <= this.credits)
        {
            this.credits-= creditsSpent; 
        } 
        else
        {
            System.out.println("Insufficient balance"); 
        }
    }
}

class GoldCard extends SilverCard{
    final int FREE_CREDITS = 10;
    
    GoldCard(int amountPaid){
    	/*
        	Implement this constructor using the parent constructor with the additional free 
      		Also use the free credits to increase your initial credits.
        */
        super(amountPaid);  
        this.credits+=10; 
    }
   
  	/*
    	Implement a PRIVATE top-up method to add some credits to the account by paying Rs. 500
        for each top-up. Each top-up adds 5 credits to the card. Also show the number of credits 		 remaining in the card after the top-up.
    */ 
        
    private void topup(){
        credits+=5; 
    }

    void deduct(int creditsSpent){ 
        if(creditsSpent <= credits)
        {
            this.credits-= creditsSpent; 
        } 
        else
        { 
            topup(); 
            System.out.println("Credits left in the card: " + credits);
            this.deduct(creditsSpent); 
            
        }
    }
  	
  	/* 
    	Override the deduct method to decuct credits according to the following logic:
    
       1. If the number of credits spent is less than or equal to the number of credits left,
       	  then proceed with the transaction and do the appropriate updations.
       2. Else, top-up the the credits in the account using the top-up method implemented above.
    */


    
}

public class OverridingPowers {

    public static void main(String[] args){ 
        Scanner in = new Scanner(System.in); 
        String card_type = in.next(); 
        int a = in.nextInt(); 
        int no_of_queries = in.nextInt(); 
        int i; 
        
        if (card_type.equals("Silver"))
        {
            SilverCard card = new SilverCard(a); 
            for(int k = 0; k<no_of_queries; k++)
            {
                i = in.nextInt(); 
              if(i == 1)
             {
                card.print(); 
             }
              else if(i == 2)
             {
                int add;  
                add = in.nextInt(); 
                card.deduct(add); 
             }
         }
        }
        else if(card_type.equals("Gold"))
        {
            GoldCard card = new GoldCard(a);
            for(int k = 0; k<no_of_queries; k++)
            {
                i = in.nextInt();
            if(i == 1)
             {
                card.print(); 
             }
            else if(i == 2)
             {
                int add = in.nextInt(); 
                card.deduct(add); 
             }
            }
        }
        else
        {
            ; 
        } 
        
    }
}
