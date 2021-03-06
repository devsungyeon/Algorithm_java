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

        for(int i=0; i<max_size;i++ ) list[i] = max_size-i;
        System.out.println("Before Merge : " + Arrays.toString(list));
        s.Merge(list,0,max_size-1);
        System.out.println(" After Merge : " + Arrays.toString(list));

        for(int i=0; i<max_size;i++ ) list[i] = max_size-i;
        System.out.println("Before Quick : " + Arrays.toString(list));
        s.Quick(list,0,max_size-1);
        System.out.println(" After Quick : " + Arrays.toString(list));

        for(int i=0; i<max_size;i++ ) list[i] = max_size-i;
        System.out.println("Before Heap_sort : " + Arrays.toString(list));
        s.Heap_sort(list);
        System.out.println(" After Heap_sort : " + Arrays.toString(list));
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
    
    private int sorted[] = new int[10];
    private void merge_list(int[] arr, int left, int mid, int right) {
        int i, j, k, l;
        i = left;
        j = mid+1;
        k = left;

        while(i<=mid && j<=right) {
            if(arr[i] <= arr[j])
                sorted[k++] = arr[i++];
            else
                sorted[k++] = arr[j++];
        }

        int tmp = i>mid ? j:i;

        while(k<=right) sorted[k++] = arr[tmp++];

        for(l=left;l<=right;l++) arr[l] = sorted[l];
    }
    public void Merge(int[] arr, int left, int right) {
        int mid;
        if(left<right) {
            mid = (left+right) / 2;
            Merge(arr, left, mid);
            Merge(arr, mid+1, right);
            merge_list(arr, left, mid, right);
        }

    }

    public void Quick(int[] arr, int start, int end) {
        if(start >= end) {
            return;
        }

        int pivot = start;
        int i = pivot + 1;
        int j = end;
        int temp;

        while(i<=j) {
            while(i<=end && arr[i] <= arr[pivot]) {
                i++;
            }
            while(j>start && arr[j] >= arr[pivot]) {
                j--;
            }
            if(i>j) {
                exch(arr,j,pivot);
            }
            else {
                exch(arr,i,pivot);
            }
        }
        Quick(arr, start, j-1);
        Quick(arr, j+1, end);
    }

    private int size ;
    private void Heapify(int[] arr) {
        for(int i = 1 ; i<size ; i++) {
            int child = i;
            while(child > 0) {
                int root = (child-1)/2;
                if(arr[root] < arr[child]) {
                    exch(arr, root, child);
                }
                child = root;
            }
        }
    }
    private void Heap(int[] arr) {
        exch(arr, 0, size-1);
        size--;
    }
    public void Heap_sort(int[] arr) {
        size = arr.length;
        for(int i = 0 ; i < arr.length; i++ ) {
            Heapify(arr);
            Heap(arr);
        }
    }

    private boolean less(int v, int w) {
        return v<w?true:false;
    }
    private void exch(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}