import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomizedSet {
    Set<Integer> set = new HashSet<>();
    Set<Integer> removed = new HashSet<>();
    List<Integer> list = new ArrayList<>();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if(set.contains(val)){
            return false;
        }
        set.add(val);
        list.add(val);
        if(removed.contains(val)){
            removed.remove(val);
        }
        return true;
    }

    public boolean remove(int val) {
        if(set.contains(val)){
            set.remove(val);
            removed.add(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        int size = list.size();
        Random rand = new Random();
        int random = size;
        while(random >= size || removed.contains(list.get(random))){
            random = rand.nextInt(size);
        }
        return list.get(random);
    }
}
