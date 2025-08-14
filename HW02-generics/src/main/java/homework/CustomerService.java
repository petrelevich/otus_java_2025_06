package homework;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class CustomerService {

    private final TreeMap<Customer, String> map = new TreeMap<>(Comparator.comparingLong(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() {
        Map.Entry<Customer, String> entry = map.firstEntry();
        return entry == null ? null : Map.entry(copyCustomer(entry.getKey()), entry.getValue());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        Map.Entry<Customer, String> entry = map.higherEntry(customer);
        return entry == null ? null : Map.entry(copyCustomer(entry.getKey()), entry.getValue());
    }

    public void add(Customer customer, String data) {
        map.put(customer, data);
    }

    private Customer copyCustomer(Customer original) {
        return new Customer(original.getId(), original.getName(), original.getScores());
    }
}