import java.util.ArrayList;
/**
 * 
 * @author tylercambron
 *
 * @param <K> Key class.
 * @param <V> 
 */
public class Dictionary<K extends Comparable<K>, V> {
	private ArrayList<Entry<K, V>> list;
	/**
	 * Constructor
	 */
	public Dictionary() {
		setList(new ArrayList<Entry<K, V>>());
	}
	/**
	 * @return array list
	 */
	public ArrayList<Entry<K, V>> getList() {
		return list;
	}
	/**
	 * @param list
	 */
	public void setList(ArrayList<Entry<K, V>> list) {
		this.list = list;
	}
	/**
	 * Add entry to the end of the array list.
	 * @param key
	 * @param value
	 */
	public void add(K key, V value) {
		Entry<K, V> entry = new Entry<K, V>(key, value);
		list.add(entry);
	}
	/**
	 * Add entry into array list in ordered position.
	 * @param key
	 * @param value
	 */
	public void addSorted(K key, V value) {
		ArrayList<Entry<K, V>> newList = new ArrayList<Entry<K, V>>();
		boolean added = false;
		for (Entry<K, V> e: list) {
			if (e.getKey().compareTo(key) > 0 && !added) {
				newList.add(new Entry<K, V>(key, value));
				added = true;
			}
			newList.add(e);
		}
		list = newList;
	}
	/**
	 * @return amount of dictionary entries
	 */
	public int getSize() {
		return list.size();
	}
	/**
	 * Print dictionary to console
	 */
	public void showDictionary() {
		System.out.println("---------------------------------------------------------");
		for (int i=0; i < getSize(); i++) {
			Entry<K, V> e = list.get(i);
			System.out.println("Entry K:" + e.getKey() +" V:" + e.getValue());
		}
		System.out.println("---------------------------------------------------------");
	}
	/**
	 * Sort the dictionary using SortArray
	 */
	@SuppressWarnings("unchecked")
	public void sort() {
		Entry<K, V>[] listArray = (Entry<K, V>[]) new Entry<?, ?>[getSize()];
		int index = 0;
		// Make it a working array.
		for (Entry<K, V> entry: list) {
			listArray[index] = entry;
			index++;
		}
		listArray = ArraySort.selectionSort(listArray, getSize());
		list = new ArrayList<Entry<K, V>>();
		for (Entry<K, V> entry: listArray) {
			list.add(entry);
		}
	}
}
