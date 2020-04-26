
public class Main {
	
	public static int numTickets = 0; 						//Keeps track of the number of tickets that have been created
	public static boolean change = false;					//Tracks whether the ticket type is being changed or not
	public static LinkedList tickets = new LinkedList();	//Creates the linked list

	public static void main(String[] args) {
			
		//Creates new tickets with a given creator, owner and issue
		Ticket ticket1 = new Ticket("James", "Fred", "New computer configuration");
		Ticket ticket2 = new Ticket("Jack", "Emily", "Network issue");
		Ticket ticket3 = new Ticket("George", "Harry", "Other");
		Ticket ticket4 = new Ticket("Bill", "Gerald", "Network issue");
		Ticket ticket5 = new Ticket("Ronald", "John", "Software/app installation");
		
		tickets.display();																//Displays the current list of tickets
		
		System.out.println();
		
		//Adds two new tickets
		Ticket ticket6 = new Ticket("Piers", "Harry", "New computer configuration");
		Ticket ticket7 = new Ticket("Lydia", "Gerald", "Security issue");
		
		tickets.display();																//Displays the current list of tickets
		System.out.println();	
		
		tickets.removefirstTicket();													//Removes the first ticket in the list
		System.out.println();
		tickets.display();																//Displays the current list of tickets
		
		System.out.println();
		
		Ticket findTicket = tickets.find(2);											//Looks for ticket with id 2
		if (findTicket != null) {														//if the ticket was found
			System.out.println("Ticket with id 2 was found:");							//print this
			findTicket.showTicket();													//Display this ticket
			System.out.println();
		} else {																		//If ticket not found
			System.out.println("Ticket with id 2 could not be found");					//Print this
		}
		findTicket = tickets.find(7);													//Looks for ticket with id 7
		if (findTicket != null) {														//if the ticket was found
			System.out.println("Ticket with id 7 was found:");							//print this
			findTicket.showTicket();													//Display this ticket
			System.out.println();
		} else {																		//If ticket not found
			System.out.println("Ticket with id 7 could not be found");					//Print this
		}
			
		
		tickets.removeTicket(3);														//Removes ticket with id 3
		System.out.println();
		tickets.display();																//Displays the current list of tickets
		
		System.out.println();
		tickets.changeType(1, "Security issue");										//Changes the ticket type of the ticket with ID 1 to 'Security issue'
		tickets.changeType(4, "Other");													//Changes the ticket type of the ticket with ID 4 to 'Other'
		tickets.display();																//Displays the current list of tickets
		
	}

}
