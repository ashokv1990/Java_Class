public class BetterProgrammerTask {

    //  Question 1
    public static Object[] reverseArray(Object[] a) {
        /*
          Please implement this method to
          return a new array where the order of elements has been reversed from the original
          array.
         */

     if(a == null)
            return null;

     else
        { Collections.reverse(Arrays.asList(a)); //reverse the collection
         return a;
        }

    }

    //Question 2

      public static String reverseWords(String s) {
          /*
            Assume that the parameter String can only contain spaces and alphanumeric characters.
            Please implement this method to
            reverse each word in the original String while maintaining the         word order.
            For example:
            parameter: "Hello world", result: "olleH dlrow"
           */
       String temp[] = s.split("\\s+"); //split at spaces
       
       for(int i = 0 ; i<temp.length ; i++)
       {
         temp[i] = new StringBuilder(temp[i]).reverse().toString();
       }
       
       String fin = "";
       
       for(int j = 0 ; j< temp.length ; j++)
       {
         fin += temp[j]+ " ";
         
       }
           return fin;
      }

      //Question 3
       // Please do not change this interface
    public static interface Node {
        int getValue();
        List<Node> getChildren();
    }

    static class Nodes implements Node
    {
      int data;
      List<Node> children;
      
      Nodes(int val)
      {
        data = val;
        children = new ArrayList<Node>();
      }
      
      
      

    @Override
    public List<Node> getChildren() {
      
      return children;
    }



    @Override
    public int getValue() {
      
      return data;
    }
      
    }


    public static List<Node> traverseTreeInWidth(Node root) {
        /*
          Please implement this method to
          traverse the tree in width and return a list of all passed nodes.

          The list should start with the root node, next
          it should contain all second-level nodes, then third-level nodes etc.

          The method shall work optimally with large trees.
         */

      //My BFS Implementation 
  if(root == null)
        return null;
      
       LinkedList<Node> q = new LinkedList<Node>();
       q.add(root);
       HashMap<Node ,Boolean> map = new HashMap<Node, Boolean>();
       map.put(root, true);
     
   
       
       while(!q.isEmpty())
       {
         Node u = q.removeFirst();
         for(Node v : u.getChildren())
         {
           if(!map.containsKey(v))
           {
            
             map.put(v, true);
             q.add(v);
           }
         }
         
       }
       return q;
        
    }

//Question 4

     private static boolean isSorted(List<Integer> l) {
        for (int i = 0; i < (l.size() - 1); i++) {
            if (l.get(i) > l.get(i + 1)) return false;
        }
        return true;
    }

    public static List<Integer> getReversalsToSort(int[] a) {
        /*
         You need to sort an array of integers by repeatedly reversing
         the order of the first several elements of it.

         For example, to sort [12,13,11,14], you need to  reverse the order of the first two (2)
         elements and get [13,12,11,14] and then reverse the order of the first three (3)
         elements and get [11,12,13,14]

         The method should return the shortest(!) possible list of integers corresponding to the required reversals.
         For the previous example, given an array [12,13,11,14]
         the method should return a list with Integers 2 and 3.
        */

        List<Integer> returns = new ArrayList<Integer>();
        if (a == null || a.length < 2) return returns;

        List<Integer> lists = new ArrayList<Integer>();
        for (int i : a) {
            lists.add(i);
        }

        int count = 2;
        while (!isSorted(lists)) {
            Collections.reverse(lists.subList(0, count));
            returns.add(count++);
        }

        return returns;
    }



}