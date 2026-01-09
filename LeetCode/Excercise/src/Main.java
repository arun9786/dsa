import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
       int arr[]={
        69,367,1,41,49,217,219,242,23,215,295,347,373,378,506,658,692,703,912,
        973,1046,1337,1464,148,905,238,128,2336,75,148,1451,13,953
       };

       int n=arr.length;
       Set<Integer> set = new HashSet<>();
       while (set.size()<5) {
            set.add((int)(Math.random()*(n)));
       }
       for (int index : set) {
            System.out.println(arr[index]);
       }
    }
}