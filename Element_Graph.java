package Search;
import java.util.ArrayList;

public class Element_Graph {
    private boolean seen;
    private Element_Graph appa;
    private int levels;
    private ArrayList<Integer> design;
    private int finalCost;
    private int price;
    private ArrayList<Element_Graph> kids;
    private int goalCost;

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

    
    public void setVisited(boolean seen) {
        this.seen = seen;
    }
    
    public boolean isVisited() {
        return seen;
    }

  

    public int getTotalCost() {
        return finalCost;
    }

    
    public void setEstimatedCostToGoal(int goalCost) {
        this.goalCost = goalCost;
    }
    
    public void setTotalCost(int finalCost) {
        this.finalCost = finalCost;
    }

    public void setTotalCost(int price, int estimatedprice) {
        this.finalCost = price + estimatedprice;
    }

    public int getEstimatedCostToGoal() {
        return goalCost;
    }

    
    public void setCost(int price) {
        this.price = price;
    }

    public int getMoney() {
        return price;
    }


    public Element_Graph findParent() {
        return appa;
    }

    public void setState(ArrayList<Integer> design) {
        this.design = design;
    }


    public void setParent(Element_Graph appa) {
        this.appa = appa;
    }


    public ArrayList<Integer> getState() {
        return design;
    }

    public Element_Graph(ArrayList<Integer> design) {
        this.design = design;
        kids = new ArrayList<Element_Graph>();
    }


    public ArrayList<Element_Graph> bringChildren() {
        return kids;
    }

    public void addChild(Element_Graph papa) {
    	kids.add(papa);
    }
}