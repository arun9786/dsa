import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(majorityElement(new int[]{2,2,1,3,4}));
    }

    public int majorityElement(int[] nums) {
        int count=0;
        Integer candidate=null;
        for(int num:nums){
            if(count==0){
                candidate=num;
            }
            count+= (num==candidate)?1:-1;
        }
        return candidate;
    }
}
