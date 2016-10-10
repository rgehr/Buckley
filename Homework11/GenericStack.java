import java.util.Arrays;

public class GenericStack<E> {
	
	private E arr[];
	
    private int last;
 
    public GenericStack ()
    {
        this(10);
    }
 
    @SuppressWarnings("unchecked")
	public GenericStack (int size)
    {
        arr = (E [] ) new Object [size];
        last = -1;
    }
 
    public E peek()
    {
        return (last == -1) ? null : arr[last];
    }
 
    public boolean isEmpty()
    {
        return (last == -1);
    }
 
    public E pop()
    {
        return (last == -1) ? null : arr[last--];
    }
 
    public void push(E e)
    {
    	extendArray();
        arr[++last] = e;
    }
 
    public int getSize()
    {
        return (last + 1);
    }
    
    public String toString(){
    	String str = "[";
    	for(int i = 0; i < last; i++){
    		str += arr[i] + ", ";
    	}
    	str += arr[last];
    	str += "]";
    	return "Stack: " + str;
    }
    
    public void extendArray(){
    	if(last == arr.length-1){
    		@SuppressWarnings("unchecked")
			E[] newArr = (E[])new Object[2 * arr.length];
    		for(int i = 0; i < last; i++){
    			newArr[i] = arr[i];
    		}
    		arr = newArr;
    	}
    }
	
}
