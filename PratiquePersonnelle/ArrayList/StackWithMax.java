public class StackWithMax {

private int[] item;
private int N = 0;
private int[] max;

public StackWithMax(int capacity){
    item = new int[capacity];//generic array creation not allowed
    max = new int[capacity];
}

public void push(int item){
    this.item[N++] = item;
    if(max[N-1] > item) {
        max[N] = max[N-1];
    } else {
        max[N] = item;
    }
}

public void pop() {
    this.item[N] = 0;
    this.max[N] = 0;
    N--;
}

public int findMax(){
    return this.max[N];
}
public static void main(String[] args) {
    StackWithMax max = new StackWithMax(10);
    max.push(1);
    max.push(10);
    max.push(9);
    max.push(19);
    System.out.println(max.findMax());
    max.pop();
    System.out.println(max.findMax());


}

}
