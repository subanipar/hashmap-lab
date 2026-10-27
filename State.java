public class State {

   String abbr;

   // add a string 'state name' variable, include in to string
   public State(String abb){
       abbr = abb;
   }
   @Override
   public int hashCode(){
       int hashCode = 0;
       int one = (int)(abbr.charAt(0)) - 65; // first char passed in (capital A is 41)
       int two = (int)(abbr.charAt(1)) - 65; // same with the second char


       hashCode = one*(26) + two*(1); // multiply one by the number of letters in the alphabet - a is in the 10s place
       return hashCode;
   }
   
   @Override
   public boolean equals(Object obj){
       State st = (State)obj;
       if(abbr.equals(st.getAbbr())){
           return true;
       }
       else{
           return false;
       }
   }


   public String getAbbr(){
       return abbr;
   }

   public String toString(){
    return abbr;
   }
}