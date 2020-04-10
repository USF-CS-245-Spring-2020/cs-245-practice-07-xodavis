import java.util.Arrays;

public class ArrayQueue<T> implements Queue<T>{
	
	int front;
	int back;
	int item_count;
	T [] arr;

	public ArrayQueue(){
		front = 0;
		back = -1;
		item_count = 0;
		arr = (T[]) new Object[10];
	}

	public T dequeue() throws ArrayIndexOutOfBoundsException{
		if(item_count == 0)
			throw new ArrayIndexOutOfBoundsException("Queue is empty");
		item_count--;
		return arr[front++];
	}

	public void enqueue(T item){
		if(item_count == arr.length)
			grow_array();
		++item_count;
		arr[++back % arr.length] = item;
	}

	public boolean empty(){
		return front == back + 1;
	}

	public void grow_array(){
		T[] a = (T[]) new Object[arr.length*2];
		for(int i = 0; i < item_count; i++){
			a[i] = arr[i]; //increase the size of the array. Got this from GeeksforGeeks
		} 
		arr = a;
	}
}