import java.util.NoSuchElementException;
public class MyHeap{
  public static void main(String[] args){
    //for testing purposes
  }
  private static int getChildA(int index,int size){
    if(index*2+1 < size) return index*2+1;
    throw new NoSuchElementException("no child");
  }
  private static int getChildB(int index,int size){
    if(index*2 + 2 < size) return index*2 + 2;
    throw new NoSuchElementException("no second child");
  }
  private static int getParent(int index){
    return (index - 1) / 2;
  }
  private static void pushDown(int[] data,int size,int index){

  }
  private static void pushUp(int[] data,int index){

  }
  public static void heapify(int[] data){

  }
  public static void heapsort(int[] data){

  }
}
