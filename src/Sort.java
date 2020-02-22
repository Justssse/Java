import java.util.Arrays;

public class Sort {

    private static int[] origin = {12,3,476,89,64,457,97,154,433,746,976,536,845,983,324,123,743,975,368,3};

    public static void main(String[] args) {
        printResult(quickSort(origin,0,origin.length - 1));
    }

    //冒泡排序
    static void maoPao(int[] array){
        if (array == null)  return;
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array.length - i - 1 ; j++) {
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("冒泡排序");
        printResult(array);
    }

    //选择排序
    static void xuanZe(int[] array){
        if (array == null) return;
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[index] > array[j]){
                    index = j;
                }
            }
            if (index != i){
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }
        System.out.println("选择排序");
        printResult(array);
    }

    //插入排序
    static void chaRu(int[] array){
        if (array == null) return;
        for (int i = 0; i < array.length - 1; i++) {
            int temp = array[i + 1];
            int index = i;
            while (index >= 0 && array[index] > temp){
                array[index + 1] = array[index];
                index --;
            }
            array[index + 1] = temp;
        }
        System.out.println("插入排序");
        printResult(array);
    }

    /**
     * 希尔排序，结合了插入排序，即在指定的gap下进行插入排序
     */
    static void xiEr(int[] array){
        if (array == null) return;
        int temp, gap = array.length / 2;
        while (gap > 0){
            for (int i = gap; i < array.length; i++) {
                temp = array[i];
                int index = i - gap;
                while (index >= 0 && temp < array[index]){
                    array[index + gap] = array[index];
                    index -= gap;
                }
                array[index + gap] = temp;
            }
            gap /= 2;
        }
        System.out.println("希尔排序");
        printResult(array);
    }

    /////////////////////////////////////////归并排序///////////////////////////////////////////

    static int[] guiBin(int[] array){
        if (array == null || array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array,0,mid);
        int[] right = Arrays.copyOfRange(array,mid,array.length);
        return merge(guiBin(left),guiBin(right));
    }
    //合并两个各自有序的数组的方法
    static int[] merge(int[] left, int[] right){
        if (left == null || right == null) return null;
        int[] result = new int[left.length + right.length];
        int i = 0,j = 0;
        for (int index = 0; index < result.length; index++) {
            if (i >= left.length){
                //左边数组数据已经全部填入
                result[index] = right[j++];
            }else if (j >= right.length){
                //右边数组数据已经全部填入
                result[index] = left[i++];
            }else if (left[i] < right[j]){
                result[index] = left[i++];
            }else {
                result[index] = right[j++];
            }
        }
        return result;
    }

    //快速排序
    static int[] quickSort(int[] array, int left, int right){
        if (array == null || left > right){
            return array;
        }
        int key = array[left];
        int low = left;
        int high = right;
        while (low < high){
            while (low < high && array[high] >= key){
                high --;
            }
            array[low] = array[high];
            while (low < high && array[low] <= key){
                low ++;
            }
            array[high] = array[low];
        }
        array[low] = key;
        quickSort(array,left,low - 1);
        quickSort(array,low + 1,right);
        return array;
    }

    //打印数组元素
    static void printResult(int[] array){
        if (array == null){
            System.out.println("array is null");
            return;
        }
        for (int value : array) {
            System.out.print(value + "  ");
        }
    }

}
