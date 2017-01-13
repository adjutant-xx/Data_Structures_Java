package Tree.Graph;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Graph_Test {
    private Graph<Character> _graph = new Graph();
    private char[] _graphVertices = {'A','B','C','D','E','F','G','H','I'};
    private char[][] _graphEdges = {{'A','B'},{'B','C'},{'C','G'},{'B','E'},{'E','D'},{'D','F'},{'F','A'},{'I','B'}};

    @Test
    public void testGraphVerticesInsertion() throws Exception{
        for(Character item : _graphVertices){
            boolean isInserted = _graph.addVertex(item);
            assert(isInserted);
        }
        HashMap<Character, GraphNode<Character>> vertices = _graph.getVertices();
        int i = 0;
        for(Map.Entry<Character, GraphNode<Character>> vertex : vertices.entrySet()){
            assert(vertex.getValue().getData() == _graphVertices[i]);
            i++;
        }
    }

    @Test
    public void testGraphSize() throws Exception{
        testGraphVerticesInsertion();
        assert(_graph.getSize() == _graphVertices.length);
    }

    @Test
    public void testGraphEdgeInsertion() throws Exception{
        testGraphVerticesInsertion();
        for(char[] item : _graphEdges){
            boolean isInserted = _graph.addEdge(item[0], item[1]);
            assert(isInserted);
        }
    }
}
