package test.tree.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tree.graph.Graph;
import tree.graph.GraphNode;
import util.TestAssetEngine;

import java.util.HashSet;

/**
 * Contains unit tests for methods contained within the Graph class.
 */
public class GraphTest {

    private TestAssetEngine engine;
    private Graph<Integer> graph;

    public GraphTest() {
        this.engine = new TestAssetEngine(new TestAssetEngine.TestAssetEngineBuilder().upperBoundValue(200).upperBoundSize(200));
    }

    @Before
    public void initialize() {
        this.graph = new Graph<>();
    }

    @Test
    public void graphAddContainsVertexTest() throws Exception {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        GraphNode<Integer>[] vertexArr = new GraphNode[arr.length];
        for(int i = 0; i < arr.length; i++) {
            vertexArr[i] = new GraphNode<>(arr[i]);
        }
        for(GraphNode<Integer> vertex : vertexArr) {
            boolean expected1 = true;
            boolean actual1 = this.graph.addVertex(vertex);
            Assert.assertEquals(expected1, actual1);
        }
        for(GraphNode<Integer> vertex : vertexArr) {
            boolean expected2 = true;
            boolean actual2 = this.graph.containsVertex(vertex);
            Assert.assertEquals(expected2, actual2);
        }
    }

    @Test
    public void graphRemoveContainsVertexTest() throws Exception {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        GraphNode<Integer>[] vertexArr = new GraphNode[arr.length];
        for(int i = 0; i < arr.length; i++) {
            vertexArr[i] = new GraphNode<>(arr[i]);
        }
        for(GraphNode<Integer> vertex : vertexArr) {
            this.graph.addVertex(vertex);
        }
        for(GraphNode<Integer> vertex : vertexArr) {
            boolean expected1 = true;
            boolean actual1 = this.graph.containsVertex(vertex);
            Assert.assertEquals(expected1, actual1);
            boolean expected2 = true;
            boolean actual2 = this.graph.removeVertex(vertex);
            Assert.assertEquals(expected2, actual2);
            boolean expected3 = false;
            boolean actual3 = this.graph.containsVertex(vertex);
            Assert.assertEquals(expected3, actual3);
        }
    }

    @Test
    public void graphAddEdgeIsAdjacentTest() throws Exception {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        GraphNode<Integer>[] vertexArr = new GraphNode[arr.length];
        for(int i = 0; i < arr.length; i++) {
            vertexArr[i] = new GraphNode<>(arr[i]);
        }
        for(GraphNode<Integer> vertex : vertexArr) {
            this.graph.addVertex(vertex);
        }
        for(int i = 0; i < vertexArr.length - 1; i += 2) {
            GraphNode<Integer> x = vertexArr[i];
            GraphNode<Integer> y = vertexArr[i + 1];
            boolean expected1 = true;
            boolean actual1 = this.graph.addEdge(x, y);
            Assert.assertEquals(expected1, actual1);
            boolean expected2 = true;
            boolean actual2 = this.graph.isAdjacent(x, y);
            Assert.assertEquals(expected2, actual2);
        }
    }

    @Test
    public void graphRemoveEdgeIsAdjacentTest() throws Exception {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        GraphNode<Integer>[] vertexArr = new GraphNode[arr.length];
        for(int i = 0; i < arr.length; i++) {
            vertexArr[i] = new GraphNode<>(arr[i]);
        }
        for(GraphNode<Integer> vertex : vertexArr) {
            this.graph.addVertex(vertex);
        }
        for(int i = 0; i < vertexArr.length - 1; i += 2) {
            GraphNode<Integer> x = vertexArr[i];
            GraphNode<Integer> y = vertexArr[i + 1];
            this.graph.addEdge(x, y);
        }
        for(int i = 0; i < vertexArr.length - 1; i += 2) {
            GraphNode<Integer> x = vertexArr[i];
            GraphNode<Integer> y = vertexArr[i + 1];
            boolean expected1 = true;
            boolean actual1 = this.graph.isAdjacent(x, y);
            Assert.assertEquals(expected1, actual1);
            boolean expected2 = true;
            boolean actual2 = this.graph.removeEdge(x, y);
            Assert.assertEquals(expected2, actual2);
            boolean expected3 = false;
            boolean actual3 = this.graph.isAdjacent(x, y);
            Assert.assertEquals(expected3, actual3);
        }
    }

    @Test
    public void graphGetNeighborsTest() throws Exception {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        GraphNode<Integer>[] vertexArr = new GraphNode[arr.length];
        for(int i = 0; i < arr.length; i++) {
            vertexArr[i] = new GraphNode<>(arr[i]);
        }
        for(GraphNode<Integer> vertex : vertexArr) {
            this.graph.addVertex(vertex);
        }
        for(int i = 0; i < vertexArr.length - 3; i += 4) {
            GraphNode<Integer> w = vertexArr[i];
            GraphNode<Integer> x = vertexArr[i + 1];
            GraphNode<Integer> y = vertexArr[i + 2];
            GraphNode<Integer> z = vertexArr[i + 3];
            this.graph.addEdge(w, x);
            this.graph.addEdge(w, y);
            this.graph.addEdge(w, z);
        }
        for(int i = 0; i < vertexArr.length - 3; i += 4) {
            GraphNode<Integer> w = vertexArr[i];
            GraphNode<Integer> x = vertexArr[i + 1];
            GraphNode<Integer> y = vertexArr[i + 2];
            GraphNode<Integer> z = vertexArr[i + 3];
            HashSet<GraphNode<Integer>> expected = new HashSet<>();
            expected.add(x);
            expected.add(y);
            expected.add(z);
            HashSet<GraphNode<Integer>> actual = this.graph.getNeighbors(w);
            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void graphGetNumVerticesTest() throws Exception {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        GraphNode<Integer>[] vertexArr = new GraphNode[arr.length];
        for(int i = 0; i < arr.length; i++) {
            vertexArr[i] = new GraphNode<>(arr[i]);
        }
        for(GraphNode<Integer> vertex : vertexArr) {
            this.graph.addVertex(vertex);
        }
        int expected = vertexArr.length;
        int actual = this.graph.getNumVertices();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void graphGetNumEdgesTest() throws Exception {
        int[] arr = this.engine.generateUnorderedIntegerArray();
        GraphNode<Integer>[] vertexArr = new GraphNode[arr.length];
        for(int i = 0; i < arr.length; i++) {
            vertexArr[i] = new GraphNode<>(arr[i]);
        }
        for(GraphNode<Integer> vertex : vertexArr) {
            this.graph.addVertex(vertex);
        }
        int numEdges = 0;
        for(int i = 0; i < vertexArr.length - 1; i += 2) {
            GraphNode<Integer> x = vertexArr[i];
            GraphNode<Integer> y = vertexArr[i + 1];
            this.graph.addEdge(x, y);
            numEdges++;
        }
        int expected = numEdges;
        int actual = this.graph.getNumEdges();
        Assert.assertEquals(expected, actual);
    }

}
