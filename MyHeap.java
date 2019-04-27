import java.util.NoSuchElementException;
import java.util.Arrays;
public class MyHeap{
  public static void main(String[] args){
    int[] eg = {14,32,23,4,17,1,23};
    pushDown(eg,5,0);
    System.out.println(Arrays.toString(eg));
    int[] eg2 = {100,56,34,55,55,77,1,9,2,3,3,3,3};
    pushUp(eg2,5);
    System.out.println(Arrays.toString(eg2));
    int[] randAry = randArray(25,100);
    heapify(randAry);
    System.out.println(Arrays.toString(randAry));
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
    //System.out.println("PD "+index);
    try{
      int a = getChildA(index,size);
      try{
        //there are two children, so comparison is necessary
        int b = getChildB(index,size);
        if(data[index] < data[a] || data[index] < data[b]){
          if(data[b] > data[a]){
            swap(index,b,data);
            pushDown(data,size,b);
          }else{
            swap(index,a,data);
            pushDown(data,size,a);
          }
        }
      }catch(NoSuchElementException e){
        //no child for second, special case of only one child
        if(data[index] < data[a]){
          swap(index,a,data);
          pushDown(data,size,a);
        }
      }
    }catch(NoSuchElementException e){
      //no children at all, pushDown is complete (do nothing)
    }
  }
  private static void pushUp(int[] data,int index){
    int p = getParent(index);
    while(data[p] < data[index]){
      swap(p,index,data);
      index = p;
      p = getParent(index);
    }
  }
  public static void heapify(int[] data){
    for(int i=data.length-1;i>=0;i--){
      pushDown(data,data.length,i);
    }
  }
  public static void heapsort(int[] data){
    heapify(data);
    for(int i=data.length-1;i>0;i--){
      swap(0,i,data);
      pushDown(data,i,0);
    }
  }

  //for testing purposes
  private static int[] randArray(int length,int max){
    int[] out = new int[length];
    for(int i=0;i<length;i++){
      out[i] = (int)(Math.random()*max);
    }
    return out;
  }
}
