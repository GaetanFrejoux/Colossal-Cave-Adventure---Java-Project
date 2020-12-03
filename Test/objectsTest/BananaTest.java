package objectsTest;

import characters.Hero;
import characters.Monkey;
import objects.Banana;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Place;

import static org.junit.jupiter.api.Assertions.*;

class BananaTest {

    private Banana b;
    private Place B;
    private Hero h;

    @BeforeEach
    void setUp() {
        Place a = new Place("Place", false, true);
        B = new Place("Experiments room", false, true);

        b = new Banana("Banana");
        a.addObject(b);

        h = new Hero("Test", a);
    }

    @Test
    void look() {
        // Banana launch look alone
        b.look();

        // Hero launch banana look
        h.lookAt("Banana");
    }

    @Test
    void use() {
        // case in Another room than Experiments room
        b.use(h);
        b.use(h);
        b.use(h);

        // case with monkey in Experiments room
        h.take("Banana");
        assertTrue(h.getObjs().containsValue(b));
        assertFalse(h.getPlace().getItems().containsValue(b));
        h.setPlace(B);


        Monkey m = new Monkey("Monkey", 0,
                "Monkey Script noBesch", "Monkey Script Besch",
                "Script Hungry Diag", "Monkey Description");
        B.addAnimal(m);

        h.getObjs().get("Banana").use(h);

        assertFalse(m.getHungry());
    }
}