import java.util.Scanner;

public class LinkedListDriver {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CustomLinkedList list = new CustomLinkedList();
		System.out.println("My Linked List");
		
		while(true) {
			System.out.println("\nSingly Linked List Options\n");
			System.out.println("1. insert at beginning");
			System.out.println("2. insert at end");
			System.out.println("3. insert at position");
			System.out.println("4. delete at position");
			System.out.println("5. check empty");
			System.out.println("6. get size");
			System.out.println("7. exit");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter integer element to insert");
				list.insertAtStart(scan.nextInt());
				break;
			case 2:
				System.out.println("Enter integer element to insert");
				list.insertAtEnd(scan.nextInt());
				break;
			case 3:
				System.out.println("Enter integer element to insert");
				int num = scan.nextInt();
				System.out.println("Enter position");
				int pos = scan.nextInt();
				if (pos <= 1 || pos > list.getSize()) {
					System.out.println("Invalid position\n");
				} else {
					list.insertAtPos(num, pos);
				}
				break;
			case 4:
				System.out.println("Enter position");
				int p = scan.nextInt();
				if (p < 1 || p > list.getSize()) {
					System.out.println("Invalid position\n");
				} else {
					list.deleteAtPos(p);
				}
				break;
			case 5:
				System.out.println("Empty status = "+ list.isEmpty());
				break;
			case 6:
				System.out.println("Size = " + list.getSize() + "\n");
				break;
			case 7:
				scan.close();
				System.exit(0);
			default:
				System.out.println("Wrong Entry \n");
				break;
			}
			list.display();
		}
	}
}
