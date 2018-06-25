package cn.luguangyi.javax.guava;


import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.*;
import com.google.common.graph.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GuavaTest {
    public static void main(String[] args) {
        multiSetTest();
        multiMapTest();
        biMapTest();
        tableTest();
        classToInstanceMapTest();
        rangeSetTest();
        rangeMapTest();
        graphTest();
    }

    static void multiSetTest() {
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("b");
        multiset.add("a");
        System.out.println(multiset.count("a"));
        multiset.add("a", 3);
        System.out.println(multiset.count("a"));
    }

    static void multiMapTest() {
        Multimap<String, String> multimap = HashMultimap.create();
        multimap.put("a", "a");
        multimap.put("a", "b");
        multimap.put("a", "b");
        System.out.println(multimap.get("a"));
    }

    static void biMapTest() {
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("a", "b");
        biMap.forcePut("c", "b");
        System.out.println(biMap.inverse().get("b"));
    }

    static void tableTest() {
        Table<String, String, Integer> table = HashBasedTable.create();
        table.put("a", "b", 4);
        table.put("a", "c", 20);
        table.put("b", "c", 5);
        table.column("c");
    }

    static void classToInstanceMapTest() {
        ClassToInstanceMap<Number> numberDefaults = MutableClassToInstanceMap.create();
        numberDefaults.putInstance(Integer.class, Integer.valueOf(0));
        numberDefaults.putInstance(Integer.class, Integer.valueOf(1));
        Number val = numberDefaults.get(Integer.class);
        System.out.println(val);
    }

    static void rangeSetTest() {
        RangeSet<Integer> rangeSet = TreeRangeSet.create();
        rangeSet.add(Range.closed(1, 10)); // {[1, 10]}
        System.out.println(rangeSet.contains(15));
        rangeSet.add(Range.closed(12, 20)); // {[1, 10]}
        System.out.println(rangeSet.contains(15));
    }

    static void rangeMapTest() {
        RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closed(90, 100), "a");
        rangeMap.put(Range.closed(80, 89), "b");
        rangeMap.put(Range.closed(70, 79), "c");
        rangeMap.put(Range.closed(60, 69), "d");
        rangeMap.put(Range.closed(0, 59), "e");
        System.out.println(rangeMap.get(99));
        System.out.println(rangeMap.get(70));
        System.out.println(rangeMap.get(40));
        System.out.println(rangeMap.get(101));
    }

    static void graphTest() {
        MutableGraph<String> graph = GraphBuilder.undirected().build();
        graph.addNode("node-a");
        graph.addNode("node-b");
        graph.addNode("node-c");
        graph.addNode("node-d");

        graph.putEdge("node-a", "node-b");
        graph.putEdge("node-a", "node-c");
        graph.putEdge("node-b", "node-d");
        graph.putEdge("node-c", "node-d");

        graph.hasEdgeConnecting("node-a", "node-b"); // true
        graph.degree("node-a"); // 2
        graph.successors("node-a"); // [node-c, node-b]

        MutableNetwork<String, Integer> network = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .expectedNodeCount(100000)
                .expectedEdgeCount(1000000)
                .build();
        network.addNode("node-a");
        network.addNode("node-b");
        network.addNode("node-c");
        network.addNode("node-d");
        network.addEdge("node-a", "node-b", 1);
        network.addEdge("node-a", "node-c", 2);
        network.addEdge("node-b", "node-d", 3);
        network.addEdge("node-c", "node-d", 4);
        System.out.println(network.edgesConnecting("node-a", "node-d"));
        System.out.println(network.edgesConnecting("node-a", "node-b"));
        System.out.println(network.hasEdgeConnecting("node-a", "node-d"));
    }

}
