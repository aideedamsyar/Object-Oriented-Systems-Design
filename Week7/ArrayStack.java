package Week7;

public class ArrayStack {
    private int size;
    private int maxSize;
    private int top; // index of top
    private int[] arr;

    ArrayStack(int size) {
        this.size = size;
        arr = new int[size];
        maxSize = size;
        top = -1;
    }

    public void push(int x) {
        if (this.top + 1 == maxSize) {
            maxSize*=2;
            int[] temp = new int[maxSize];
            for (int i=0; i <= this.top; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
        }

        this.top++;
        arr[this.top] = x;
    }

    public int pop() {
        int x = -1;

        if (this.top == -1) return 0;
        else {
            x = this.arr[this.top--];
        }
        return x;
    }

    public int peek() {
        if (this.top == -1) {
            return 0;
        } else {
            return this.arr[this.top];
        }
    }

    public boolean isEmpty() {
        if (this.top == -1) return true;
        else return false;
    }

    public void display() {
        if (!isEmpty()) {
            System.out.print("Stack: ");
            for (int i = 0; i <= this.top; i++) {
                System.out.print(this.arr[i] + " ");
            }
        } else {
            System.out.println("Stack is empty.");
        }
    }

}
