import java.util.ArrayList;
import java.util.HashMap;

public class PhoneDirectory {
    HashMap<String, ArrayList<String>> phDirectory;

    public PhoneDirectory() {
        phDirectory = new HashMap<>();
    }

    public void add(String name, String number) {
        phDirectory.putIfAbsent(name, new ArrayList<>());
        phDirectory.get(name).add(number);
    }

    public ArrayList<String> get(String name) {
        return phDirectory.getOrDefault(name, new ArrayList<>());
    }
}