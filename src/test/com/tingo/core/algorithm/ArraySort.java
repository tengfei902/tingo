package tingo.core.algorithm;

import com.google.gson.Gson;
import org.junit.Test;

/**
 * Created by user on 17/8/1.
 */
public class ArraySort {

    private int[] oriArray = {10,8,18,1,4,9,100,18};

    @Test
    public void testArraySort() {
        int i = 0;
        do {
            putMinToTail(oriArray);
            i++;
        } while (i<oriArray.length);
        System.out.println(new Gson().toJson(oriArray));
    }

    private void putMinToTail(int[] oriArray) {
        for(int i=0;i<oriArray.length;i++) {
            exchange(oriArray,i);
        }
    }

    private void exchange(int[] array,int offset) {
        if(offset >= array.length-1) {
            return;
        }
        int temp = array[offset];
        int target = array[offset+1];

        if(temp<target) {
            array[offset] = target;
            array[offset+1] = temp;
        }
    }

//    @Test
//    public void testArraySort2() {
//        int[] newArray = new int[oriArray.length];
//        for(int i=0;i<newArray.length;i++) {
//            int temp = oriArray[0];
//            for(int n=0;n<oriArray.length;n++) {
//                int target = oriArray[n];
//                if(temp<target) {
//                    oriArray[0] =
//                }
//            }
//            newArray[i] = temp;
//        }
//
//    }
}
