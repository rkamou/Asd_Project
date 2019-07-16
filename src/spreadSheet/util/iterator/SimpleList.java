package spreadSheet.util.iterator;

import java.util.Iterator;

import spreadSheet.Contents;

public class SimpleList {
	private Contents[] tTable;
	private Integer index;
	public SimpleList(Integer size) {
		tTable = new Contents[size];
		//for(int i=0; i<size; i++) tTable[i] = null;
		index = -1;
	}
	public void push(Contents item) {
		index++;
		tTable[index] = item;
	}
	public Contents pop() {
		Contents c = null;
		if(index>=0) {
			c = tTable[index];
			index--;
		}
		return c;
	}
	public Integer getIndex() {
		return index;
	}
	public Contents[] getElements(){
		Contents[] t = new Contents[index+1];
		for(int i=0; i<=index; i++) t[i] = tTable[i];
		return t;
	}
	public Contents getFirst() {
		return tTable[0];
	}
	public Contents getLast() {
		return tTable[index];
	}
//	private Link<T> first;
//	private Link<T> last;
//	
//	public Link<T> getFirst() {
//		return first;
//	}
//
//	public Link<T> getLast() {
//		return last;
//	}
//
//	public void push(T item) {
//		if (first == null) {
//			first = new Link(item);
//			last = first;
////			return first;
//		} else {
//			first = first.append(item);
//			 
////			return l;
//		}
//	}
//
//	public Link<T> pop() {
//		Link<T> t = null;
//		if (last == first) {
//			t = first;
//			first = null;
//			last = first;
//
//		} else {
//			first = first.getNext();
//			t = first;
//		}
//		return t;
//	}
//
//	public Link<T> popLast()			
//	{
//		Link<T> t,r;
//		if (last == first)					
//		{
//			t = first;
//			first = null;			
//			last = first;
//			
//		}else {
//		t = first; 
//		while(t.getNext().getNext()!=null) t = t.getNext();
//			t = t.getNext();
//		}
//		r = t.getNext();
//		last.setNext(t);
//		return r;
//	}
//
//	public Iterator iterator() {
//		return new SimpleListIterator();
//	}
//
//	private class SimpleListIterator implements Iterator {
//		private Link current = null;
//
//		public boolean hasNext() {
//			if (current == null)
//				return first != null;
//			else
//				return current.getNext() != null;
//		}
//
//		public T next() {
//			T item = null;
//
//			if (current == null)
//				current = first;
//			else
//				current = current.getNext();
//
//			if (current != null)
//				item = (T) current.getItem();
//
//			return item;
//		}
//
//		// Remove current item
//		public void remove() {
//			// TODO:
//			if (current.getItem() == first.getItem()) {
//				first = first.getNext();
//			} else {
//				Link k = first;
//				boolean found = false;
//				while (found == false && k.getNext() != null) {
//					if (k.getNext().getItem() != current.getItem()) {
//						k = k.getNext();
//					} else {
//						found = true;
//						k.setNext(k.getNext().getNext());
//					}
//
//				}
//			}
//		}
//	}
//
//	// Using its own Iterator
//	public int count() {
//		int count = 0;
//		Iterator iterator = this.iterator();
//		if (iterator.hasNext())
//			while (iterator.hasNext()) {
//				count++;
//				iterator.next();
//			}
//		return count;
//	}
}
