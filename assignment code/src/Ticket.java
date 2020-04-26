

public class Ticket {

	public int ID;			//Holds the ID of the ticket
	public String Creator;	//Holds the name of the creator of the ticket
	public String Owner;	//Holds the name of the owner of the ticket
	public int Priority;	//Holds the priority of the ticket
	public String Type;		//Holds the type of issue
	
	public Ticket next = null; 	//Holds the ticket of the next link in the linkedList -> set to null until it is connected to other tickets

	public Ticket(String creator, String owner, String type) {
		
		// Sets the priority based on the ticket type
		this.Priority = setPriority(type);
		
		Main.numTickets++;			//Increments the numTickets variable by 1 to indicate that a new ticket has been created
		this.ID = Main.numTickets;	//Assigns the ID to the current value in numTickets which is incremented when a new ticket is made, so this number is always unique
		
		//Assigns the given values for creator, owner and type to this specific tickets attributes
		this.Creator = creator;
		this.Owner = owner;
		this.Type = type;
		
		Main.tickets.insert(this);		//Inserts this ticket into the list
		
	}
	
	public static int setPriority (String type) {					//Sets the priority of the ticket based on the type 
		if(type.equals("Security issue")) {
			return 1;
		} else if (type.equals("Network issue")) {
			return 2;
		} else if (type.equals("Software/app installation")) {
			return 3;
		} else if (type.equals("New computer configuration")){
			return 4;
		} else {
			return 5;
		}
	}
	
	public void showTicket() {
		
		System.out.printf("%-3d %-8d %-10s %-10s %-30s", this.ID, this.Priority, this.Creator, this.Owner, this.Type);	//used to print an individual ticket
		
	}
	
}
