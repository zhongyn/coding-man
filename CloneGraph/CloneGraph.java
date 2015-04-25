/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if (node == null) {
            return null;
        }

        HashMap<Integer, UndirectedGraphNode> newGraph = new HashMap<Integer, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        q.add(node);
        newGraph.put(node.label, new UndirectedGraphNode(node.label));
        UndirectedGraphNode a;


        while (q.size() > 0) {
            a = q.remove();

            
            for (UndirectedGraphNode n : a.neighbors) {
                if (!newGraph.containsKey(n.label)) {
                    newGraph.put(n.label, new UndirectedGraphNode(n.label));
                    q.add(n);
                }
                newGraph.get(a.label).neighbors.add(newGraph.get(n.label));
            }
            
        }

        return newGraph.get(node.label);

    }

    private HashMap<Integer, UndirectedGraphNode> newGraph;

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        newGraph = new HashMap<Integer, UndirectedGraphNode>();
        if (node == null) {
            return null;
        }
        return dfs(node);
    }

    public UndirectedGraphNode dfs(UndirectedGraphNode node) {
        if (newGraph.containsKey(node.label)) {
            return newGraph.get(node.label);
        }

        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        newGraph.put(node.label, clone);
        
        for (UndirectedGraphNode n : node.neighbors) {
            clone.neighbors.add(dfs(n));
        }

        return clone;
    }


}