package Search;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;


public class Graph_Queue<Item> implements Iterable<Item> {
    private Node<Item> start;  
    private int N;              
    private Node<Item> end; 

    private static class Node<Item> {
        private Item stuff;
        private Node<Item> adutatu;
    }



    public Graph_Queue() {
    	start = null;
    	end = null;
        N = 0;
    }

    
    public boolean over() {
        return start == null;
    }

    
    public int sizefuntions() {
        return N;
    }
    
    public void clearerr() {
    	start = null;
    	end = null;
         N= 0;
    }

  

    
    public Item look() {
        if (over()) throw new NoSuchElementException("less element");
        return start.stuff;
    }

   

    public Item dequeue() {
        if (over()) throw new NoSuchElementException("less elements");
        Item item = start.stuff;
        start = start.adutatu;
        N--;
        if (over()) end = null;  
        return item;
    }
    
    
    public void enqueue(Item stuffs) {

        Node<Item> oldlast = end;
        end = new Node<Item>();
        end.stuff = stuffs;
        end.adutatu = null;
        if (over()) start = end;
        else oldlast.adutatu = end;
        N++;
    }




    public Iterator<Item> iterator() {
        return new ListIterator<Item>(start);
    }

    
    
    public void addQueue(Graph_Queue<Item> line) {
        if (!line.over()) {


            Node<Item> laststart = start;

            if (over()) {
            	start = line.start;
            	end = line.end;
            } else {
            	start = line.start;
            	line.end.adutatu = laststart;
            }

            N = N + line.sizefuntions();
        }

    }
    
    
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> startt) {
            current = startt;
        }

        
        public void remove() {
            throw new UnsupportedOperationException();
        }
        
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.stuff;
            current = current.adutatu;
            return item;
        }
        
        public boolean hasNext() {
            return current != null;
        }
 
    }


}
