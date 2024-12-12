
public class Table extends Item {
	public Table(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	public void open() {
		boolean worked = false;
		if(Game.currentRoom.getName().equals("TheStudy")) {
			Game.print("You open one of the comparments of the wooden desk...");
			Game.print("You've found a Silver Key!");
			Game.print("You should probably take the silverkey");
			Game.print("Why not test it on that door over there. Try using it.");
			worked = true;
		}
		
		if(worked) {
			
		}
		else {
			Game.print("Maybe this desk is locked...");
		}
	}
}
