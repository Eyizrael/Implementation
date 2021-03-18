
package dystackarray;
public class DyStackArray {
private int stackSize;
private int[] stackArray;
private int top;
 public DyStackArray(int size) {
    this.stackSize = size;
    this.stackArray = new int[stackSize];
    this.top = -1;
}
 public void push(int entry) throws Exception {
    if(this.isStackFull()){
    	System.out.println("Stack Overflow");
    this.increaseStackCapacity();
	}
	System.out.println("Adding: "+entry);
        this.stackArray[++top] = entry;
}public int pop() throws Exception {
    if(this.isStackEmpty()){
    	System.out.println("Stack underflow.");
	}
	int entry = this.stackArray[top--];
	System.out.println("Removed entry: "+entry);
	return entry;
}
 public int peek() {
    return stackArray[top];
}
 

public boolean isStackEmpty() {
    return (top == -1);
}
 

public boolean isStackFull() {
    return (top == stackSize - 1);
}
 

private void increaseStackCapacity(){	         
    int[] newStack = new int[this.stackSize*2];
    for(int i=0;i<stackSize;i++){
        newStack[i] = this.stackArray[i];
    }
    this.stackArray = newStack;
    this.stackSize = this.stackSize*2;
}
 
public static void main(String args[]){
	DyStackArray stack = new DyStackArray(3);
	try {
		for(int i=1;i<10;i++){
		    stack.push(i);
		}
		for(int i=1;i<4;i++){
			 stack.pop();
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}