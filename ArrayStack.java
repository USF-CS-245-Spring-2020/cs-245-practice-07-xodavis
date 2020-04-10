import java.util.Arrays;

public class ArrayStack<T> implements Stack<T>{

	T[] arr;
	int top;

	public ArrayStack(){
		arr = (T[]) new Object[10];
		top = 0;
	}

	public void push(T item){
		if(top == arr.length)
			grow_array();
		arr[top++] = item;
	}

	public T pop() throws ArrayIndexOutOfBoundsException{
		if(top == 0)
			throw new ArrayIndexOutOfBoundsException("The Stack is currently empty.");
		return arr[--top];
	}

	public T peek() throws ArrayIndexOutOfBoundsException{
		if(top == 0)
			throw new ArrayIndexOutOfBoundsException("The Stack is currently empty.");
		return arr[top];
	}

	public boolean empty(){
		return top == 0;
	}

	public void grow_array(){
		T[] a = (T[]) new Object[arr.length*2];
		System.arraycopy(arr, 0, a, 0, arr.length); //copys the array. i got this line from StackOverflow
		arr = a;
	}
}