import MyQueue.ArrayQueue;

public class Main {
    public static void main(String[] args) {

//        MyStackWithLinkedList my_stk = new MyStackWithLinkedList();
//        my_stk.push("ali");
//        my_stk.push("ahmad");
//        my_stk.push("assad");
//        my_stk.push("mohamed");
//        my_stk.push("loay");
//        my_stk.push("najeeeb");
//        my_stk.push("Ghaith");
//        my_stk.push("Zain");
//
//        System.out.println(my_stk.toString());
//        System.out.println("the position of ali is : " + my_stk.search("loay"));//3


//        MyQueueWithLinkedList my_queue = new MyQueueWithLinkedList<String>();
//        my_queue.enqueue("ali");
//        my_queue.enqueue("ahmad");
//        my_queue.enqueue("jabeer");
//        my_queue.enqueue("mohamed");
//        my_queue.deleteFromLast();
//        my_queue.deleteFromLast();
//        my_queue.dequeue();
//        System.out.println(my_queue.indexOf("ahmad"));
//        my_queue.reverse();
//        System.out.println(my_queue.toString());
//
//        my_stk.push("ali");
//        my_stk.push("ahmad");
//        my_stk.push(32);
//
//        System.out.println(my_stk.toString());;
//
//        my_stk.clear();
//
//        System.out.println(my_stk.toString());;


        ArrayQueue myQueueWithArr = new ArrayQueue(4);
        myQueueWithArr.enqueue(2);
        myQueueWithArr.enqueue(4);
        myQueueWithArr.enqueue(5);
        myQueueWithArr.enqueue(6);
        System.out.println(myQueueWithArr.toString());

        myQueueWithArr.dequeue();

        System.out.println(myQueueWithArr.toString());

        myQueueWithArr.dequeue();
        System.out.println(myQueueWithArr.toString());

        myQueueWithArr.enqueue(22);
        System.out.println(myQueueWithArr.toString());

        myQueueWithArr.dequeue();
        System.out.println(myQueueWithArr.toString());

        myQueueWithArr.dequeue();
        System.out.println(myQueueWithArr.toString());

        myQueueWithArr.dequeue();
        System.out.println(myQueueWithArr.toString());

        myQueueWithArr.enqueue(3232);
        System.out.println(myQueueWithArr.toString());

        myQueueWithArr.enqueue(3232);
        System.out.println(myQueueWithArr.toString());

        myQueueWithArr.dequeue();
        System.out.println(myQueueWithArr.toString());

        myQueueWithArr.dequeue();

        System.out.println(myQueueWithArr.toString());







        //          Stack<String> stack = new Stack<String>();
//          stack.push("ali");
//          stack.push("ahmad");
//          stack.push("jabeer");
//         System.out.println(stack);
    }
}