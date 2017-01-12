package Tree.Graph;

import org.junit.Test;

import java.util.ArrayList;

public class Graph_Test {
    private Graph<Character> _graph = new Graph();
    private char[] _graphVertices = {'A','B','C','D','E','F','G','H','I'};

    @Test public void testGraphVerticesInsertion() throws Exception{
        for(Character item : _graphVertices){
            _graph.addVertex(item);
        }
        ArrayList<GraphNode<Character>> vertices = _graph.getVertices();
        int i = 0;
        for(GraphNode<Character> vertex : vertices){
            assert(vertex.getData() == _graphVertices[i]);
            i++;
        }
    }
}
