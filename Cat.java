
public class Cat extends NPC {
	private int talkCount = 0;

    public Cat() {
        super("cat", "A jet black cat meows politely at you.");
    }

    @Override
    public void talk() {
        switch (talkCount) {
            case 0:
                Game.print("The cat purrs contentedly as you approach it.");
                String[] options1 = {
                    "Kneel down and pet it?",
                    "Look away. We don't have time to give it attention."
                };
                getResponse(options1);
                break;
           
        }
        talkCount++;
    }

    @Override
    public void response(int option) {
        switch (option) {
        
        case 1:
            Game.print("The cat curls around your hand. It's practically a liquid at this point. ");
            Game.print("After giving it the affection it rightfully deserves");
            Game.print("The cat meows gently before approaching the desk and jumping on top of it.");
            Game.print("Seems it wants you to look into the desk. Thanks, your Majesty.");
            break;
        case 2:
        	Game.print("The cat sits and stares at you.");
        	Game.print("Make. Time");
        	Game.print("Before you can make up for the egrious sin you just committed");
        	Game.print("The cat hisses dissapointedly before walking away");
        	Game.print("... We've made a mistake. Restart this save file.");
            break;
        }
    }
}
