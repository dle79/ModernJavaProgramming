package Review.prob5;

@FunctionalInterface
public interface BiComparator<T, S> {

	public int compare(T t, S s);
}
