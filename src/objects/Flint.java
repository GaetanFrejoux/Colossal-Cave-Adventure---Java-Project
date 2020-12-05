package objects;

import characters.*;
import others.*;

public class Flint extends Obj {
	
	
	// ***** CONSTRUCTOR *****
	
	public Flint(String name) {
		super(name);
	}
	
	
	// ***** METHODS *****
	
	
	// === COMMANDS ===
	
	
	@Override
	public void look() {
		Game.printLetterByLetter(Script.FLINT_DESCRIPT, Script.DEFAULT_NARRATOR);
	}
	
	@Override
	public void use(Hero h) {
		Game.printLetterByLetter("Use this item with something else...", Script.DEFAULT_NARRATOR);
	}
	
	@Override
	public void use(Hero h,String s) {
		s = s.toLowerCase();
		if(s.equals(Script.DEFAULT_STICK_NAME)){
			if(h.getPlace().getName().equals("mortuary")){
				if(h.getObjs().containsKey(s)){
					h.getObjs().remove(s);
					h.getObjs().remove(this.NAME);
					FiredStick firedStick = new FiredStick(Script.DEFAULT_FIREDSTICK_NAME);
					h.getObjs().put(firedStick.NAME,firedStick);
					Game.printLetterByLetter("With your knowledge of caveman, you managed to create fire with your flint and your stick a firedstick." +
							"\nMaybe he is useful in this room\n", Script.DEFAULT_NARRATOR);
				}
			}
			else{
				Game.printLetterByLetter("Maybe you should use it in the right Room...\n", Script.DEFAULT_NARRATOR);
			}
		}
		else{
			Game.printLetterByLetter("You cannot combine those object together\n", Script.DEFAULT_NARRATOR);
		}
	}

}
