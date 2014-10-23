package com.zhquake.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

import com.zhquake.leetcode.common.UndirectedGraphNode;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list
 * of its neighbors.
 * 
 * OJ's undirected graph serialization: Nodes are labeled uniquely.
 * 
 * We use # as a separator for each node, and , as a separator for node label
 * and each neighbor of the node. As an example, consider the serialized graph
 * {0,1,2#1,2#2,2}.
 * 
 * The graph has a total of three nodes, and therefore contains three parts as
 * separated by #.
 * 
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2. Second node
 * is labeled as 1. Connect node 1 to node 2. Third node is labeled as 2.
 * Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * 
 * @author Zhang, Zhen(zhezhang@microstrategy.com) Oct 14, 2014
 */
public class CloneGraph {
    public class Solution {
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            if (node == null)
                return null;

            Map<UndirectedGraphNode, UndirectedGraphNode> cloneNodes = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
            Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();

            queue.add(node);
            cloneNodes.put(node, new UndirectedGraphNode(node.label));

            while (!queue.isEmpty()) {
                UndirectedGraphNode cur = queue.poll();
                UndirectedGraphNode clone = cloneNodes.get(cur);

                for (UndirectedGraphNode neighbor : cur.neighbors) {
                    if (cloneNodes.get(neighbor) == null) {
                        UndirectedGraphNode cloneNeighbor = new UndirectedGraphNode(
                                neighbor.label);
                        cloneNodes.put(neighbor, cloneNeighbor);
                        queue.add(neighbor);
                    }

                    clone.neighbors.add(cloneNodes.get(neighbor));
                }

            }
            return cloneNodes.get(node);
        }
    }
}
