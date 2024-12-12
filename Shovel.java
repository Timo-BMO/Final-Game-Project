
public class Shovel extends Item {
	public Shovel(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	
	public void use() {
		boolean worked = false;
		for(int i = 0; i < inventory.size(); i++) {
			if(inventory.get(i).getName().equals("shovel")) {
				if(Game.currentRoom.getName().equals("TheConservatory")) {
					Game.print("You used the shovel! You begin digging....");
					Game.print("....");
					Game.print("....");
					Game.print("The movies make it look so easy...");
					Game.print("After grueling hours of digging you've found a golden key! And wouldn't you know it, there's a locked door right beneath it?");
					Game.print("Take the goldenkey?");
					worked = true;
				}
				
				
			}
			
		}
		if(worked) {
			
		}
		else {
			Game.print("This shovel must be useful somewhere...");
		}
	}
	
}
