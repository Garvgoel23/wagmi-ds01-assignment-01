package main.java.com.wagmi.finance.history;

/*
 TODO[Student]: Array-based stack
 - Enforce underflow/overflow behaviors per tests.
 - Note dynamic growth is allowed only when initial capacity >= 10.
 - Validate null pushes (should throw).
 - Run `OperationStackTest` after changes.
*/

public class OperationStack {
    private final String[] data;
    private int top = -1;

    public OperationStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Stack capacity must be more than zero.");
        }
        this.data = new String[capacity];
    }

    public void push(String operation) {
        if (operation== null){
        // stub
        throw new IllegalArgumentException("Operation cannot be null");
    }
        if (top == -1){
            top = 0;
            data[top]= operation;
        }
        else if(top==data.length-1){
            throw new UnsupportedOperationException("overflow condition");
        }
        else{
            top++;
            data[top]=operation;}
}

    public String pop() {
        // stub
        if (top == -1) {
            throw new UnsupportedOperationException("underflow condition");
        }
        String temp = data[top];
        data[top--] = null;
        return temp;
    }

    public String peek() {
        // stub
        if (top == -1){
        throw new UnsupportedOperationException("Not implemented");
    }
        String temp = data[top];
        return temp;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public int size() {
        return top + 1;
    }
}
