# Algorithm_java

# Sorting
    

```java
import java.util.Arrays;

public class sorting {
    public static void main(String[] args) {
        int max_size = 10;
        int list[] = new int[max_size];
        
        Sort s = new Sort();

        for(int i=0; i<max_size;i++ ) list[i] = max_size-i;
        System.out.println("Before Selection : " + Arrays.toString(list));
        s.Selection(list);
        System.out.println(" After Selection : " + Arrays.toString(list));

        for(int i=0; i<max_size;i++ ) list[i] = max_size-i;
        System.out.println("Before Insertion : " + Arrays.toString(list));
        s.Insertion(list);
        System.out.println(" After Insertion : " + Arrays.toString(list));

        for(int i=0; i<max_size;i++ ) list[i] = max_size-i;
        System.out.println("Before Bubble : " + Arrays.toString(list));
        s.Bubble(list);
        System.out.println(" After Bubble : " + Arrays.toString(list));
    }
}

class Sort {
    public void Selection(int[] arr) {
        int N = arr.length;
        for(int i = 0 ; i < N ; i++) {
            int min = i;
            for(int j = i+1 ; j < N ;j++ ) {
                if(less(arr[j], arr[min])) {
                    min = j;
                }
            }
            exch(arr, i, min);
        }
    }
    public void Insertion(int[] arr) {
        int N = arr.length;
        for(int i = 0 ; i<N ; i++) {
            for(int j = i ; j > 0 ; j--) {
                if(less(arr[j], arr[j-1])) {
                    exch(arr, j, j-1);
                }
                else {
                    break;
                }
            }
        }
    }
    public void Bubble(int[] arr) {
        int N = arr.length;
        for(int i = 0 ; i < N ; i++ ) {
            for(int j = 1 ; j< N-i; j++ ) {
                if(less(arr[j],arr[j-1])) {
                    exch(arr, j, j-1);
                }
            }
        }
    }
    private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    private void exch(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```
