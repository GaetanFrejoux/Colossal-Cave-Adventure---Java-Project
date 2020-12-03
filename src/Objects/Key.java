package Objects;

import Characters.*;
import Others.*;

public class Key extends Obj{

    // ***** CONSTRUCTOR *****

    public Key(String name) {
        super(name);
    }

    // ***** METHODS *****


    // === COMMANDS ===

    @Override
    public void use(Hero h) {
        System.out.println("What exactly are you trying to do with this key ?");
    }

    @Override
    public void take(Hero h) {
        h.increaseKey();
        h.getObjs().put(this.NAME, this);
    }

    @Override
    public void look() throws InterruptedException {
        Game.printLetterByLetter(Script.KEY_DESCRIPT);
    }

}