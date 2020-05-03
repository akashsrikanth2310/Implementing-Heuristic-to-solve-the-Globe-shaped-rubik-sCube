package Search;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Begin {
	


	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	
    	ArrayList<Integer> endingstate=new ArrayList<Integer>();
           	
    	String ALG =  args[0];
    	String file = args[1];
    	
    	 File filereader = new File(file); 
    	 BufferedReader brreader = new BufferedReader(new FileReader(filereader));
    	 //File filereader = new File("C:\\Users\\Vidhya\\Documents\\coursework\\Artficial Intelligence\\homwork\\PathN-1.mb"); 

         int lcount=0;
     	 ArrayList<Integer> lister1 = new ArrayList<Integer>(500); 
         int amount;
         
         ArrayList<Integer> startingstate=new ArrayList<Integer>();
         @SuppressWarnings("resource")
		
         String stringer; 
         
         while ((stringer = brreader.readLine()) != null) {
         	 if(stringer.matches(".*\\bMarble\\b.*")) {
         		 lcount++;
    			  continue;
    		  } else {
         Pattern patern = Pattern.compile("\\d+");
         amount=0;
         Matcher matcherr = patern.matcher(stringer);
        ArrayList<Integer> lister = new ArrayList<Integer>(500); 
         while(matcherr.find()) {
         	if(lcount==1||lcount==2) {
         		if(amount==0) {
         			
         			
         			startingstate.add(Integer.valueOf(matcherr.group()));
         			
         			
         		}else if (amount==1) {
         			
         			
         			startingstate.add(Integer.valueOf(matcherr.group()));
         			
         			
         		}else if (amount==2) {
         			
         			
         			 endingstate.add(Integer.valueOf(matcherr.group()));
         			 
         			 
         		}else if (amount==3) {
         			
         			
         			 endingstate.add(Integer.valueOf(matcherr.group()));
         			 
         			 
         			 
         		}
         	}else {
         		 	
             	if(amount==2) {
             		
             		
             		
                 	startingstate.add(Integer.valueOf(matcherr.group()));
                 	
                 	
                 } else if (amount==3) {
                	 
                	 
                 	startingstate.add(Integer.valueOf(matcherr.group()));
                 	
                 	
                 }else if (amount==4) {
                	 
                	 
                 	  endingstate.add(Integer.valueOf(matcherr.group()));	
                 	  
                 	  
                 }else if(amount==5) {
                	 
                	 
                 	  endingstate.add(Integer.valueOf(matcherr.group()));
                 	  
                 	  
                 }
         	}    	
             amount++;
         	}
    		}
         lcount++;
         }
         
        Logic finder = new Logic(new Element_Graph(startingstate), endingstate);
        
        if(ALG.equals("BFS"))
        finder.BFS();
        else if(ALG.equals("RBFS"))
        finder.RBFS();
        else if(ALG.equals("AStar"))
        finder.AStar(Heuristic.START);
    }
}
