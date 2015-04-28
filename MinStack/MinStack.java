class Node {
    int val;
    Node next;
    Node less;
    Node greater;

    public Node() {};
    public Node (int v) {
        val = v;
    }
}

class MinStack {
    Node head = new Node();
    Node min = new Node();

    public void push(int x) {
        Node n = new Node(x);
        n.next = head.next;
        head.next = n;

        Node p = min;
        while (p.greater != null && p.greater.val < x) {
            p = p.greater;
        }
        n.less = p;
        n.greater = p.greater;
        p.greater = n;
        if (n.greater != null) {
            n.greater.less = n;
        }

    }

    public void pop() {
        Node h = head.next;
        if (h != null) {
            h.less.greater = h.greater;
            if (h.greater != null) {
                h.greater.less = h.less;
            }

            head.next = h.next;
        }
    }

    public int top() {
        return head.next.val;
        // if the stack is empty...
    }

    public int getMin() {
        return min.greater.val;
    }

    public static void main(String[] args) {
        MinStack st = new MinStack();
        st.push(-3);
        System.out.println(st.getMin());
    }
}

class MinStack {
    private Deque<Integer> stack = new LinkedList<>();
    private int min;

    public void push(int x) {
        if (stack.size() == 0) {
            min = x;
            stack.push(x - min);
        } else {
            stack.push(x - min);
             if (x < min) {
                min = x;
            }
        }
    }

    public void pop() {
        int x = stack.peek();
        if (x < 0) {
            min = min - x;
        }
        stack.pop();
    }

    public int top() {
        int x = stack.peek();
        return x > 0 ? x + min : min - x;
    }

    public int getMin() {
        return min;
    }
}

class MinStack {
    private Deque<Integer> stack = new LinkedList<>();
    private int min;

    public void push(int x) {
        if (stack.size() == 0) {
            min = x;
        }
        stack.push(min);
        stack.push(x);
        min = Math.min(min, x);
    }

    public void pop() {
        stack.pop();
        min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}



