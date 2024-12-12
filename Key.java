
public class Key extends Item {

	private static final long serialVersionUID = 1L;

	public Key(String name, String description) {
		super(name, description);
		
	}

	public void use() {
		boolean worked = false;
		for(int i = 0; i < inventory.size(); i++) {
			if(inventory.get(i).getName().equals("silverkey")) {
				if(Game.currentRoom.getName().equals("TheStudy")) {
					if(Game.currentRoom.getExit('n').getName().equals("TheLibrary")) {
						Game.print("You attempted to use the Silver Key.... The door to the Library was unlocked!");
						Game.currentRoom.getExit('n').setLock(false);
						worked = true;
					}
				}
				
				
			}
			if(inventory.get(i).getName().equals("goldenkey")) {
				if(Game.currentRoom.getName().equals("TheConservatory")) {
					if(Game.currentRoom.getExit('d').getName().equals("TheBasement")) {
						Game.print("You attempted to use the Golden Key.... The door to the Basement was unlocked!");
						Game.print("Let's head down!");
						Game.currentRoom.getExit('d').setLock(false);
						worked = true;
					}
				}
			}
		}
		if(worked) {
			
		}
		else {
			Game.print("This key must be useful somewhere...");
		}
		
	} 
	
	

}