
public class Book extends Item {
	private static final long serialVersionUID = 1L;
	
	public Book(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	public void open() {
		boolean worked = false;
		for(int i = 0; i < inventory.size(); i++) {
			if(inventory.get(i).getName().equals("diary")) {
				if(Game.currentRoom.getName().equals("TheStudy")) {
					Game.print("You open the old diary. After flipping through the pages you come across what you believe to be the code to the secret passage.");
					Game.print("You say : ");
					Game.print("O P E N            S E S A M E ");
					Game.print("The secret passage to the secret Chamber has been unlocked. Head down.");
					Game.currentRoom.getExit('d').setLock(false);
					worked = true;
				}
				
				if(Game.currentRoom.getName().equals("TheSecretChamber")) {
					Game.print("You open the old diary. After flipping through the pages you come across what you believe to be the code to the chest.");
					Game.print("You say : ");
					Game.print("O P E N            S E S A M E ");
					Game.print("The chest has been unlocked! Within it you find mountains of gold coins, and a key I suspect is our ticket out of there!");
					Game.print("Thanks for playing!");
					
				}
				
			}
			
		}
		if(worked) {
			
		}
		else {
			Game.print("This book must be useful somewhere...");
		}
	

	}
}
