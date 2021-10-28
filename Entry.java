
/**
 * 
 * @author tylercambron
 * 
 * @param <K> Key class.
 * @param <V> Value class.
 */
public class Entry<K extends Comparable<K>, V> implements Comparable<Entry<K, V>> {
	private K key;
	private V value;
	/**
	 * @param key2 
	 * @param value2
	 */
	public Entry(K key2, V value2) {
		setKey(key2);
		setValue(value2);
	}
	/**
	 * @param key 
	 */
	public void setKey(K key) {
		this.key = key;
	}
	/**
	 * @return key
	 */
	public K getKey() {
		return key;
	}
	/**
	 * @param value
	 */
	public void setValue(V value) {
		this.value = value;
	}
	/**
	 * @return value
	 */
	public V getValue() {
		return value;
	}

	/**
	 * @param object to compare this to.
	 */
	@Override
	public boolean equals(Object object) {
		if (object instanceof Entry<?, ?>) {
			Entry<?, ?> e = (Entry<?, ?>) object;
			return e.getKey().equals(this);
		} else {
			return false;
		}
	}

	/**
	 * @param entry to compare this entry to.
	 * @return # > 0, < 0, or = 0.
	 */
	@Override
	public int compareTo(Entry<K, V> entry) {
		K key1 = getKey();
		K key2 = entry.getKey();
		return key1.compareTo(key2);
	}
}
