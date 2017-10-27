/* Capitalist Adventure Capital.java
 Rich Jiang  
 rijiang
 Section 3 */ 

import java.util.*;
import java.io.*;
public class Capitalism//CL
{
  public int wealth;
  public int influence;
  public int power;
  public int intuition;
  public String name;
  public int tempw;
  public Capitalism(int w, int inf, int t, int p,String name){
    
    wealth = w;
    tempw = w;
    influence=inf;
    power = p;
    intuition = t;
    this.name = name;
  }
  public void write_stats(int intu, int inf, int pow,String file,int w) throws IOException{
    
    PrintWriter put = new PrintWriter(file+".txt");
    put.println("Wealth: " + w);
    put.println("Intuition: " + intu);
    put.println("Influence: " + inf);
    put.println("Power: " + pow);
    
    put.close();
    
  }
  
  public String toString(){
    
    
   String start = "A battle has been initiated!\nYour opponent is " + name+"!\nCheck your folder for the enemy's stats.";
   return start;
  }
  public int battle(Capitalism person, int inf, int intu, int pow, int w) throws IOException{//(MYMETH(O))
    Random gen = new Random();//(RANDOM)
    Scanner scan = new Scanner(System.in);
    int win = wealth;
    for (int q = 0;q<1;q++){
  System.out.println(toString());
  write_stats(person.getintu(),person.getinf(),person.getpow(),person.getname(),person.getw());
  scan.nextLine();
 
  while(wealth > 0 && w > 0){
   System.out.println("Select your move\n1.Self finance\n2.Sue\n3.Corporate Sabotage");
   int choice = scan.nextInt();
   if (choice == 1){
     System.out.println("You have chosen to use Self finance.");
     scan.nextLine();
    w+=(intu*6);
    System.out.println("Your curent wealth is now "+w);
    scan.nextLine();
   }
   else if (choice == 2){
     System.out.println("You have chosen to use Sue.");
     scan.nextLine();
    w+=(inf*3);
      person.sued(inf);
     System.out.println("Your oppenent's wealth is now "+ wealth+"\nYour wealth is now "+ w);
     scan.nextLine();
   }
   else if (choice == 3){
     System.out.println("You have chosen to use Corporate sabotage.");
     scan.nextLine();
     person.sab(pow);
      System.out.println("Your oppenent's wealth is now "+ wealth);
      scan.nextLine();
   }
   else{
   System.out.println("You have chosen to skip your turn.");
   scan.nextLine();
   }
   if(wealth <0){
   break;
   }
   int move = gen.nextInt(3);
   if (move == 0){
     System.out.println("Your oppenent has used self finance.");
     scan.nextLine();
     wealth+=(intuition*6);
     System.out.println("Your oppenent's current wealth is " + wealth);
   }
   else if (move ==1){
     System.out.println("Your oppenent has used sue.");
     scan.nextLine();
    wealth+= (influence*3);
    w-=(influence*3);
    System.out.println("Your oppenent's wealth is now "+ wealth+"\nYour wealth is now "+ w);
    scan.nextLine();
   }
   else{
     System.out.println("Your oppenent has used Corporate Sabotage.");
     scan.nextLine();
    w-=(power*3); 
    System.out.println("Your current wealth is now " + w);
    scan.nextLine();
   }
  }
  if (wealth <= 0){
   System.out.println("Congratulations you've won!");
   System.out.println("In your feat of victory you triumphantly shout: ");
   System.out.println(person.catch_phrase());
   return win;
  }
  else{
    System.out.println("It seem's you've lost, try again.");
    q--;
  }
  
}
    return 0;
  }
  
  public void move(String move_name1,String move_name2,String move_name3){
    /*String move1 = 
    String move2
    String move3
    */
  }
  public void move(String move_name1,String move_name2,String move_name,String n1,String n2, String n3){
    
  }
  //public void sort(){//Sort your doners
    
  //}
  public int getintu(){
    return intuition;}
  public int getinf(){
    return influence;}
  public int getpow(){
    return power;}
  public String getname(){
   return name;
  }
  public int gettempw(){
   return tempw; 
  }
  public int getw(){
   return wealth;
  }
  public void minusw(int p){
    wealth-=p;
  }
  public void sued(int infl){//Here the method takes away HP from the enemy by the player's "sue" skill
    wealth-=(infl*3);
  }
  public void sab(int p){
   wealth-=(p*6); 
  }
  public void add_patron(Capitalism patron)throws IOException{
    FileWriter file = new FileWriter("Patrons.txt",true);
    PrintWriter p = new PrintWriter(file);
    p.println(name+": " +wealth);
    p.close();
    file.close();
  }
  public String catch_phrase() throws IOException{
   File file = new File("Catch_Phrase.txt");
   Scanner scanf = new Scanner(file);
   String phrase = scanf.nextLine();
   return phrase;
  }
  //public int sort(){
    
       public static void sort_scores (Score[] scores)// (SORT) 
  {
    int min = 0;   //index of smallest element of sublist
    String temp; //for swapping
    Score tempd;
    for (int startIndex=0; startIndex < scores.length -1; startIndex++)
    {
      min=startIndex;
      
      for (int i=startIndex+1; i<scores.length; i++){
        if (scores[i].compareTo(scores[min]) < 0)
        min=i;
      }
      //swap the values
      tempd=scores[min];
      scores[min]=scores[startIndex];
      scores[startIndex]=tempd;
    }//end for startIndex  
    int x = 88;
    
  } // end sort
       public int search (Score target,Score[]scores){//(SEARCH)
      int x, i;
    x=-1;
    for(i = 0; i < scores.length;i++){
      if(target.compareTo(scores[i]) == 0){
        if(scores[i].getname().compareTo(target.getname()) == 0){
        x=i;
        break;
      }
      }
    }
        return x;        
  }
       }
