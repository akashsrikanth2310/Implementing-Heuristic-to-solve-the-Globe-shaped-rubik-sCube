package Search;
import java.util.*;


public class Logic {
	 private ArrayList<Integer> finalState;
     private Element_Graph start;
   
    public Element_Graph getRoot() {
        return start;
    }

    public ArrayList<Integer> getGoalSate() {
        return finalState;
    }

    public void setRoot(Element_Graph root) {
        this.start = root;
    }

    public Logic(Element_Graph begin, ArrayList<Integer> finalState) {
        this.start = begin;
        this.finalState = finalState;
    }

    public void setGoalSate(ArrayList<Integer> finalState) {
        this.finalState = finalState;
    }


	  public void RBFS() {
		    Set<ArrayList<Integer>> findones = new HashSet<ArrayList<Integer>>();
	        Element_Graph creations = new Element_Graph(start.getState());
	        int seconds = 0;
	        creations.setCost(0);

	        ComparerClass comparer = new ComparerClass();
            int n=0; 
	        PriorityQueue<Element_Graph> givingq = new PriorityQueue<Element_Graph>(30, comparer);
	        n=n+10;
	        Element_Graph positionNode = creations;
	        while (!positionNode.getState().equals(finalState)) {
	        	findones.add(positionNode.getState());
	        	n=n+10;
	            List<ArrayList<Integer>> nextsuccessors = NextStates.getSuccessors(positionNode.getState());
	            for (ArrayList<Integer> next : nextsuccessors) {
	                if (findones.contains(next))
	                    continue;
	                findones.add(next);
	                Element_Graph kid = new Element_Graph(next);
	                positionNode.addChild(kid);
	                n=n+10;
	                kid.setParent(positionNode);
	                kid.setTotalCost(0, huerisitcfirst(kid.getState(), finalState));
	                n=n+10;
	                givingq.add(kid);

	            }
	            positionNode = givingq.poll();
	            n=n+10;
	            seconds += 1;
	        }
	       
	        NextStates.printSolution(positionNode, findones, start, seconds);

	    }
	  
		public void BFS() {
	        Set<ArrayList<Integer>> findones = new HashSet<ArrayList<Integer>>();
	        int begin = 0;
	        Queue<Element_Graph> q = new LinkedList<Element_Graph>();
	        Element_Graph linked = new Element_Graph(start.getState());
	        Element_Graph positionNode = linked;
	        while (!positionNode.getState().equals(finalState)) {
	            List<ArrayList<Integer>> nextstateorsuccessors = NextStates.getSuccessors(positionNode.getState());
	            int n=1;
	            findones.add(positionNode.getState());
	            n++;
	            for (ArrayList<Integer> successors : nextstateorsuccessors) {
	                if (findones.contains(successors))
	                    continue;
	                findones.add(successors);
	                Element_Graph kid = new Element_Graph(successors);
	                q.add(kid); 
	                n++;
	                positionNode.addChild(kid);
	                n++;
	                kid.setParent(positionNode);
	              }
	            
	            findones.remove(positionNode.getState());
	            int m=0;
	            positionNode = q.poll();
	            m++;
	            begin += 1;
	        }

	        NextStates.printSolution(positionNode, findones, start, begin);

	    }
	  
	    private int huerisitcfirst(ArrayList<Integer> startstatee, ArrayList<Integer> endstate) {
	        int changes = 0;
	        for (int i = 0; i < startstatee.size(); i=i+2)
	            if (startstatee.get(i)!=endstate.get(i) || startstatee.get(i+1)!= endstate.get(i+1))
	            	changes += 1;
	        return changes;
	    }

	    public void AStar(Heuristic finder) {
	       
	    	Set<ArrayList<Integer>> findones = new HashSet<ArrayList<Integer>>();
	    	int totalCost=0;
	        int time = 0;
	        Element_Graph creations = new Element_Graph(start.getState());
	        creations.setTotalCost(0);
	        ComparerClass compa = new ComparerClass();
	        PriorityQueue<Element_Graph> priq = new PriorityQueue<Element_Graph>(30, compa);
	        Element_Graph positionNode = creations;
	        while (!positionNode.getState().equals(finalState)) {
	        	findones.add(positionNode.getState());
	            List<ArrayList<Integer>> nextstates = NextStates.getSuccessors(positionNode.getState());
	            for (ArrayList<Integer> next : nextstates) {
	                if (findones.contains(next))
	                    continue;
	                findones.add(next);
	                Element_Graph kid = new Element_Graph(next);
	                positionNode.addChild(kid);
	                kid.setParent(positionNode);
	                if (finder == Heuristic.START)
	                	kid.setTotalCost(positionNode.getMoney() , huerisitcfirst(kid.getState(), finalState));
	                priq.add(kid);
	            }
	            positionNode = priq.poll();
	            time += 1;
	        }
	        
	        NextStates.printSolution(positionNode, findones, start, time);
	    }
}