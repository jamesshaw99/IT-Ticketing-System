
public class LinkedList {

	public Ticket firstLink;				//the previous element added to the list
	
	LinkedList() {
	
		firstLink = null; 					// sets the firstLink variable to null when the list is created
		
	}
	
	public boolean isEmpty() {
		
		return(firstLink == null); 			//will return true if the LinkedList is empty.
		
	}
	
	public Ticket insert(Ticket ticket) {
		
		Ticket currentTicket = firstLink;
		Ticket previousTicket = firstLink;
		
		
		if (Main.numTickets == 1) {
			
			ticket.next = firstLink;			//sets the next variable in the ticket to the previous item in the list
			firstLink = ticket;						
			
		} else if(Main.numTickets == 2) { 
			
			if (ticket.Priority > firstLink.Priority) {	//If the priority of the new element is greater (lower priority) than the priority of the item already in the list
				
				firstLink.next = ticket;				//put the ticket at the end of the list
				
			} else {
				
				ticket.next = firstLink;			//sets the next variable in the ticket to the previous item in the list
				firstLink = ticket;
				
			}
			
		} else {
			
			while(currentTicket.Priority <= ticket.Priority) {		//While the current ticket has a higher priority or the same as the current ticket being looked at
				
				if(currentTicket.next == null) {					//if we get to the end of the list
					
					currentTicket.next = ticket;					//Puts the ticket at the end of the list
					return null;									//exits the method
					
				} else if(previousTicket == null) {					//If the current ticket being looked at if the first in the queue
					
					ticket.next = currentTicket;					//Put the new ticket at the beginning
					return null;
					
				}else {
					
					previousTicket = currentTicket;
					currentTicket = currentTicket.next;			//moves on to look at the next ticket
					
				}
				
			}
			
			if (previousTicket == currentTicket) {				//If the current ticket and the previous ticket are the same 
				
				ticket.next = currentTicket;					//set the new ticket before the current ticket in the list
				firstLink = ticket;
				
			}else {
			
				previousTicket.next = ticket;					//places the ticket between the previous and current tickets
				ticket.next = currentTicket;
			
			}
			
		}
		return ticket;

	}
	
	public void removefirstTicket() {
		
		if (!isEmpty()) {					//check if the list is empty
			
			firstLink = firstLink.next;		//sets the firstLink variable to the ticket that is next in the list
			
		} else {
			
			System.out.println("Empty List");	//Lets the user know that the list is empty
			
		}
		
		System.out.print("First ticket was removed.");
		
	}
	
	public void display() {
		
		Ticket theTicket = firstLink;
		
		System.out.printf("%-3s %-8s %-10s %-10s %-30s \n", "ID", "Priority", "Creator", "Owner", "Type");
		
		while (theTicket != null) {							//Starts at the last element added to the list and keeps running until it reaches the first element in the list, where firstLink will be null
			
			System.out.printf("%-3d %-8d %-10s %-10s %-30s", theTicket.ID, theTicket.Priority, theTicket.Creator, theTicket.Owner, theTicket.Type);	//Prints all the attributes of the ticket
			theTicket = theTicket.next;						//sets the ticket currently being looked at to the next ticket in the list
			System.out.println();
			
		}
		
	}
	
	public Ticket find(int id) {
		
		Ticket theTicket = firstLink;
		
		if(!isEmpty()) {									//If the list is not empty
			
			while(theTicket.ID != id) {						//While the ID of the ticket being looked at does not equal the desired ticket
				
				if(theTicket.next == null) {				//check if at the end of the list
					
					return null;							//got to the end of the list without finding a match
					
				} else {
					
					theTicket = theTicket.next;				//moves on to the next ticket
					
				}
				
			}
			
		} else {
			
			System.out.println("The list is empty");		//Tells the user know that the list is empty
			
		}
				
		return theTicket;									//returns the ticket if found. theTicket will be set to the ticket being searched for as once the id of the ticket match the id being searched for, the while loop will break.
		
	}
	
	public Ticket removeTicket(int id) {
		
		Ticket currentTicket = firstLink;					//Used to itterate through the list
		Ticket previousTicket = firstLink;
		
		while(currentTicket.ID != id) {						//Checks whether the current ticket being looked at has the desired ID
			
			if(currentTicket.next == null) {				//If the next variable is null -> if we are at the end of the list
				
				return null;								//Ticket was not found in the list, so breaks out of the method
				
			} else {
				
				previousTicket = currentTicket;
				currentTicket = currentTicket.next;			//moves on to look at the next ticket
				
			}
			
		}
		
		if (currentTicket == firstLink) {
			
			firstLink = firstLink.next;						//Ticket has been found so set the link to that ticket to the link to the ticket after -> removes the link to that ticket
			
		} else {
			
			previousTicket.next = currentTicket.next;		//moves on to next ticket 
			
		}
		if (!Main.change) {														//If the change variable is false -> if this method is not being used to change the type
			System.out.println("Ticket with id: " + id + " was removed.");		//Prints confirmation statement
		}
		Main.change = false;													//resets the change variable to false
		return currentTicket;
		
	}
	
	public void changeType(int id, String newType) {
		
		Ticket ticket = Main.tickets.find(id);														//Gets the ID of the tickets and sets it to a temporary variable
		Main.change = true;																			//Sets the value of the change variable to true -> indicates the ticket type has been changed 
		Main.tickets.removeTicket(id);																//Removes the ticket with this ID from the list
		ticket.Type = newType;																		//Changes the type of the ticket to the new type
		ticket.Priority = Ticket.setPriority(newType);												//Changes the priority of the ticket based on the type
		ticket.next = null;																			//Resets the next variable for this ticket as it is no longer in the queue
		Main.tickets.insert(ticket);																//Reinserts the ticket into the list
		System.out.println("Type for ticket with id " + id + " has been changed to " + newType);	//Prints confirmation statement
		System.out.println();
		
	}
	
}
