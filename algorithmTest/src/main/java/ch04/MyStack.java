package ch04;

public class MyStack {
    private int maxSize;    // 스택의 최대 크기
    private int[] stackArray;   // 스택 데이터를 저장할 배열
    private int top;    // 스택의 최상위 요소를 가르키는 인덱스

    public MyStack(int maxSize){
        this.maxSize = maxSize;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }
    // 스택에 요소를 추가하는 메소드 push
    public void push(int n){
        if(!isFull()) { // 스택이 가득 찼는지 확인
            this.stackArray[++top] = n;
        } else {
            System.out.println("스택에 여유 공간 없음");
        }
    }
    // 스택에 요소를 제거하는 메소드 pop
    public int pop() {
        // this.stackArray[top--] = Integer.parseInt(null);
        // 탑이 가르키는 인덱스를 변화했으니까 실제 데이터를 지울 필요는 없을 수 도 있다.
        if(isEmpty()) {
            System.out.println("스택에 반환할 요소 없음");
            return -1;
        }else {
            return stackArray[top--];
        }
    }
    // 스택의 가장위에 있는 요소가 무엇인지 알려주는 메소드 peek / top
    public int peek() {
        if(isEmpty()) {
            System.out.println("스택에 반환할 요소 없음");
            return -1;
        }else {
            return stackArray[top];
        }
    }
    // 스택이 비어있는지 알려주는 메소드 isEmpty
    public boolean isEmpty() {
        return top == -1;
    }
    // 스택이 가득 찼는지 확인하는 메소드
    public boolean isFull() {
        return top == maxSize -1;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}
