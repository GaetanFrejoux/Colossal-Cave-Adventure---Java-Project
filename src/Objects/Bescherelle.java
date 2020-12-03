package Objects;

import Characters.*;
import Others.*;

public class Bescherelle extends Obj{


	// ***** CONSTRUCTOR *****

	public Bescherelle(String name) {
		super(name);
	}


	// ***** METHODS *****


	// === COMMANDS ===
	
	@Override
	public void use(Hero h) {
		System.out.println("You cannot use a Bescherelle. STOOPID");
	}
	
	@Override
	public void take(Hero h) throws InterruptedException {
		h.increaseBescherelle();
		super.take(h);
	}
	
	@Override
	public void look() throws InterruptedException {
		Game.printLetterByLetter(Script.BESCH_DESCRIPT);
	}

}
