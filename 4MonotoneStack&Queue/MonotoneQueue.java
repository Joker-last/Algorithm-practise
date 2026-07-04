import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

// 单调队列通用实现，同时O(1)获取最大、最小值
class MonotonicQueue<E extends Comparable<E>> {
    // 存储原始元素，维持先进先出
    private final Queue<E> queue;
    // 单调递减队列：头部为最大值
    private final Deque<E> maxDeque;
    // 单调递增队列：头部为最小值
    private final Deque<E> minDeque;

    public MonotonicQueue() {
        queue = new ArrayDeque<>();
        maxDeque = new ArrayDeque<>();
        minDeque = new ArrayDeque<>();
    }

    // 标准队列 API，向队尾加入元素
    public void push(E elem) {
        // 维护最大值单调队列：尾部所有 <= 当前元素全部弹出，保持递减
        while (!maxDeque.isEmpty() && maxDeque.peekLast().compareTo(elem) <= 0) {
            maxDeque.pollLast();
        }
        maxDeque.offerLast(elem);

        // 维护最小值单调队列：尾部所有 >= 当前元素全部弹出，保持递增
        while (!minDeque.isEmpty() && minDeque.peekLast().compareTo(elem) >= 0) {
            minDeque.pollLast();
        }
        minDeque.offerLast(elem);

        // 原始队列存入元素
        queue.offer(elem);
    }

    // 标准队列 API，从队头弹出元素，符合先进先出的顺序
    public E pop() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("队列已空，无法弹出元素");
        }
        E val = queue.poll();
        // 如果弹出的值是最大值队列头部，同步移除
        if (maxDeque.peekFirst().equals(val)) {
            maxDeque.pollFirst();
        }
        // 如果弹出的值是最小值队列头部，同步移除
        if (minDeque.peekFirst().equals(val)) {
            minDeque.pollFirst();
        }
        return val;
    }

    // 标准队列 API，返回队列中的元素个数
    public int size() {
        return queue.size();
    }

    // 单调队列特有 API，O(1) 时间计算队列中元素的最大值
    public E max() {
        if (maxDeque.isEmpty()) {
            throw new IllegalStateException("队列为空，无最大值");
        }
        return maxDeque.peekFirst();
    }

    // 单调队列特有 API，O(1) 时间计算队列中元素的最小值
    public E min() {
        if (minDeque.isEmpty()) {
            throw new IllegalStateException("队列为空，无最小值");
        }
        return minDeque.peekFirst();
    }

    // 辅助判断队列是否为空
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}