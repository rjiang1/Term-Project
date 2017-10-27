 /* Capitalist Adventure Capital.java
 Rich Jiang  
 rijiang
 Section 3 */ 

import java.util.*;
import java.io.*;
public class Capitalb4obj
{
  public static void main(String [] args) throws IOException {
  int choice1,choice2,choice3,choice4,choice5,choice6,choice7,choice8,choice9,choice10,choice11;
  int quiza,quizb;
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
    baddie[3] = new Capitalism(12800,300,500,450,"Plummer");
    baddie[4] = new Capitalism(64000,2000,2000,2250,"Teacher");
    baddie[5] = new Capitalism(320000,10416,10416,10419,"Real Estate Worker");
    baddie[6] = new Capitalism(1600000,52083,52083,52086,"Corporate Lawyer");
    baddie[7] = new Capitalism(8000000,260416,260416,260419,"Hedge Fund Manager");
    baddie[8] = new Capitalism(40000000,1302083,1302083,1302086,"Oil Tycoon");
    baddie[9] = new Capitalism(200000000,6510416,6510416,6510419,"Vice President");
    baddie[10] = new Capitalism(1000000000,19999998,19999999,20000000,"Big Boss");
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
      godmode = true; //(BOOL)
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
     power+= 100;
     influence+=100;
     intuition+=100;
     wealth+= 100
       ;//change back to 100 when bugs are dealt with
     self.write_stats(intuition, influence,power,"Stats",wealth);
     System.out.println("Feel free to check your new stats.");
     patronsw[0] = baddie[0].gettempw();//Adds your new supporter to your list of patrons via text file
     patronsn[0]= baddie[0].getname();
     baddie[0].add_patron(baddie[0]);
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
 scan.nextLine();
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
    scan.nextLine();
  }
  else if (choice3 == 3){
    System.out.println("You ask about the worker's life because you sense something wrong with him.\nAfter a long talk you realize this worker hates his boss as much as youd do.");
    System.out.println("The two of you decide to team up to get revenge against your bosses.");
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
 }
     }//End of third decision
     
     System.out.println("After taking the bus to the hotel you decide to check into your room for the night.\nAfter checking in and walking to your room, you felt the urge to use the restroom.\nHowever by first glance you notice that");
     System.out.print("the toilet was broken. You then decide to contact hotel staff for a plummer.");
     System.out.println("\nWhen the plummer arrives he seems annoyed that he has to fix your toilet so late in the night. What do you do?");
     scan.nextLine();
     
 for(int i = 0; i<1;i++){//Start of fourth decision
   System.out.println("Choose your action.");
   System.out.println("1. Enlighten him about the holy lord. \n2. Offer him a refreshment. \n3. Have a political conversation.");
   choice4 = scan.nextInt();
   if (choice4 == 1){
    //Initiate battle sequence here
    System.out.println("You decide to preach about the holy lord. However that infuriated him as the plummer reveals to be a devout satanist.");
    scan.nextLine();
    wealth+=baddie[3].battle(baddie[3],influence,intuition,power,wealth);
    wealth*=3;
    influence*=5;
    intuition*=5;
    power*=5;
    self.write_stats(intuition, influence,power,"Stats",wealth);
    System.out.println("You've defeated the plummer into submission! He is now added to your list of patrons.");
    patronsw[3] = baddie[3].gettempw();//Add your enemy to your list of patrons via text file
    patronsn[3]= baddie[3].getname();
    baddie[3].add_patron(baddie[3]);
    System.out.println("Feel free to see your new stats.");
    scan.nextLine();    
  }
   else if (choice4 == 2){
    System.out.println("You attempt diplomacy.");
    scan.nextLine();
      System.out.println("You decide to offer the plummer a drink to have him ease up. The plummer notices your generosity and thanks you for it.");
      System.out.println("It turns out the plummer had a really bad week. With this in mind you decide to recruit him on yor quest against your boss.");
      scan.nextLine();
      influence+=625;
      influence*=5;
      power *=5;
      intuition*=5;
      wealth*=3;
      patronsw[3] = baddie[3].gettempw();//Adds your new supporter to your list of patrons via text file
      patronsn[3]= baddie[3].getname();
      baddie[3].add_patron(baddie[3]);
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("Feel free to check your new stats.");
      scan.nextLine();
    }    
  else if (choice4 == 3){
    System.out.println("You decide to get political all of a sudden. After talking a little about politics with the plummer it turns out that the plummer is a communist. Get ready for an argument.");
    scan.nextLine();
    wealth+=baddie[3].battle(baddie[3],influence,intuition,power,wealth);
    wealth*=3;
    influence*=5;
    intuition*=5;
    power*=5;
    self.write_stats(intuition, influence,power,"Stats",wealth);
    System.out.println("You've defeated the plummer into submission! He is now added to your list of patrons.");
    patronsw[3] = baddie[3].gettempw();//Add your enemy to your list of patrons via text file
    patronsn[3]= baddie[3].getname();
    baddie[3].add_patron(baddie[3]);
    System.out.println("Feel free to see your new stats.");
    scan.nextLine(); 
  }
else{
    System.out.println("INVALID CHOICE! Try again.");
  i--;
  }
 }//End of fourth decision
 
 scan.nextLine();
 System.out.println("After your occurence with the plummer you decide to go to sleep.\nThe next morning while in a coffie shop you notice what seems to be a middle school teacher waiting in line for coffie as well.");
 System.out.println("However as you go to get your coffie, you spill your coffie on the teacher. What do you do?");
 for(int i = 0; i<1;i++){//Start of fifth decision
   System.out.println("Choose your action.");
   System.out.println("1. Charm. \n2. Attempt diplomacy. \n3. Berate.");
   choice5 = scan.nextInt();
   if (choice5 == 1){
   if(influence >=2750){//number subject to change after trail runs are mande.
      System.out.println("You've attempted to charm the teacher and have succeeded in doing so! Teacher is now your faithful patron and more.");
      scan.nextLine();
      influence+=2750;
      influence*=5;
      power *=5;
      intuition*=5;
      wealth*=3;
      patronsw[4] = baddie[4].gettempw();//Adds your new supporter to your list of patrons via text file
      patronsn[4]= baddie[4].getname();
      baddie[4].add_patron(baddie[4]);
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("Feel free to check your new stats.");
      scan.nextLine();}
    else{
      System.out.println("Your charm attempt has failed.");
      wealth+=baddie[4].battle(baddie[4],influence,intuition,power,wealth);
      wealth*=3;
      influence*=5;
      intuition*=5;
      power*=5;
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("You've defeated the teacher into submission! He is now added to your list of patrons.");
      patronsw[4] = baddie[4].gettempw();//Add your enemy to your list of patrons via text file
      patronsn[4]= baddie[4].getname();
      baddie[4].add_patron(baddie[4]);
    }
  }
   else if (choice5 == 2){
    System.out.println("The teacher shouts at you \"I will give you one chance for me to not start beating the living breath out of you!\".");
    System.out.println("The teacher asks \"Which came first the chicken or the egg?\"\n1.The chicken\n2.The egg\n3.*Punch the teacher in the face*");
    scan.nextLine();
    quiza = scan.nextInt();
    if(quiza == 1){
      for(int u = 0; u<1;u++){
     System.out.println("The teacher asks \"Why did it come first?\"\n1. Evolution\n2. K'thulu\n3*Gives philisophical answer*");
     quizb = scan.nextInt();
     if(quizb == 1){
      System.out.println("The teacher looks at you and says \"Wow congradulations people are usually confused and confused when I randomly quiz them.\".");
      System.out.println("Impressed with your knowledge the teacher decided to be your patron.");
      wealth+=baddie[4].getw();
      wealth*=3;
      influence*=5;
      intuition*=5;
      power*=5;
      self.write_stats(intuition, influence,power,"Stats",wealth);
      patronsw[4] = baddie[4].gettempw();//Add your enemy to your list of patrons via text file
      patronsn[4]= baddie[4].getname();
      baddie[4].add_patron(baddie[4]);
     }
     else if(quizb == 2){
       System.out.println("The teacher shouts \"INCORRECT!\".");
       wealth+=baddie[4].battle(baddie[4],influence,intuition,power,wealth);
       wealth*=3;
       influence*=5;
       intuition*=5;
       power*=5;
       self.write_stats(intuition, influence,power,"Stats",wealth);
       System.out.println("You've defeated the teacher into submission! He is now added to your list of patrons.");
       patronsw[4] = baddie[4].gettempw();//Add your enemy to your list of patrons via text file
       patronsn[4]= baddie[4].getname();
       baddie[4].add_patron(baddie[4]); 
     }
     else if(quizb == 3){
       if(intuition >= 2750){
      System.out.println("The teacher looks at you somewhat confused and says \"Well you're not wrong.\"");
      System.out.println("After hearing you answer the teacher takes time to reflect on the answer you gave. After careful thought the teacher decides to follow you as a student to learn of a higher meaning to your answer.");
      intuition+=2800;
      wealth+=baddie[4].getw();
      influence*=5;
      power *=5;
      intuition*=5;
      wealth*=3;
      patronsw[4] = baddie[4].gettempw();//Adds your new supporter to your list of patrons via text file
      patronsn[4]= baddie[4].getname();
      baddie[4].add_patron(baddie[4]);
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("Feel free to check your new stats.");
      scan.nextLine();}
       }
       else{
         System.out.println("INVALID CHOICE! Try again.");
         u--;
        }//else for quiz choice
    }//end of for u loop
       }//end of quiza choice 1
    else if(quiza == 2){
      System.out.println("The teacher shouts \"INCORRECT!\".");
      wealth+=baddie[4].battle(baddie[4],influence,intuition,power,wealth);
       wealth*=3;
       influence*=5;
       intuition*=5;
       power*=5;
       self.write_stats(intuition, influence,power,"Stats",wealth);
       System.out.println("You've defeated the teacher into submission! He is now added to your list of patrons.");
       patronsw[4] = baddie[4].gettempw();//Add your enemy to your list of patrons via text file
       patronsn[4]= baddie[4].getname();
       baddie[4].add_patron(baddie[4]); 
    }//end of quiza choice 2
    else if (quiza == 3){
      System.out.println("You decide to punch the teacher causing " + power + " damage to the teacher.");
      baddie[4].minusw(power);
       wealth+=baddie[4].battle(baddie[4],influence,intuition,power,wealth);
       wealth*=3;
       influence*=5;
       intuition*=5;
       power*=5;
       self.write_stats(intuition, influence,power,"Stats",wealth);
       System.out.println("You've defeated the teacher into submission! He is now added to your list of patrons.");
       patronsw[4] = baddie[4].gettempw();//Add your enemy to your list of patrons via text file
       patronsn[4]= baddie[4].getname();
       baddie[4].add_patron(baddie[4]); 
    }//end of quiza choice 3
     }//End of choice5 == 2;
  else if (choice5 == 3){
    System.out.println("You decide to insult the teacher which in turn made the teacher angry.");
    scan.nextLine();
    wealth+=baddie[4].battle(baddie[4],influence,intuition,power,wealth);
    wealth*=3;
    influence*=5;
    intuition*=5;
    power*=5;
    self.write_stats(intuition, influence,power,"Stats",wealth);
    System.out.println("You've defeated the teacher into submission! He is now added to your list of patrons.");
    patronsw[4] = baddie[4].gettempw();//Add your enemy to your list of patrons via text file
    patronsn[4]= baddie[4].getname();
    baddie[4].add_patron(baddie[4]);
    System.out.println("Feel free to see your new stats.");
    scan.nextLine(); 
  }//end of choice5
else{
    System.out.println("INVALID CHOICE! Try again.");
  i--;
  }
 }//End of fifth decision
 scan.nextLine();
 System.out.println("After the incident with the teacher you decide to get a house and stop being homeless. So you head off to see a real-estate dealer.");
    System.out.println("As you meet with the real estate dealer you find that the house will cost $300,000.");
 scan.nextLine();
 for(int i = 0; i<1;i++){//Start of sixth decision
   System.out.println("Choose your action.");
   System.out.println("1. Buy the home. \n2. Negotiate the price. \n3. Demand the house deed.");
   choice6 = scan.nextInt();
   if (choice6 == 1){
    //Initiate battle sequence here
     wealth-=300000;
    System.out.println("You decide to buy the house.");
    scan.nextLine();
    wealth+=baddie[5].getw();
    wealth*=3;
    influence*=5;
    intuition*=5;
    power*=5;
    scan.nextLine();
    self.write_stats(intuition, influence,power,"Stats",wealth);
    System.out.println("Real estate agent is now added to your list of patrons.");
    patronsw[5] = baddie[5].gettempw();//Add your enemy to your list of patrons via text file
    patronsn[5]= baddie[5].getname();
    baddie[5].add_patron(baddie[5]);
    System.out.println("Feel free to see your new stats.");
    scan.nextLine();    
  }
   else if (choice6 == 2){
    System.out.println("You try to negotiate.");
    scan.nextLine();
    if(influence >=13750){//number subject to change after trail runs are mande.
      System.out.println("You've attempted to negotiate and have succeeded in doing so! The agent is now your faithful patron.");
      scan.nextLine();
      influence+=13825;
      influence*=5;
      power *=5;
      intuition*=5;
      wealth*=3;
      patronsw[5] = baddie[5].gettempw();//Adds your new supporter to your list of patrons via text file
      patronsn[5]= baddie[5].getname();
      baddie[5].add_patron(baddie[5]);
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("Feel free to check your new stats.");
      scan.nextLine();}
    else{
      System.out.println("You've attempted to negotiate and have failed in doing so.");
      wealth+=baddie[5].battle(baddie[5],influence,intuition,power,wealth);
      wealth*=3;
      influence*=5;
      intuition*=5;
      power*=5;
      scan.nextLine();
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("You've defeated the real estate agent into submission! He is now added to your list of patrons.");
      patronsw[5] = baddie[5].gettempw();//Add your enemy to your list of patrons via text file
      patronsn[5]= baddie[5].getname();
      baddie[5].add_patron(baddie[5]);
    }   
  }
  else if (choice6 == 3){
    System.out.println("You try to demand the deed to the house!");
    scan.nextLine();
    if(power >=13750){//number subject to change after trail runs are mande.
      System.out.println("You've attempted to demand the deed and have succeeded in doing so! The agent is also now your faithful patron.");
      scan.nextLine();
      power+=13825;
      influence*=5;
      power *=5;
      intuition*=5;
      wealth*=3;
      patronsw[5] = baddie[5].gettempw();//Adds your new supporter to your list of patrons via text file
      patronsn[5]= baddie[5].getname();
      baddie[5].add_patron(baddie[5]);
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("Feel free to check your new stats.");
      scan.nextLine();}
    else{
      System.out.println("You've attempted to demand the deed and have failed in doing so.");
      wealth+=baddie[5].battle(baddie[5],influence,intuition,power,wealth);
      wealth*=3;
      influence*=5;
      intuition*=5;
      power*=5;
      scan.nextLine();
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("You've defeated the real estate agent into submission! He is now added to your list of patrons.");
      patronsw[5] = baddie[5].gettempw();//Add your enemy to your list of patrons via text file
      patronsn[5]= baddie[5].getname();
      baddie[5].add_patron(baddie[5]);
    }
  }
else{
    System.out.println("INVALID CHOICE! Try again.");
  i--;
  }
 }//End of sixth decision
  System.out.println("After the incident with the agent you decide to finally initiate your plan to get revenge against your boss.");
    System.out.println("You know in your mind that you need a lawyer to do so therefore you head to find one.\nYou finally end up finding one and you're meeting that person now and the lawyer tells you his sevice will cost 1 million dollars.");
 scan.nextLine();
 for(int i = 0; i<1;i++){//Start of seventh decision
   System.out.println("Choose your action.");
   System.out.println("1. Hire the lawyer. \n2. Negotiate an asymetrical investment oppertunity. \n3. Screw lawyers!");
   choice7 = scan.nextInt();
   if (choice7 == 1){
    //Initiate battle sequence here
     wealth-=1000000;
     System.out.println("You decide to hire the lawyer and his whole firm!");
     scan.nextLine();
    wealth+=baddie[6].getw();
    wealth*=3;
    influence*=5;
    intuition*=5;
    power*=5;
    scan.nextLine();
    self.write_stats(intuition, influence,power,"Stats",wealth);
    System.out.println("Real estate agent is now added to your list of patrons.");
    patronsw[6] = baddie[6].gettempw();//Add your enemy to your list of patrons via text file
    patronsn[6]= baddie[6].getname();
    baddie[6].add_patron(baddie[6]);
    System.out.println("Feel free to see your new stats.");
    scan.nextLine();    
  }
   else if (choice7 == 2){
    System.out.println("You try to negotiate.");
    scan.nextLine();
    if(influence >=68750){//number subject to change after trail runs are mande.
      System.out.println("Your deal has intrigued the lawyer! The lawyer is now your faithful patron.");
      scan.nextLine();
      influence+=70000;
      influence*=5;
      power *=5;
      intuition*=5;
      wealth*=3;
      patronsw[6] = baddie[6].gettempw();//Adds your new supporter to your list of patrons via text file
      patronsn[6]= baddie[6].getname();
      baddie[6].add_patron(baddie[6]);
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("Feel free to check your new stats.");
      scan.nextLine();}
    else{
      System.out.println("You've attempted to negotiate and have failed in doing so.");
      wealth+=baddie[6].battle(baddie[6],influence,intuition,power,wealth);
      wealth*=3;
      influence*=5;
      intuition*=5;
      power*=5;
      scan.nextLine();
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("You've defeated the real lawyer into submission! He is now added to your list of patrons.");
      patronsw[6] = baddie[6].gettempw();//Add your enemy to your list of patrons via text file
      patronsn[6]= baddie[6].getname();
      baddie[6].add_patron(baddie[6]);
    }
  }
  else if (choice7 == 3){
    System.out.println("Due to your burning hate for lawyers, you decide to punch the lawyer!");
    scan.nextLine();
      wealth+=baddie[6].battle(baddie[6],influence,intuition,power,wealth);
      wealth*=3;
      influence*=5;
      intuition*=5;
      power*=5;
      scan.nextLine();
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("You've defeated the lawyer into submission! He is now added to your list of patrons.");
      patronsw[6] = baddie[6].gettempw();//Add your enemy to your list of patrons via text file
      patronsn[6]= baddie[6].getname();
      baddie[6].add_patron(baddie[6]);
    }

else{
    System.out.println("INVALID CHOICE! Try again.");
  i--;
  }
 }//End of seventh decision
 
 //add narrative about entrepenure here
 System.out.println("After your encounter with the lawyer you head off to find capital backing to defeat your boss. In doing so you decide to find rising high rollers to help you.\nOne particular person seems to be the head of a multi million dollar hedgefund.");
 System.out.println("You decide to meet with this person because you know the manager is rutheless in his business and what better way to fight your firey boss with some fire of your own.");
 System.out.println("You meet with the manager and the manager says to you \"What do you want?\"");
 scan.nextLine();
 for(int i = 0; i<1;i++){//Start of eigth decision
   System.out.println("Choose your action.");
   System.out.println("1. Buy out the company. \n2. Negotiate an asymetrical investment oppertunity. \n3. Corporate raid!");
   choice8 = scan.nextInt();
   if (choice8 == 1){
    //Initiate battle sequence here
     wealth-=1000000; //1mil buy out
     System.out.println("You decide to buy out the hedgefund's stocks. You know own more than %50 of the company");//left off here-12/4/16 @4:56am
     scan.nextLine();
    wealth+=baddie[7].getw();
    wealth*=3;
    influence*=5;
    intuition*=5;
    power*=5;
    scan.nextLine();
    self.write_stats(intuition, influence,power,"Stats",wealth);
    System.out.println("The hedge fund manager is now added to your list of patrons.");
    patronsw[7] = baddie[7].gettempw();//Add your enemy to your list of patrons via text file
    patronsn[7]= baddie[7].getname();
    baddie[7].add_patron(baddie[7]);
    System.out.println("Feel free to see your new stats.");
    scan.nextLine();    
  }
   else if (choice8 == 2){
    System.out.println("You try to negotiate a deal.");
    scan.nextLine();
    if(influence >=343750){//number subject to change after trail runs are mande.
      System.out.println("Your deal has intrigued the manager! The manager is now your faithful patron.");
      scan.nextLine();
      influence+=270000;
      influence*=5;
      power *=5;
      intuition*=5;
      wealth*=3;
      patronsw[7] = baddie[7].gettempw();//Adds your new supporter to your list of patrons via text file
      patronsn[7]= baddie[7].getname();
      baddie[7].add_patron(baddie[7]);
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("Feel free to check your new stats.");
      scan.nextLine();}
    else{
      System.out.println("You've attempted to negotiate and have failed in doing so.");
      wealth+=baddie[7].battle(baddie[7],influence,intuition,power,wealth);
      wealth*=3;
      influence*=5;
      intuition*=5;
      power*=5;
      scan.nextLine();
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("You've defeated the hedge fund manager into submission! He is now added to your list of patrons.");
      patronsw[7] = baddie[7].gettempw();//Add your enemy to your list of patrons via text file
      patronsn[7]= baddie[7].getname();
      baddie[7].add_patron(baddie[7]);
    }
  }
  else if (choice8 == 3){
    System.out.println("Due to your burning hate for this guy in particular, you decide to punch the manager!");
    scan.nextLine();
      wealth+=baddie[7].battle(baddie[7],influence,intuition,power,wealth);
      wealth*=3;
      influence*=5;
      intuition*=5;
      power*=5;
      scan.nextLine();
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("You've defeated the manager into submission! He is now added to your list of patrons.");
      patronsw[7] = baddie[7].gettempw();//Add your enemy to your list of patrons via text file
      patronsn[7]= baddie[7].getname();
      baddie[7].add_patron(baddie[7]);
    }

else{
    System.out.println("INVALID CHOICE! Try again.");
  i--;
  }
 }//End of eigth decision
 
   System.out.println("After the incident with the manager you now finally have some backing needed to get revenge agianst your boss. The last thing you need is some more capital backing. So you head to an oil tycoon for the final piece.");
   System.out.println("As you meet the tycoon you're greeted by him with his pet tiger. He tries assuring you it's friendly, but for at least a good seven minutes the tiger has done nothing, but stare at you aggresively.");
   scan.nextLine();
 for(int i = 0; i<1;i++){//Start of 9th decision
   System.out.println("Choose your action.");
   System.out.println("1. Hire the oil tycoon. \n2. Negotiate a deal for future ventures. \n3. Screw this tiger!");
   choice9 = scan.nextInt();
   if (choice9 == 1){
    //Initiate battle sequence here
     wealth-=5000000; //5mil buy out?
     System.out.println("You decide to buy out the oil company.");//left off here-12/4/16 @4:56am
     scan.nextLine();
    wealth+=baddie[8].getw();
    wealth*=3;
    influence*=8;
    intuition*=5;
    power*=5;
    scan.nextLine();
    self.write_stats(intuition, influence,power,"Stats",wealth);
    System.out.println("The oil tycoon is now added to your list of patrons.");
    patronsw[8] = baddie[8].gettempw();//Add your enemy to your list of patrons via text file
    patronsn[8]= baddie[8].getname();
    baddie[8].add_patron(baddie[8]);
    System.out.println("Feel free to see your new stats.");
    scan.nextLine();    
  }
   else if (choice9 == 2){
    System.out.println("You try to negotiate.");
    scan.nextLine();
    if(influence >=1718750){//number subject to change after trail runs are mande.
      System.out.println("Your deal has intrigued the tycoon! The tycoon is now your faithful patron.");
      scan.nextLine();
      influence+=1000000;
      influence*=5;
      power *=5;
      intuition*=5;
      wealth*=3;
      patronsw[8] = baddie[8].gettempw();//Adds your new supporter to your list of patrons via text file
      patronsn[8]= baddie[8].getname();
      baddie[8].add_patron(baddie[8]);
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("Feel free to check your new stats.");
      scan.nextLine();}
    else{
      System.out.println("You've attempted to negotiate and have failed in doing so.");
      wealth+=baddie[8].battle(baddie[8],influence,intuition,power,wealth);
      wealth*=3;
      influence*=5;
      intuition*=5;
      power*=5;
      scan.nextLine();
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("You've defeated the tycoon into submission! He is now added to your list of patrons.");
      patronsw[8] = baddie[8].gettempw();//Add your enemy to your list of patrons via text file
      patronsn[8]= baddie[8].getname();
      baddie[8].add_patron(baddie[8]);
    }
  }
  else if (choice9 == 3){
    System.out.println("You decide to fight the tiger! Of course it's a tiger so you end up getting slashed. Also the oil tycoon is angry you punched his tiger.");
    scan.nextLine();
    System.out.println("Your starting health for this battle is now "+(wealth-500000)+ " from getting slashed by the tiger.");
      wealth+=baddie[8].battle(baddie[8],influence,intuition,power,wealth-500000);
      wealth*=3;
      influence*=5;
      intuition*=5;
      power*=10;
      scan.nextLine();
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("You've defeated the tycoon and the tiger into submission! He is now added to your list of patrons and you feel a surge of power after acheiving your feat.");
      patronsw[8] = baddie[8].gettempw();//Add your enemy to your list of patrons via text file
      patronsn[8]= baddie[8].getname();
      baddie[8].add_patron(baddie[8]);
    }

else{
    System.out.println("INVALID CHOICE! Try again.");
  i--;
  }
 }//End of 9th decision
 
System.out.println("After meeting with the oil tycoon you're finally ready to storm the building where your old boss is at. With the help of your patrons\nyou were able to deal with the smaller fish of the company. However one person stands");
System.out.println("in the way of you and your boss....the Vice President. \"So it's come down the this, " + name + ". Is there any way I can change your mind so we can stop this madness!\"");
   scan.nextLine();
 for(int i = 0; i<1;i++){//Start of 10th decision
   System.out.println("Choose your action.");
   System.out.println("1. Bribe the Vice president. \n2. Persuade him to your side. \n3. \"Out of my way you can't stop me!\" you shout.");
   choice10 = scan.nextInt();
   if (choice10 == 1){
     System.out.println("You decide to bribe the VP, but how much do you offer? Enter your amount below.");
     int bribe = scan.nextInt();
     if(bribe>=25000000){
       wealth-=bribe;
       System.out.println("The VP looks at you with a smirk and says \"Well money talks.\"");
    wealth+=baddie[9].getw();
    wealth*=3;
    influence*=8;
    intuition*=10;
    power*=5;
    scan.nextLine();
    self.write_stats(intuition, influence,power,"Stats",wealth);
    System.out.println("The oil tycoon is now added to your list of patrons.");
    patronsw[9] = baddie[9].gettempw();//Add your enemy to your list of patrons via text file
    patronsn[9]= baddie[9].getname();
    baddie[9].add_patron(baddie[9]);
    System.out.println("Feel free to see your new stats.");
    scan.nextLine();
     }
     else if(bribe>=10000000){
      wealth-=bribe;
      System.out.println("The VP says to you \"Sorry that won't be enough to win me over, but I'll tell you what I won't get in your way.\" that being said the VP walks off and you're left with the giant double door that leads to your boss.");
      System.out.println("On a unrelated note you happened to find "+ baddie[9].getw() +" dollars on the ground.");
      scan.nextLine();
      wealth+=baddie[9].getw();
      wealth*=4;
      influence*=5;
      intuition*=5;
      power*=5;
      scan.nextLine();
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("The oil tycoon is now added to your list of patrons.");
      patronsw[9] = baddie[9].gettempw();//Add your enemy to your list of patrons via text file
      patronsn[9]= baddie[9].getname();
      baddie[9].add_patron(baddie[9]);
      System.out.println("Feel free to see your new stats.");
      scan.nextLine();
     }
     else{
      System.out.println("The VP looks at you with a scowl and says \"What do you take me for!\"");
      scan.nextLine();
      wealth+=baddie[9].battle(baddie[9],influence,intuition,power,wealth);
      wealth*=3;
      influence*=5;
      intuition*=5;
      power*=7;
      scan.nextLine();
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("You've defeated the VP into submission! He is now added to your list of patrons.");
      patronsw[9] = baddie[9].gettempw();//Add your enemy to your list of patrons via text file
      patronsn[9]= baddie[9].getname();
      baddie[9].add_patron(baddie[9]);
     }
  }
   else if (choice10 == 2){
    System.out.println("You try to negotiate.");
    scan.nextLine();
    if(influence >=8593750){//number subject to change after trail runs are mande.
      System.out.println("You've sucessfully persuaded the VP to join your side! The VP is now your faithful patron.");
      scan.nextLine();
      influence+=5000000;
      influence*=7;
      power *=5;
      intuition*=5;
      wealth*=3;
      patronsw[9] = baddie[9].gettempw();//Adds your new supporter to your list of patrons via text file
      patronsn[9]= baddie[9].getname();
      baddie[9].add_patron(baddie[9]);
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("Feel free to check your new stats.");
      scan.nextLine();}
    else{
      System.out.println("You've attempted to negotiate and have failed in doing so.");
      wealth+=baddie[9].battle(baddie[9],influence,intuition,power,wealth);
      wealth*=3;
      influence*=5;
      intuition*=5;
      power*=5;
      scan.nextLine();
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("You've defeated the VP into submission! He is now added to your list of patrons.");
      patronsw[9] = baddie[9].gettempw();//Add your enemy to your list of patrons via text file
      patronsn[9]= baddie[9].getname();
      baddie[9].add_patron(baddie[9]);
    }
  }
  else if (choice10 == 3){
    System.out.println("The VP decides to resist!");
    scan.nextLine();
      wealth+=baddie[9].battle(baddie[9],influence,intuition,power,wealth);
      wealth*=3;
      influence*=5;
      intuition*=5;
      power*=7;
      scan.nextLine();
      self.write_stats(intuition, influence,power,"Stats",wealth);
      System.out.println("You've defeated the tycoon and the VP into submission! He is now added to your list of patrons.");
      patronsw[9] = baddie[9].gettempw();//Add your enemy to your list of patrons via text file
      patronsn[9]= baddie[9].getname();
      baddie[9].add_patron(baddie[9]);
    }

else{
    System.out.println("INVALID CHOICE! Try again.");
  i--;
  }
 }//End of 10th decision
 
 //Start of final boss

 for(int i = 0; i<1;i++){//Start of 10th decision
 System.out.println("As you open the big doors you see your old boss sitting there staring at you. You shout \"It's over!\", but you're returned with a malicious stare as he says \"Oh it's only just the beggining!\" What do you do?");
 System.out.println("1. Call the tycoon to help you\n2. Call lawyer to help you\n3. Call the thug to help you\n4. Call the teacher to help you.");
 choice11 = scan.nextInt();
   if (choice11 == 1){
     System.out.println("The tycoon brings you an extra $100,000,000 for your immenent battle");
     wealth+=100000000;
     wealth+=baddie[10].battle(baddie[10],influence,intuition,power,wealth);
     }
   else if (choice11 == 2){
     System.out.println("You call the lawyer to help you. Your sue ability is now enhanced.");
  influence+=10000000;
  wealth+=baddie[10].battle(baddie[10],influence,intuition,power,wealth);
  }
  else if (choice11 == 3){
 System.out.println("You call the thug to help you. You feel powered up.");
 power+=10000000;
 wealth+=baddie[10].battle(baddie[10],influence,intuition,power,wealth);
    }
  else if (choice11 == 4){
   System.out.println("You call the tacher to help you. Your sue ability is now enhanced.");
   intuition+=10000000;
   wealth+=baddie[10].battle(baddie[10],influence,intuition,power,wealth);
  }
else{
    System.out.println("INVALID CHOICE! Try again.");
  i--;
  }
 }
 System.out.println("As you defeat your boss you say \"I guess it's finally over\". However in the wake of your defeated boss he says with his final breath \"Idiot! Do you think I'm the only crappy boss? There are many more like me in alternate universes!");
 System.out.println(" and I'm willing to bet my afterlife you can't stop them all. However if you want to want to walk the path of the pure capitalist that's your choice. Theres a portal to other universes behind the books shelf. I hope the alternate versions of myself pummel you!\"");
 System.out.println("that being said your old boss now lies motionless after succuming to financial bankruptcy. You enter the portal.");
 scan.nextLine();
 scan.nextLine();
 System.out.println("Thanks for playing Journey for the Fat Stacks! I hope you've enjoyed the game and look forward to your future play throughs. Please proceed to your score calculation. An important note is that the more you play,");
 System.out.println("the more your score increases.");
 scan.nextLine();
 //Convert final stats and add them to wealth
 //End to story loops. The details are in proposal file.
 //convert wealth to a double here
 double wd = (double)wealth;
//import the old score from file if it exists (call it old_score)
 
//double score = wealth/1000000000.00
 File hs = new File("High_Scores.txt");
 double scorez = wd/1000000000.00;
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
    scorez += old_score;
    finalwrite.println("**");
    finalwrite.println(name);
    finalwrite.println(scorez+" Billion");
    finalwrite.close();
   }
   else{
     PrintWriter finalwrite = new PrintWriter(player);
     finalwrite.println("**");
     finalwrite.println(name);
     finalwrite.println(scorez+" Billion");
     finalwrite.close();
     FileWriter fileq = new FileWriter("High_Scores.txt",true);
     PrintWriter pq = new PrintWriter(fileq);
     pq.println("\nUnsorted) "+name+" "+scorez + " Billion");
     pq.close();
     fileq.close();
     finalwrite.close();
   }
  }
    else{
     PrintWriter finalwrite = new PrintWriter(player);
     finalwrite.println("**");
     finalwrite.println(name);
     finalwrite.println(scorez+" Billion");
     finalwrite.close();
     FileWriter fileq = new FileWriter("High_Scores.txt",true);
     PrintWriter pq = new PrintWriter(fileq);
     pq.println("\nUnsorted) "+name+" "+scorez + " Billion");
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
    Score[] score = new Score[entries];
    Score me = new Score(name,scorez);
    //double[] highscores = new double[entries];
    //String[] allnames = new String[entries];
    scanh.nextLine();
    int i = 0;//new combined scores for returning players is not being registered.
    while(scanh.hasNext()){//consider knocking off the last player and then resorting.
      scanh.next();
      String next = scanh.next();
      if(name.compareTo(next) == 0){
       score[i] = new Score(name,scorez);
       //highscores[i] = scorez;
       scanh.nextDouble();
      }
      else{
      //allnames[i] = next;
      //highscores[i] = scanh.nextDouble();
      double scr = scanh.nextDouble();
      score[i] = new Score(next,scr);
      }
      scanh.next();
      i++;
    }
    scanh.close();
    
    
    self.sort_scores(score);//(SORT)
    //self.so3rt_scores(allnames,highscores);
    //left off at above
    PrintWriter new_score_list = new PrintWriter("High_Scores.txt");
    int z = 1;
    new_score_list.println("High Scores");
    for(int y = entries-1; y>=0;y--){
      new_score_list.println(z+") "+ score[y].getname()  + " " + score[y].getscore() + " Billion"); 
        z++;   
    }
    new_score_list.close();
    int stand = self.search(me,score);//(SEARCH)
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