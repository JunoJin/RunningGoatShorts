package graph306;

import java.util.*;

/**
 * NOTE: Removing from the list will cause the indices map to become invalid.
 * NOTE: Adding partway through (not at the end of) the list will cause the indices map to become invalid.
 * Presently untested.
 * A class representing the graph using an adjacency list.
 */
public class AdjacencyList {

    //List of maps containing parent nodes and the edge weight to them.
    private List<Map<String, Integer>> adjacencyList = new ArrayList<>();

    //Maps nodes to their index in the adjacency list.
    private Map<String, Integer> indices = new HashMap<>();

    //Maps nodes to their weights.
    private Map<String, Integer> nodeWeights = new HashMap<>();

    /**
     * Adds a node to the graph, or does nothing, if the node has already been added.
     * This may be updated to an exception.
     * @param id The unique identifier for the node.
     */
    public void addNode(String id){

        //Check that the node hasn't already been added. If it has, end the function.
        if (indices.containsKey(id)){
            return;
        }

        //Add a new map to the adjacency list representing that node.
        Map<String, Integer> newEntry = new HashMap<>();
        adjacencyList.add(newEntry);

        //Add node to indices map.
        int newIndex = adjacencyList.size()-1;
        indices.put(id, newIndex);

    }

    /**
     * Adds the weight to an existing node.
     * @param id The unique identifier for the node.
     * @param cost The cost, in time units, for the node.
     */
    public void addNodeWeight(String id, int cost){
        //Add node to weights map.
        nodeWeights.put(id,cost);
    }

    /**
     * Adds an edge to the graph.
     * If the edge contains a node that already is in the graph, addNode is called.
     * @param source The "head" of the node.
     * @param destination The "tail" of the node.
     * @param cost The cost of the edge.
     */
    public void addEdge(String source, String destination, int cost){
        //Add nodes if they haven't been added. (AddNode method performs this check)
        addNode(source);
        addNode(destination);

        //Add the edge and its weight to the map for the node.
        int destinationIndex = indices.get(destination);
        adjacencyList.get(destinationIndex).put(source,cost);
    }

    //Add other methods here to make recursive lookup easier, and replace these getters.

    public List<Map<String, Integer>> getAdjacencyList() {
        return adjacencyList;
    }

    public Map<String, Integer> getIndices() {
        return indices;
    }

    public Map<String, Integer> getNodeWeights() {
        return nodeWeights;
    }
}
