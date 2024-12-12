

public class World extends Game {
	public static Room buildWorld() {
	     
		Room Study = new Room("TheStudy");
		Key SilverKey = new Key("silverkey", "A silver key. Used to open the door to the Library");
		Table Desk = new Table("desk", "A wooden desk. Try opening it.");
		Study.addItem(SilverKey);
		Study.addItem(Desk);
		NPC StudyCat = new Cat();
		Study.addNPC(StudyCat);
		
		
		Room Library  = new Room("TheLibrary");
		Library.setLock(true);
		Study.addExit(Library, 'n');
		Library.addExit(Study, 's');
		NPC Ghost = new Ghost();
		Library.addNPC(Ghost);
		Item LibraryMap = new Item("map", "It's a map of the building. The ink is barely legably, but there seems to be some sort of passage to the west of here.");
		Library.addItem(LibraryMap);
		Room Conservatory = new Room("TheConservatory");
		Shovel GardenTool = new Shovel("shovel", "A wooden shovel worn with time. It would take a while to make even a dent in the dirt with this. Take it?");
		Key GoldenKey = new Key("goldenkey", "A golden key. Should probably unlock something?");
		Library.addExit(Conservatory, 'w');
		Conservatory.addExit(Library, 'e');
		Conservatory.addItem(GardenTool);
		Conservatory.addItem(GoldenKey);
		Room Basement = new Room("TheBasement");
		Basement.setLock(true);
		Conservatory.addExit(Basement, 'd');
		Basement.addExit(Conservatory, 'u');
		Chest Trunk = new Chest("crate", "A crate that's been collecting dust as centuries past.");
		Book Diary = new Book("diary", "An old notebook of a child who supposedly lived here. They used to play hide and seek, frequently it seems. According to them, the best hiding spot is the basement.");
		Basement.addItem(Diary);
		Basement.addItem(Trunk);
		Room SecretChamber = new Room("TheSecretChamber");
		SecretChamber.setLock(true);
		Study.addExit(SecretChamber, 'd');
		SecretChamber.addExit(Study, 'u');
		Chest GoldChest = new Chest("chest", "A golden chest adorned with all sorts of engravings.");
		//Safe safe = new Safe("Safe", "It's an iron cold safe...");
		//SecretChamber.addItem(safe);
		
		
		
		
		return Study;
	}
	

}
	