package listIterator;

public class ListIterator {

	private Link current;
	private Link previous;
	private LinkList ourList;

	public ListIterator(LinkList list) {
		ourList = list;
		reset();
	}

	public boolean atEnd() {
		return (current.getNext() == null);
	}

	public boolean find(long key) {
		reset();
		while (current.getdData() != key && !atEnd()) {
			nextLink();
			if (current.getdData() == key) {
				return true;
			}
		}
		return false;
	}

	public void nextLink() {
		previous = current;
		current = current.getNext();
	}

	public void reset() {
		current = ourList.getFirst();
		previous = null;
	}

	public void insertBefore(long dData) {
		Link newLink = new Link(dData);

		if (previous == null) {
			newLink.setNext(ourList.getFirst());
			ourList.setFirst(newLink);
			reset();
		} else {
			newLink.setNext(previous.getNext());
			previous.setNext(newLink);
			current = newLink;

		}
	}

	public void insertAfter(long dData) {

		Link newLink = new Link(dData);

		if (ourList.isEmpty()) {
			ourList.setFirst(newLink);
			current = newLink;
		} else {
			newLink.setNext(current.getNext());
			current.setNext(newLink);
			nextLink();
		}

	}

	public long deleteCurrent() {
		long value = current.getdData();
		if (previous == null) {
			ourList.setFirst(current.getNext());
			reset();
		} else {
			previous.setNext(current.getNext());
			if (atEnd()) {
				reset();
			}
		}
		return value;
	}

	public Link getCurrent() {
		return current;
	}

}
