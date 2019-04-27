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
    System.out.println(Arrays.toString(randAry));
    heapify(randAry);
    System.out.println(Arrays.toString(randAry));
    int[] rand2 = randArray(25,100);
    heapsort(rand2);
    System.out.println(Arrays.toString(rand2));
  }
  private static void swap(int a,int b,int[] data){
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }
  private static boolean inPlace(int[] data,int index,int size){
    //System.out.println("ip "+index+" "+size);
    return index*2+1 >= size || //has no children
           (index*2 + 2 == size && (data[index*2 + 1] <= data[index])) || //one child, but in place
           (index*2 + 2 < size &&
              data[index*2 + 1] <= data[index] &&
              data[index*2 + 2] <= data[index]);//two children, both are <= to it
  }
  private static void pushDown(int[] data,int size,int index){
    while(!inPlace(data,index,size)){//guarantees has a child greater than it
      int largestChild = index*2 + 1;//safe since has at least one child
      if(index*2 + 2 < size && data[index*2 + 2] > data[largestChild]){//two children and second > first
        largestChild = index*2 + 2;
      }
      //System.out.println(largestChild+" "+size+" "+data.length);
      swap(index,largestChild,data);
      index = largestChild;
    }
  }
  private static void pushUp(int[] data,int index){
    int p = (index-1)>>1;
    while(data[p] < data[index]){
      swap(p,index,data);
      index = p;
      p = (index-1)>>1;
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
