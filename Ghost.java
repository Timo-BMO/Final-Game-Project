
public class Ghost extends NPC {
	
	private int talkCount = 0;
	 public Ghost() {
	        super("ghost", "A bioluminscient phantom fades in and out of existance.");
	    }

	    @Override
	    public void talk() {
	        switch (talkCount) {
	            case 0:
	            	say("Welcome to the hall of knowledge. What truths do you seek?");
	                Game.print("It's a Ghost Librarian. They seem pretty alright besides the whole... dead thing?");
	                String[] options1 = {
	                    "Treasure",
	                    "More Treasure"
	                };
	                getResponse(options1);
	                break;
	           
	        }
	        
	    }

	    @Override
	    public void response(int option) {
	        switch (option) {
	        
	        case 1:
	            Game.print("The ghost sighs...");
	            say("... Not another one.");
	            Game.print("Seems it has no other words to spare on a fool. Maybe we should've asked for more Treasure.");
	            break;
	        case 2:
	        	Game.print("The ghost sighs...");
	            say("... Not another one.");
	            Game.print("Seems it has no other words to spare on a fool.");
	            Game.print("... Who needs him anyway. You got me!");
	            Game.print("Which is why I felt the need to point out that map behind the bookshelf. Try looking at it");
	            break;
	        }
	    }
	}