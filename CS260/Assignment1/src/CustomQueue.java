// TODO needs enQueue, deQueue, peek, isEmpty, isFull
public class CustomQueue {
	private CustomLinkedList list;
	
	public CustomQueue() {
		list = new CustomLinkedList();
	}
	
	public void enQueue(int val) {
		list.insertAtEnd(val);
	}
	
	public int deQueue() {
		if (list.getSize() > 0) {
			int value = list.getStartData();
			list.deleteAtPos(1);
			return value;
		} else {
			return Integer.MIN_VALUE;
		}
	}
	
	public int peek() {
		return list.getStartData();
	}
	
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public boolean isFull() {
		return false;
	}
	
	public int getSize() {
		return list.getSize();
	}
	
	public void display() {
		list.display();
		/*
		System.out.print("\n Queue = ");
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
		*/
	}
}
