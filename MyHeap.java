import java.util.NoSuchElementException;
public class MyHeap{
  public static void main(String[] args){
    //for testing purposes
  }
  private static void swap(int a,int b,int[] data){
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
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
    try{
      int a = getChildA(index,size);
      try{
        //there are two children, so comparison is necessary
        int b = getChildB(index,size);
        if(data[b] > data[a]){
          swap(index,b,data);
          pushDown(data,size,b);
        }else{
          swap(index,a,data);
          pushDown(data,size,a);
        }
      }catch(NoSuchElementException e){
        //no child for second, special case of only one child
        swap(index,a,data);
        pushDown(data,size,a);
      }
    }catch(NoSuchElementException e){
      //no children at all, pushDown is complete (do nothing)
    }
  }
  private static void pushUp(int[] data,int index){

  }
  public static void heapify(int[] data){

  }
  public static void heapsort(int[] data){

  }
}
