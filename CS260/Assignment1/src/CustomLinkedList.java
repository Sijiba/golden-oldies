
public class CustomLinkedList {
	private Node start;
	private Node end;
	private int size;
	
	public CustomLinkedList() {
		start = null;
		end = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		if (start == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public void insertAtStart(int val) {
		Node node = new Node(val, null);
		size++;
		if (start == null) {
			start = node;
			end = start;
		} else {
			node.setNext(start);
		}
	}
	
	public void insertAtEnd(int val) {
		Node node = new Node(val, null);
		size++;
		if (start == null) {
			start = node;
			end = start;
		} else {
			end.setNext(node);
			end = node;
		}
	}
	
	public void insertAtPos(int val, int pos) {
		Node node = new Node (val, null);
		Node aNode = start;
		pos = pos - 1;
		for (int i = 1; i < size; i++) {
			if (i == pos) {
				Node tmp = aNode.getNext();
				aNode.setNext(node);
				node.setNext(tmp);
				break;
			}
			aNode = aNode.getNext();
		}
		size++;
	}
	
	public void deleteAtPos(int pos) {
		if (pos == 1) {
			start = start.getNext();
			size--;
			return;
		}
		if (pos == size) {
			Node s = start;
			Node t = start;
			while (s!= end) {
				t = s;
				s = s.getNext();
			}
			end = t;
			end.setNext(null);
			size--;
			return;
		}
		Node aNode = start;
		pos = pos - 1;
		for (int i = 1; i < size - 1; i++) {
			if (i == pos) {
				Node tmp = aNode.getNext();
				tmp = tmp.getNext();
				aNode.setNext(tmp);
				break;
			}
			aNode = aNode.getNext();
		}
		size--;
	}
	
	public void display() {
		System.out.print(/*"\n Linked List = "*/"\n Queue = "); //cosmetic change for consistency with the program.
		if (size == 0) {
			System.out.print("empty\n");
			return;
		}
		if (start.getNext() == null) {
			System.out.println(start.getData());
			return;
		}
		Node aNode = start;
		System.out.print(start.getData()+"->");
		aNode = aNode.getNext();
		while (aNode.getNext() != null) {
			System.out.print(aNode.getData()+"->");
			aNode = aNode.getNext();
		}
		System.out.print(aNode.getData()+"\n");
	}
	
	public int getStartData() {
		/*
		 * This method returns the data at the start position of the custom linked list.
		 * 
		 * This method was added to the CustomLinkedList class because
		 * otherwise, outside classes couldn't access the data hidden inside
		 * without using the display method to display the full list.
		 */
		if (size == 0 || start == null) {
			return 0;
		} else {
			return start.getData();
		}
	}
}
