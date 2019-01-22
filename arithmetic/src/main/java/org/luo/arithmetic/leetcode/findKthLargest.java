package org.luo.arithmetic.leetcode;

import java.util.PriorityQueue;

/**
 * 找到第k大的元素
 *
 * @author luohaoyu
 * @since 2019-01-17 20:17
 **/
public class findKthLargest {
    public Integer findKthLargest(int[] numbers, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int number : numbers) {
            priorityQueue.add(number);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }
}
