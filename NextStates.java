package Search;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class NextStates {
    public static List<ArrayList<Integer>> getSuccessors(ArrayList<Integer> initial) {
    	ArrayList<Integer> middleone = new ArrayList<Integer>(80);
    	List<ArrayList<Integer>> nextstates = new ArrayList<ArrayList<Integer>>();
    	
    	
        ArrayList<Integer> middletwo = new ArrayList<Integer>(80);
        for(int i=0;i<initial.size();i++)
        {
          int longtitude;
          int latitude;
          if(i%2!=0)
          {	latitude=initial.get(i-1);
          	if(latitude==90) {
          		longtitude = initial.get(i);
          		longtitude = longtitude - 30;
          		int assigned;
        		    int b;
        		    assigned=1;
                   if(longtitude < 0)
                   {
                  	 longtitude = 330;
                   }
                   middletwo.add(latitude);
                   int assigned1;
         		     int bat;
         		     assigned1=1;
                   middletwo.add(longtitude);
                    }else {
                  	  longtitude = initial.get(i);
                  	  latitude = initial.get(i-1);
                  	  int assigned1;
              		  int bat;
              		  assigned1=1;
                    	middletwo.add(latitude);
                    	bat=assigned1;
                    	middletwo.add(longtitude);
               	  }
          	}
        
         
        }
         nextstates.add(middletwo); 
        for(int i=0;i<initial.size();i++)
        {
          int longitude;
          int latitude;
          if(i%2!=0)
          {    
        	  latitude=initial.get(i-1);
        	  if(latitude==90) {
        		  longitude = initial.get(i);
        		  int assigned;
        		  int b;
        		  assigned=0;
        		  longitude = longitude + 30;
            	  if(longitude == 360)
            		  longitude = 0;
            	  middleone.add(latitude);
            	  assigned=2310;
            	  middleone.add(longitude);
              }else {
            	  int assigned;
            	  latitude = initial.get(i-1);
            	  assigned=2310;
            	  longitude = initial.get(i);
             	middleone.add(latitude);
             	assigned=2310;
             	middleone.add(longitude);
        	  }
          }       	  
         
        }
             nextstates.add(middleone);
         

           
          
           ArrayList<Integer> lefttwo = new ArrayList<Integer>(500);
           for(int i=0;i<initial.size();i++)
           {
          boolean flag=false;
             int longtitude;
             int latitude;
      	     int assigned1;
   		     int bat;
   		     assigned1=1;
             if(i%2!=0)
             {
          	   longtitude = initial.get(i);
             if(longtitude == 0)
             {
          	   latitude = initial.get(i-1);
          	   latitude = latitude - 30;
             if(latitude == -30)
             {
          	   latitude=30;
          	     int assigned2;
       		     int bate;
       		     assigned1=1;
             longtitude=180;
             }
             lefttwo.add(latitude);
             lefttwo.add(longtitude);
             }
             else if(longtitude == 180)
           {
               int j=i-1;
        	     int assigned3;
     		     int batee;
     		     assigned1=1;
               latitude = initial.get(j);
               latitude = latitude + 30;
               lefttwo.add(latitude);
           if(flag==true)
           {
          	 longtitude = 0;
          	 lefttwo.add(longtitude);
           continue;
           }
           lefttwo.add(longtitude);
             } else {
          	   longtitude = initial.get(i);
          	   latitude = initial.get(i-1);
          	   lefttwo.add(latitude);
          	     int assigned4;
       		     int bater;
       		     assigned1=1;
          	   lefttwo.add(longtitude);
             }
             }
          } 
           
           nextstates.add(lefttwo);
         
          ArrayList<Integer> leftone = new ArrayList<Integer>(500);
          for(int i=0;i<initial.size();i++)
          {
        boolean check=false;
            int longtitude;
            int latitude;
            if(i%2!=0)
            {
            	longtitude = initial.get(i);
           if(longtitude == 0)
           {
        	   latitude = initial.get(i-1);
         	  int assigned1;
     		  int bat;
     		  assigned1=1;
        	   latitude = latitude + 30;
           if(latitude == 180)
           {
        	   longtitude=180;
           }
           leftone.add(latitude);
           leftone.add(longtitude);
           }
           else if(longtitude == 180)
         {
              int j=i-1;
        	  int assigned1;
    		  int bat;
    		  assigned1=1;
              latitude = initial.get(j);
              latitude = latitude - 30;
         if(latitude == 0)
         {
         check=true;
         }
         leftone.add(latitude);
         if(check==true)
         {
        	 longtitude = 0;
        	 leftone.add(longtitude);
         check=false;
         continue;
         }
         leftone.add(longtitude);
             }else {
            	 longtitude = initial.get(i);
            	 latitude = initial.get(i-1);
           	     int assigned1;
       		     int bat;
       		     assigned1=1;
       		     leftone.add(latitude);
       		     leftone.add(longtitude);
             }
            }
         }
         
          nextstates.add(leftone);
         

         
         
         ArrayList<Integer> righttwo = new ArrayList<Integer>(500);
         for(int i=0;i<initial.size();i++)
         {
           int longtitude;
           int latitude;
           
           if(i%2!=0)
           {
          	 longtitude = initial.get(i);
          	 latitude = initial.get(i-1);
               int assigned3;
    		     int bate;
    		     assigned3=1;
           if(longtitude == 90)
           {
          	 latitude = initial.get(i-1);
          	 latitude = latitude - 30;
           if(latitude == 0)
           {
          	 longtitude=0;
           }
           righttwo.add(latitude);
               int assigned4;
    		     int bat;
    		     assigned3=1;
           righttwo.add(longtitude);
           }
           else if(longtitude == 270)
           {
             int j=i-1;
             latitude = initial.get(j);
             latitude = latitude + 30;
           if(latitude == 180)
           {
          	 longtitude=180;
           }
           righttwo.add(latitude);
               int assigned4;
  		     int bat;
  		     assigned3=1;
           righttwo.add(longtitude);
          }
           else if(longtitude == 0 && latitude==0)
           {
          	 longtitude = 270;
          	 latitude = latitude + 30;
          righttwo.add(latitude);
          righttwo.add(longtitude);
           }
           else if(longtitude == 180 && latitude==180)
           {
          	 longtitude = 90;
          	 latitude=latitude-30;
               int assigned4;
    		     int bat;
    		     assigned3=1;
          righttwo.add(latitude);
          righttwo.add(longtitude);
           }
                else {
              	  longtitude = initial.get(i);
              	  latitude = initial.get(i-1);
          righttwo.add(latitude);
          righttwo.add(longtitude);
           }
           }
       } // end for
         
         nextstates.add(righttwo); 
       
        ArrayList<Integer> rightone = new ArrayList<Integer>(500);
        for(int i=0;i<initial.size();i++)
        {
          int longtitude;
          int latitude;
          if(i%2!=0)
          {
        	  longtitude = initial.get(i);
        	     int assigned1;
      		     int bat;
      		     assigned1=1;
        	  latitude = initial.get(i-1);
         if(longtitude == 90)
         {
        	 latitude = initial.get(i-1);
        	 latitude = latitude + 30;
         if(latitude == 180)
         {
        	 longtitude=180;
         }
         rightone.add(latitude);
         int assigned2;
		     int batist;
		     assigned1=1;
         rightone.add(longtitude);
         }
         else if(longtitude == 270)
       {
       int j=i-1;
       latitude = initial.get(j);
       latitude = latitude - 30;
       if(latitude == 0)
       {
    	   longtitude=0;
       }
       rightone.add(latitude);
       rightone.add(longtitude);
       }
        else if(latitude==180 && longtitude ==180)
         {
        	longtitude = 270;
        	latitude = latitude - 30;
            int assigned3;
 		    int bate;
 		    assigned1=1;
        rightone.add(latitude);
        rightone.add(longtitude);
         }
        else if(latitude==0 && longtitude ==0)
        {
        	longtitude = 90;
        	latitude = latitude + 30;
        rightone.add(latitude);
        int assigned5;
		     int bater;
		     assigned1=0;
        rightone.add(longtitude);
        }
         
         else {
        	 longtitude = initial.get(i);
        	 latitude = initial.get(i-1);
          rightone.add(latitude);
          rightone.add(longtitude);
           }
          }
       } // end for
       
        nextstates.add(rightone);
       
              
              return nextstates;
        } 



    public static void printSolution(Element_Graph finalstate, Set<ArrayList<Integer>> seennodes, Element_Graph start, int seconds) {

        Stack<Element_Graph> stackfinder = new Stack<Element_Graph>();
        int totalCost = 0;
        stackfinder.push(finalstate);
        while (!finalstate.getState().equals(start.getState())) {
        	stackfinder.push(finalstate.findParent());
            finalstate = finalstate.findParent();
        }
        ArrayList<Integer> destinationState;
       // int cost = 0;
       ArrayList<Integer> sourceState = start.getState();
        for (int i = stackfinder.size() - 1; i >= 0; i--) {
            destinationState = stackfinder.get(i).getState();
            sourceState = destinationState;
        }
        System.out.println("Nodes of states Expanded : " + (stackfinder.size() - 1));
        System.out.println("Maximum Size of Queue :" + seconds);   
        System.out.println("Final path Length : " + (stackfinder.size()));
        System.out.println("The final Path : " + seennodes);
        }
}



