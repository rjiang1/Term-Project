/* Capitalist Adventure Capital.java
 Rich Jiang  
 rijiang
 Section 3 */ 

import java.util.*;
import java.io.*;
public class Score
{
  String name;
  double score;
  //name of person and their score
  //make a compare to method
  //watch the equals and compareTo power point on Black board
public Score (String n,double s){
 name = n;
 score = s;
}

public double compareTo(Score q){
 double z = score-q.getscore();
   return z;
}
public String getname(){
 return name; 
}
public double getscore(){
 return score; 
}
}	