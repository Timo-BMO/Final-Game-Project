
import java.util.HashMap;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Game {
	public static HashMap<String, String> roomDescriptions = new HashMap<>();
	public static HashMap<String, Room> roomMap = new HashMap<String, Room>(); // Static HashMap to hold all rooms
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	public static Room currentRoom = World.buildWorld();
	public static Scanner scan = new Scanner(System.in); // Public static Scanner for user input
	public static GameGUI Display = new GameGUI();

	public static void print(Object obj) {
		Display.displayArea.append(obj.toString() + "\n");
		
	}
	
	public static Room getRoom() {
		return currentRoom;
	}
	
	

	
	public static void main(String[] args) {
		loadRoomDescriptions("C:\\Users\\aoski\\eclipse-workspace\\FinalGame\\src\\roomDescriptions");
		
		runGame();
	}
	
	public static void loadRoomDescriptions(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String roomName = null;
            StringBuilder roomDescription = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                if (line.equals("#")) {
                    if (roomName != null) {
                        roomDescriptions.put(roomName, roomDescription.toString().trim());
                    }
                    roomName = null;
                    roomDescription = new StringBuilder();
                } else if (roomName == null) {
                    roomName = line.trim();
                } else {
                    roomDescription.append(line).append(" ");
                }
            }

            // Add the last room if file doesn't end with "#"
            if (roomName != null) {
                roomDescriptions.put(roomName, roomDescription.toString().trim());
            }

        } catch (IOException e) {
            System.out.println("Error reading room descriptions: " + e.getMessage());
        }
    }
	
	public Item returnObject(String itemName) {
		Item foundObject = null;
		for(int i = 0; i < inventory.size(); i++) {
			if(inventory.get(i).getName().equals(itemName)){
				foundObject = inventory.get(i);
			}
			
		}
		
		return foundObject;
	}
	
	public static void runGame() {
		
		
		String command; // player's command
		do {
			Game.print(currentRoom);
			Game.print("Where do you want to go? ");
			command = scan.nextLine();
			processCommand(command);
			
		} while(!command.equals("x"));
		
		scan.close();
	}
	
	
	public static void processCommand(String command) {
		String[] readcommand = command.split("[,\\.\\s]");
		
		
		switch(readcommand[0]) {
		case "e":
			currentRoom = currentRoom.getExit('e');
			Game.print(currentRoom);
			break;

		case "w":
			currentRoom = currentRoom.getExit('w');
			Game.print(currentRoom);
			break;
		case "n":
			if(currentRoom.getExit('n').getLock()) {
				Game.print("This Room is locked. You'll need a key of some sort");
				
				Game.print(currentRoom);
			}
			else {
				currentRoom = currentRoom.getExit('n');
				Game.print(currentRoom);
			}
			
			break;
		case "s":
			currentRoom = currentRoom.getExit('s');
			Game.print(currentRoom);
			break;
		case "u":
			currentRoom = currentRoom.getExit('u');
			Game.print(currentRoom);
			break;
			
		case "d":
			currentRoom = currentRoom.getExit(command.charAt(0));
			Game.print(currentRoom);
			break;
		case "x":
			Game.print("Thanks for walking through my game!");
			break;
		case "take":
			if(currentRoom.getItem(readcommand[1]) != null) {
				Game.print("You have taken " + currentRoom.getItem(readcommand[1]).getName());
				inventory.add(currentRoom.getItem(readcommand[1]));
				currentRoom.removeItem(readcommand[1]);
			}
			else{
				Game.print("That item is not in this room.");
			}
		break;
		
		case "use":
			if(currentRoom.getItem(readcommand[1]) != null) {
				Game.print("You've attempted to use the " + currentRoom.getItem(readcommand[1]).getName());
				currentRoom.getItem(readcommand[1]).use();
			}
			else if (inventory.size() > 0){
				for(int i = 0; i < inventory.size(); i++) {
					if(inventory.get(i).getName().equals(readcommand[1])) {
						Game.print("You've attempted to use the " + inventory.get(i).getName());
						inventory.get(i).use();
					}
					
				}
				
			}
			else{
				Game.print("That item is not in this room.");
			}
		break;
		
		case "open":
			if(currentRoom.getItem(readcommand[1]) != null) {
				Game.print("You've attempted to use the " + currentRoom.getItem(readcommand[1]).getName());
				currentRoom.getItem(readcommand[1]).open();
			}
			else if (inventory.size() > 0){
				for(int i = 0; i < inventory.size(); i++) {
					if(inventory.get(i).getName().equals(readcommand[1])) {
						Game.print("You've attempted to use the " + inventory.get(i).getName());
						inventory.get(i).open();
					}
					
				}
				
			}
			else{
				Game.print("That item is not in this room.");
			}
		break;
		case "look":
			if(currentRoom.getItem(readcommand[1]) != null) {
				Game.print(currentRoom.getItem(readcommand[1]).getDesc());
			}
			else if (inventory.size() > 0){
				for(int i = 0; i < inventory.size(); i++) {
					if(inventory.get(i).getName().equals(readcommand[1])) {
						Game.print(inventory.get(i).getDesc());
					}
					
				}
				
			}
			else {
				Game.print("No such item exists");
			}
			
			break;
			
		case "i":
			if(inventory.size() == 0) {
				Game.print("You're carrying nothing");
			}
			else {
				Game.print(inventory);
			}
			break;
		case "save":
			saveGame("savegame.dat");
			break;
		case "load":
			loadGame("savegame.dat");
			break;
		case "talk":
            if(currentRoom.getNPC(readcommand[1]) != null) {
                currentRoom.getNPC(readcommand[1]).talk();
            } else {
            	Game.print("There is no one by that name here.");
            }
            break;
		default:
			Game.print("I don't know what that means.");
		}
	}

	public static void saveGame(String fileName) {
	    File f = new File(fileName);
	    try (FileOutputStream fos = new FileOutputStream(f);
	         ObjectOutputStream stream = new ObjectOutputStream(fos)) {
	        
	    	if (getRoom() == null) {
	    		Game.print("Warning: Current room is null before saving.");
	    	    return;
	    	}
	        // Save game state objects
	        stream.writeObject(currentRoom);
	        
	        stream.writeObject(inventory);
	        stream.writeObject(roomMap);
	        
	        Game.print("Current Room: " + currentRoom);
	        Game.print("Inventory: " + inventory);
	        
	        Game.print("Game saved successfully to " + fileName);
	    } catch (FileNotFoundException e) {
	    	Game.print("File " + fileName + " not found.");
	    } catch (IOException ex) {
	    	Game.print("Failed to save game: " + ex.getMessage());
	    }
	}
	

	
	public static void loadGame(String fileName) {
	    File f = new File(fileName);
	    try (FileInputStream fis = new FileInputStream(f);
	         ObjectInputStream stream = new ObjectInputStream(fis)) {
	        
	        // Load game state objects
	    	Room loadedRoom = (Room) stream.readObject();
	        inventory = (ArrayList<Item>) stream.readObject();
	        roomMap = (HashMap<String, Room>) stream.readObject();
	        
	    	currentRoom = loadedRoom;
	       
	    	Game.print("Game loaded successfully from " + fileName);
	    	Game.print("Current Room: " + currentRoom);
	    	Game.print("Inventory: " + inventory);
	    } catch (FileNotFoundException e) {
	    	Game.print("File " + fileName + " not found.");
	    } catch (IOException ex) {
	    	Game.print("Failed to load game: " + ex.getMessage());
	    } catch (ClassNotFoundException ex) {
	    	Game.print("Failed to load game: Object type mismatch.");
	    }
	}
	
}



