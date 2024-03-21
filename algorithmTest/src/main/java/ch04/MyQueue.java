package ch04;

public class MyQueue {
    private int[] queueArr;
    private int front;
    private int rear;
    private int count;
    private int capacity;

    public MyQueue(int capacity){
        this.capacity = capacity;
        queueArr = new int[capacity];
        front = 0;
        rear = 0;
        count = 0;
    }

    public void enq(int item){
        if(count == capacity)
            System.out.println("큐에 여유 공간이 없습니다.");
        else{
            queueArr[rear] = item;
            // rear++;  //선형큐 이부분을 수정해서 원형 큐로 변환
            rear = (rear+1) % capacity;

            /*rear++;
            if(rear >= capacity)
                rear = 0;*/
            count++;
        }
    }

    public int deq(){
        if(count == 0) {
            System.out.println("큐에 반환할 요소가 없습니다.");
            return -1;
        }
        else{
            int item = queueArr[front];
            // front++;
            front = (front+1) % capacity;

            /*front++;
            if(front >= capacity)
                front = 0;*/
            count--;
            return item;
        }
    }

    public int peek(){
        if(count == 0) {
            System.out.println("큐에 반환할 요소가 없습니다.");
            return -1;
        }
        else
            return queueArr[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue(5);
        q.enq(1);
        q.enq(2);
        q.enq(3);

        System.out.println(q.deq());    // 1이 정상 출력
        System.out.println(q.peek());   // 2가 정상 출력
        System.out.println(q.deq());    // 2가 정상 출력

        q.enq(4);
        System.out.println(q.deq()); // 3이 정상 출력
        q.enq(5);
        q.enq(6);       // capacity를 넘어서서 범위초과 오류
        q.enq(10);
        q.enq(11);
        q.enq(12);      // 큐에 여유공간 없음 정상출력
    }
}
