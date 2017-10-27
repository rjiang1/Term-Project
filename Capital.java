 /* Capitalist Adventure Capital.java
 Rich Jiang  
 rijiang
 Your section (2 or 3) */ 

import java.util.*;
import java.io.*;
public class Capital
{
  public static void main(String [] args) throws IOException {
  int choice1,choice2,choice3,choice4;
  int wealth = 115;
  int influence=0;
  int power=0;
  int intuition=0;
  int basestats = 12;
  Boolean godmode = false;
  String [] patronsn = new String[11];//name of each patron
  int [] patronsw = new int[11];//wealth of each patron
  
  Scanner scan = new Scanner(System.in);
  
  Capitalism self = new Capitalism(0,0,0,0,"Me"); 
  //AR
  Capitalism[] baddie = new Capitalism [11];//creates the array of objects for each enemy
    baddie[0] = new Capitalism(103,3,3,4,"Hobo");
    baddie[1] = new Capitalism(512,23,17,10,"Thug");
    baddie[2] = new Capitalism(2560,69,81,100,"Factory Worker");
    baddie[3] = new Capitalism(12800,3000,500,450,"Plummer");
  //Here add file opner and writer. Done
  
  //File inven = new File("Inventory.txt");

  //File skills= new File("Skills.txt");
  PrintWriter invenp = new PrintWriter("Inventory.txt");
  PrintWriter statsp = new PrintWriter("Stats.txt");
  PrintWriter patron = new PrintWriter("Patrons.txt");
  patron.println("Your List of Patrons");
  patron.close();
  //PrintWriter skillsp = new PrintWriter("Skills.txt");
  System.out.println("Welcome to Capitalist Adventure!");
  System.out.println("Please input a name for your character.");
  String name = scan.nextLine();
  File player = new File(name+".txt");
  //Scan the name here and check if the text file for the name already exist if so then say welcome back or somthing. Also that file can be used to reference past scores.
  //make an if statement here to show returning players welcome back.
  //scan a text file with all scores and then put it into an array. First scan the number of scores and then make a new array each time with the limit being the number of scores scanned.
  //names with the other and then sort parallel. 
  //after both arrays are made do a parallel sort and After parallel is sorted then post highscore list.
  if(player.exists()){
    System.out.println("Welcome back "+name);
  }
  else{
  PrintWriter newplayer = new PrintWriter(name+"_temp.txt");
  newplayer.close();
  System.out.println(name + ", be prepared for a journy of maximum profit!");
  System.out.println("Please read the introduction file called \"Introdduction\" before moving on.");
  scan.nextLine();
  }
  for(int i = 1; i<=1;i++){//Here we assign the starting stats for the player who's given 12 poins initally to assign.
    int choose1 = 0,choose2 = 0,choose3 = 0;//Interactive Input
   System.out.println("Please assign a value for influence.");
   choose1 = scan.nextInt();
   System.out.println("Please assign a value for intuition.");
   choose2 = scan.nextInt();
   System.out.println("Please assign a value for power.");
   choose3 = scan.nextInt();
   if((choose1+choose2+choose3)>basestats){
     System.out.println("You've assigned more points than you can. Try again.");
     i--;}//If the user underassigns his attribute points then these values will be submitted regardless.
   else
     influence = choose1;
   intuition = choose2;
   power = choose3;
  }
  
  System.out.println("Feel free to check your new stats in the Stats file.");
  //Make sure to print the stats to the stat file. After you complete the print method.
  statsp.println("Wealth: "+wealth);
  statsp.println("\nInfluence: " + influence);
  statsp.println("\nIntuition: " + intuition);
  statsp.println("\nPower: " + power);
    //skillsp.close();
  invenp.close();//move upwards?
  statsp.close();
  scan.nextLine();
  scan.nextLine();
  for(int i = 0; i<1;i++){//Start of first decision
    System.out.println("You've come across a hobo while roaming the streets of New York. What do you do?");
    System.out.println("1. Mug the hobo \n2. Give the hobo five dollars. \n3. Talk to the hobo.");
    choice1 = scan.nextInt();
    if (choice1 == 1){
      //Initiate battle sequence here
      System.out.println("For some reason you've decided to mug a hobo....");
      scan.nextLine();
      wealth+=baddie[0].battle(baddie[0],influence,intuition,power,wealth);
      wealth*=3;
      influence*=5;
      intuition*=5;
      power*=5;
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("You've defeated the hobo into submission! He is now added to your list of patrons.");
      patronsw[0] = baddie[0].gettempw();//Add your enemy to your list of patrons via text file
      patronsn[0]= baddie[0].getname();
      baddie[0].add_patron(baddie[0]);
      System.out.println("Feel free to see your new stats.");
      scan.nextLine();
  }
    else if (choice1 == 2){
      wealth-=5;
      System.out.println("The hobo see's your kindness from the money you gave him and decides to plege his undying loyalty to you in your quest.");
      scan.nextLine();
      influence+=5;
      influence*=5;
      power *=5;
      intuition*=5;
      wealth*=3;
      patronsw[0] = baddie[0].gettempw();//Adds your new supporter to your list of patrons via text file
      patronsn[0]= baddie[0].getname();
      baddie[0].add_patron(baddie[0]);
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("Feel free to check your new stats.");
      scan.nextLine();
  }
    else if (choice1 == 3){
    int gods;
    System.out.println("The hobo see's you and says \"What do you want?\" Your reply is ");//Add dilouge here.
    String god;
    scan.nextLine();
    god = scan.nextLine();
    gods = god.compareTo("GODME");
   
    if(gods == 0){
      godmode = true; 
   }
    else{
      System.out.println("Upon close inspection you can see the hobo has foam coming out from his mouth!\nPrepare to defend yourself!"); 
      scan.nextLine();
      wealth+=baddie[0].battle(baddie[0],influence,intuition,power,wealth);
      wealth*=3;
      influence*=5;
      intuition*=5;
      power*=5;
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("Feel free to check your new stats.");
      scan.nextLine();
      patronsw[0] = baddie[0].gettempw();//Adds your new supporter to your list of patrons via text file
      patronsn[0]= baddie[0].getname();
      baddie[0].add_patron(baddie[0]);
   }
   if(godmode){
     System.out.println("Cheat Code accepted.");
     power+= 10000;
     influence+=10000;
      intuition+=10000;
      wealth+= 2000000000;//change back to 100 when bugs are dealt with
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("Feel free to check your new stats.");
      
   }
  }
  else{
    System.out.println("INVALID CHOICE! Try again.");
  i--;
  }                      
           }//End of first choice
  
 scan.nextLine();
 System.out.println("After your encounter with the Hobo you proceed into a bar to relax and have a drink.\nHowever a shady fellow eyes you down while you're there.");
 System.out.println("After a little time has passes by he walks up to you, drunk. The drunk says \"I am Bob and I own these streets and I own these streets!\"");
 System.out.println("The thug goes on to insult you in a matter of ways and starts to threaten you!");
 scan.nextLine();
 choice2 = 0;
 for(int i = 0; i<1;i++){//Start of second decision
   System.out.println("Choose your action.");
   System.out.println("1. Teach him some manners(Fight). \n2. Attempt diplomacy. \n3. Roast him.");
   choice2 = scan.nextInt();
   if (choice2 == 1){
    //Initiate battle sequence here
    System.out.println("You decide to fight him.");
    scan.nextLine();
    wealth+=baddie[1].battle(baddie[1],influence,intuition,power,wealth);
    wealth*=3;
    influence*=5;
    intuition*=5;
    power*=5;
    System.out.println("Since you decided to fight the thug the bar owner is mad and demands reparations.");
    wealth-=25;
    scan.nextLine();
    self.write_stats(intuition, influence,power,"Stats",wealth);
    System.out.println("You've defeated the thug into submission! He is now added to your list of patrons.");
    patronsw[1] = baddie[1].gettempw();//Add your enemy to your list of patrons via text file
    patronsn[1]= baddie[1].getname();
    baddie[1].add_patron(baddie[1]);
    System.out.println("Feel free to see your new stats.");
    scan.nextLine();    
  }
   else if (choice2 == 2){
    System.out.println("You attempt diplomacy.");
    scan.nextLine();
    if(influence >=22){//number subject to change after trail runs are mande.
      System.out.println("You've attempted diplomacy and have succeeded in doing so! Thug is now your faithful patron.");
      scan.nextLine();
      influence+=25;
      influence*=5;
      power *=5;
      intuition*=5;
      wealth*=3;
      patronsw[1] = baddie[1].gettempw();//Adds your new supporter to your list of patrons via text file
      patronsn[1]= baddie[1].getname();
      baddie[1].add_patron(baddie[1]);
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("Feel free to check your new stats.");
      scan.nextLine();}
    else{
      choice2 = 3;
      System.out.println("You've attempted diplomacy and have failed.");
      wealth+=baddie[1].battle(baddie[1],influence,intuition,power,wealth);
      wealth*=3;
      influence*=5;
      intuition*=5;
      power*=5;
      System.out.println("Since you decided to fight the thug the bar owner is mad and demands reparations of $25.");
      wealth-=25;
      scan.nextLine();
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("You've defeated the thug into submission! He is now added to your list of patrons.");
      patronsw[1] = baddie[1].gettempw();//Add your enemy to your list of patrons via text file
      patronsn[1]= baddie[1].getname();
      baddie[1].add_patron(baddie[1]);
    }
      
  }
  else if (choice2 == 3){
    System.out.println("You decide to insult him back which in turn made the thug angry.");
    scan.nextLine();
    wealth+=baddie[1].battle(baddie[1],influence,intuition,power,wealth);
    wealth*=3;
    influence*=5;
    intuition*=5;
    power*=5;
    System.out.println("Since you decided to fight the thug the bar owner is mad and demands reparations of $25.");
    wealth-=25;
    scan.nextLine();
    self.write_stats(intuition, influence,power,"Stats",wealth);
    System.out.println("You've defeated the thug into submission! He is now added to your list of patrons.");
    patronsw[1] = baddie[1].gettempw();//Add your enemy to your list of patrons via text file
    patronsn[1]= baddie[1].getname();
    baddie[1].add_patron(baddie[1]);
    System.out.println("Feel free to see your new stats.");
    scan.nextLine();
    
  }
else{
    System.out.println("INVALID CHOICE! Try again.");
  i--;
  }
 }//End of second decision
 
 //Third decision or event
  System.out.println("After the incident at the bar you decide to head to the bus stop to catch a ride to a hotel.\nWhile you may have defeated a few enemies, you're still homeless.");
  System.out.println("As you get to the bus stop you see a person there. He seems to be in the clothes of a factory worker. You approach the bus stop...");
  scan.nextLine();
  if((choice2 == 1) || (choice2 == 3)){
    System.out.println("The worker looks at you analytically. Slowly his expression changes from neutral to an angry frown. ");
    System.out.println("The worker says \"Hey you beat up my buddy from the bar!\"\nHe charges at you.");
    wealth+=baddie[2].battle(baddie[2],influence,intuition,power,wealth);
    wealth*=3;
    influence*=5;
    intuition*=5;
    power*=5;
    scan.nextLine();
    self.write_stats(intuition, influence,power,"Stats",wealth);
    System.out.println("You've defeated the thug into submission! He is now added to your list of patrons.");
    patronsw[2] = baddie[2].gettempw();//Add your enemy to your list of patrons via text file
    patronsn[2]= baddie[2].getname();
    baddie[2].add_patron(baddie[2]);
    System.out.println("Feel free to see your new stats.");
    scan.nextLine(); 
  }
     else{
 for(int i = 0; i<1;i++){//Start of third decision
   System.out.println("Choose your action.");
   System.out.println("1. Manipulate him. \n2. Conspire him into fighting your boss. \n3. Ask about the factory life.");
   choice3 = scan.nextInt();
   if (choice3 == 1){
    System.out.println("You decide to talk to him. Slowly and slowly you're able to bring him to your side as you talk about your horrible boss.");
    System.out.println("The woker himself mentions also has a horrible boss. Throught your the mutal feeling of disdain of higher authority, you've recruited the worker.");
    scan.nextLine();
    influence+= 125;
    influence*=5;
    power *=5;
    intuition*=5;
    wealth*=3;
    patronsw[2] = baddie[2].gettempw();//Adds your new supporter to your list of patrons via text file
    patronsn[2]= baddie[2].getname();
    baddie[2].add_patron(baddie[2]);
    self.write_stats(intuition, influence,power,"Stats",wealth);
    System.out.println("Feel free to check your new stats.");
    scan.nextLine();
   }
   else if (choice3 == 2){
    System.out.println("You decide to conspire with the worker against your boss.");
    power+= 125;
    influence*=5;
    power *=5;
    intuition*=5;
    wealth*=3;
    patronsw[2] = baddie[2].gettempw();//Adds your new supporter to your list of patrons via text file
    patronsn[2]= baddie[2].getname();
    baddie[2].add_patron(baddie[2]);
    self.write_stats(intuition, influence,power,"Stats",wealth);
    System.out.println("Feel free to check your new stats.");
    scan.nextLine(); 
  }
  else if (choice2 == 3){
    System.out.println("You ask about the worker's life");
    //burst into years out of your consideration.
    intuition+= 125;
    influence*=5;
    power *=5;
    intuition*=5;
    wealth*=3;
    patronsw[2] = baddie[2].gettempw();//Adds your new supporter to your list of patrons via text file
    patronsn[2]= baddie[2].getname();
    baddie[2].add_patron(baddie[2]);
    self.write_stats(intuition, influence,power,"Stats",wealth);
    System.out.println("Feel free to check your new stats.");
    scan.nextLine(); 
  }
else{
    System.out.println("INVALID CHOICE! Try again.");
  i--;
  }
 }//End of third decision
     }

 
     //Add narrative here
     /*
     scan.nextLine();
 for(int i = 0; i<1;i++){//Start of fourth decision
   System.out.println("Choose your action.");
   System.out.println("1. Teach him some manners(Fight). \n2. Attempt diplomacy. \n3. Roast him.");
   choice2 = scan.nextInt();
   if (choice4 == 1){
    //Initiate battle sequence here
    System.out.println("You decide to fight him.");
    scan.nextLine();
    wealth+=baddie[1].battle(baddie[1],influence,intuition,power,wealth);
    wealth*=3;
    influence*=5;
    intuition*=5;
    power*=5;
    System.out.println("Since you decided to fight the thug the bar owner is mad and demands reparations.");
    wealth-=25;
    scan.nextLine();
    self.write_stats(intuition, influence,power,"Stats",wealth);
    System.out.println("You've defeated the thug into submission! He is now added to your list of patrons.");
    patronsw[1] = baddie[1].gettempw();//Add your enemy to your list of patrons via text file
    patronsn[1]= baddie[1].getname();
    baddie[1].add_patron(baddie[1]);
    System.out.println("Feel free to see your new stats.");
    scan.nextLine();    
  }
   else if (choice4 == 2){
    System.out.println("You attempt diplomacy.");
    scan.nextLine();
    if(influence >=22){//number subject to change after trail runs are mande.
      System.out.println("You've attempted diplomacy and have succeeded in doing so! Thug is now your faithful patron.");
      scan.nextLine();
      influence+=25;
      influence*=5;
      power *=5;
      intuition*=5;
      wealth*=3;
      patronsw[1] = baddie[1].gettempw();//Adds your new supporter to your list of patrons via text file
      patronsn[1]= baddie[1].getname();
      baddie[1].add_patron(baddie[1]);
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("Feel free to check your new stats.");
      scan.nextLine();}
    else{
      System.out.println("You've attempted diplomacy and have failed.");
      wealth+=baddie[1].battle(baddie[1],influence,intuition,power,wealth);
      wealth*=3;
      influence*=5;
      intuition*=5;
      power*=5;
      System.out.println("Since you decided to fight the thug the bar owner is mad and demands reparations.");
      wealth-=25;
      scan.nextLine();
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("You've defeated the thug into submission! He is now added to your list of patrons.");
      patronsw[1] = baddie[1].gettempw();//Add your enemy to your list of patrons via text file
      patronsn[1]= baddie[1].getname();
      baddie[1].add_patron(baddie[1]);
    }
      
  }
  else if (choice4 == 3){
    System.out.println("You decide to insult him back which in turn made the thug angry.");
    scan.nextLine();
    wealth+=baddie[1].battle(baddie[1],influence,intuition,power,wealth);
    wealth*=3;
    influence*=5;
    intuition*=5;
    power*=5;
    System.out.println("Since you decided to fight the thug the bar owner is mad and demands reparations.");
    wealth-=25;
    scan.nextLine();
    self.write_stats(intuition, influence,power,"Stats",wealth);
    System.out.println("You've defeated the thug into submission! He is now added to your list of patrons.");
    patronsw[1] = baddie[1].gettempw();//Add your enemy to your list of patrons via text file
    patronsn[1]= baddie[1].getname();
    baddie[1].add_patron(baddie[1]);
    System.out.println("Feel free to see your new stats.");
    scan.nextLine();
    
  }
else{
    System.out.println("INVALID CHOICE! Try again.");
  i--;
  }
 }//End of second decision
 */
 //Convert final stats and add them to wealth
 //End to story loops. The details are in proposal file.
 //convert wealth to a double here
 double wd = (double)wealth;
//import the old score from file if it exists (call it old_score)
 
//double score = wealth/1000000000.00
 File hs = new File("High_Scores.txt");
 double score = wd/1000000000.00;
 int entries=0;
 if(player.exists()){
   Scanner scanf = new Scanner(player);
  // String sss = scanf.nextLine();
   if(scanf.nextLine().compareTo("**")==0){
     System.out.println("return recognized.");
    scanf.next();
    double old_score = scanf.nextDouble();
    scanf.close();
    PrintWriter finalwrite = new PrintWriter(player);
    score += old_score;
    finalwrite.println("**");
    finalwrite.println(name);
    finalwrite.println(score+" Billion");
    finalwrite.close();
   }
   else{
     PrintWriter finalwrite = new PrintWriter(player);
     finalwrite.println("**");
     finalwrite.println(name);
     finalwrite.println(score+" Billion");
     finalwrite.close();
     FileWriter fileq = new FileWriter("High_Scores.txt",true);
     PrintWriter pq = new PrintWriter(fileq);
     pq.println("\nUnsorted) "+name+" "+score + " Billion");
     pq.close();
     fileq.close();
     finalwrite.close();
   }
  }
    else{
     PrintWriter finalwrite = new PrintWriter(player);
     finalwrite.println("**");
     finalwrite.println(name);
     finalwrite.println(score+" Billion");
     finalwrite.close();
     FileWriter fileq = new FileWriter("High_Scores.txt",true);
     PrintWriter pq = new PrintWriter(fileq);
     pq.println("\nUnsorted) "+name+" "+score + " Billion");
     pq.close();
     fileq.close();
     finalwrite.close();
    }
    
    Scanner scanh = new Scanner(hs);

    scanh.nextLine();
    while(scanh.hasNext()){
     scanh.next();
     String s = scanh.next();
     scanh.nextDouble();
     scanh.next();
     //if(s != name){
      entries++;//if s == name then entries is skipped
     //}
    }
    //Add player here to list
    scanh.close();
    scanh = new Scanner(hs);
    double[] highscores = new double[entries];
    String[] allnames = new String[entries];
    scanh.nextLine();
    int i = 0;//new combined scores for returning players is not being registered.
    while(scanh.hasNext()){//consider knocking off the last player and then resorting.
      scanh.next();
      String next = scanh.next();
      if(name.compareTo(next) == 0){
       allnames[i] = name;
       highscores[i] = score;
       scanh.nextDouble();
      }
      else{
      allnames[i] = next;
      highscores[i] = scanh.nextDouble();
      }
      scanh.next();
      i++;
    }
    scanh.close();
    
      
    self.sort_scores(allnames,highscores);//(SORT)
    //self.so3rt_scores(allnames,highscores);
    //left off at above
    PrintWriter new_score_list = new PrintWriter("High_Scores.txt");
    int z = 1;
    new_score_list.println("High Scores");
    for(int y = entries-1; y>=0;y--){
      new_score_list.println(z+") "+ allnames[y]  + " " + highscores[y]+ " Billion"); 
        z++;   
    }
    new_score_list.close();
    int stand = self.search(allnames,highscores,score,name);//(SEARCH)
    if(stand == -1){
      System.out.println("Standing not found.");
    }
    else
    System.out.println("Your current standing in score is " + (entries-stand));
    
//double new_score=score+old_score;
//Record the final score here and store it in a text file. Replace the old score with new through printwriter if needed. 
//FileWriter file = new FileWriter("Patrons.txt",true);
//PrintWriter p = new PrintWriter(file);
//p.println(name+": " +wealth);
//p.close();
//file.close();
//Make an array scanning the old high score list for names and scores, store in two arrays with the new one. So like scan, array max=# of scores in high score plus one(the new one), sort then write the new highscore list with print writer.
//Do an if statement check if it's a returning player and if so then the array does not need a new max.
    
    
//Search method can be a feature where a player can look up another player's score so the player can compare him or herself.
    //look at lab 18 for search.
  }
}