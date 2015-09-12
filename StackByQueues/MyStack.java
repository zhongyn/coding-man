import java.util.*;
class MyStack {
    private Deque<Integer> head = new LinkedList<>();
    private Deque<Integer> tail = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        int tsize = tail.size();
        for (int i = 0; i < tsize; i++) {
            head.add(tail.remove());
        }
        tail.add(x);
        swap();
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (!head.isEmpty()) {
            head.remove();
        } else {
            tail.remove();
        }
    }

    // Get the top element.
    public int top() {
        if (!head.isEmpty()) {
            return head.element();
        } else {
            return tail.element();
        }        
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return head.isEmpty() && tail.isEmpty();
    }

    private void swap() {
        Deque<Integer> tmp = head;
        head = tail;
        tail = tmp;
    }

    public static void main(String[] args) {
        MyStack st = new MyStack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st.top());
        st.pop();
        System.out.println(st.top());
        st.pop();
        System.out.println(st.top());
        st.pop();
    }
}