import java.util.Scanner;

public class QueueDriver {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CustomQueue list = new CustomQueue();
		System.out.println("My Queue");
		
		while(true) {
			System.out.println("\nQueue Options\n");
			System.out.println("1. Add to queue");
			System.out.println("2. Take from queue");
			System.out.println("3. Peek at queue");
			System.out.println("4. check if empty");
			System.out.println("5. check if full");
			System.out.println("6. get size");
			System.out.println("7. exit");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter integer element to insert");
				list.enQueue(scan.nextInt());
				break;
			case 2:
				if (list.getSize() == 0) {
					System.out.println("Nothing to remove from queue!");
				} else {
					System.out.println("Data just removed from queue: " + list.deQueue());
				}
				break;
			case 3:
				if (list.getSize() == 0) {
					System.out.println("Nothing to see here!");
				} else {
				System.out.println("Data currently at start of queue: " + list.peek());
				}
				break;
			case 4:
				System.out.println("Empty status = "+ list.isEmpty());
				break;
			case 5:
				System.out.println("Full status = " + list.isFull());
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
