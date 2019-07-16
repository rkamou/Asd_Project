package spreadSheet.util.iterator;

public class Link <T>
{
	private T item;		// The item I hold
	private Link next;			// The link I succeed

	public Link(T item)			
	{
		this.item = item;		// The item I hold is set here
	}
	
	// Constructor that is told what the next Link is
	public Link(T item, Link next)
	{
		this.item = item;		// The item I hold is set here
		this.next = next;
	}

	public Link append(T item)
	{
		//next = new Link(item);	// Create my "next" Link that will hold the item
		Link k = new Link(item);
		k.setNext(this);			// Return a reference to this new item
		return k;
	}

	public T getItem() { return item; }
	
	public Link getNext() { return next; }
	public void setNext(Link next) { this.next = next; }

	@Override
	public int hashCode() {
		final int prime= 31;
		int result= 1;
		result= prime * result + ((item == null) ? 0 : item.hashCode());
		return result;
	}

	
}