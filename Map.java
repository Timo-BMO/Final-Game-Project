
public class Map extends Item {
	public Map(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	
	public void use() {
		boolean worked = false;
		
	
		if(worked == false) {
			Game.print(this.description);
			worked = true;
		}
		else {
			Game.print("This map must be pointing to somewhere...");
		}
}
