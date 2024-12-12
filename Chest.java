

public class Chest extends Item {

	public Chest(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	public void open() {
		boolean worked = false;
		for(int i = 0; i < inventory.size(); i++) {
			if(Game.currentRoom.getName().equals("TheBasement")) {
				if(inventory.get(i).getName().equals("goldenkey")) {
					Game.print("You used the Golden Key you used on the Basement Door....");
					Game.print("The crate opens... revealing....!");
					Game.print("An old diary, and yet another map. Seems to be a good condition, least better than the one you already have.");
					Game.print("...Weird. Apparently there's another room beneath the Study. Might want to take the diary with you.");
					Game.print("Take diary?");
					worked = true;
				}
			}
		}
		if(Game.currentRoom.getName().equals("TheSecretChamber")){
			Game.print("You attempted to open the chest....");
			Game.print("Nothing happened. It's password protected..");
			Game.print("Some sort of... magic spell is needed for this...");
			Game.print("But where would we find something like that here....");
			Game.print("Oh wait the diar-");
			worked = false;
		}
		if(worked) {
			
		}
		else {
			Game.print("How do we go about opening this?");
		
		}
		
	}
}

