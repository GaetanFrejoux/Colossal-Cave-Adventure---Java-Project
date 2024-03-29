package objectsTest;

import characters.Hero;
import objects.Key;
import objects.NaziPoster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.Place;

import static org.junit.jupiter.api.Assertions.*;

class NaziPosterTest {

    private NaziPoster np;
    private Hero h;

    @BeforeEach
    void setUp() {
        Place a = new Place("Place", false, true);

        h = new Hero("Test", a);

        np = new NaziPoster("NaziPoster");
        a.addObject(np);
    }

    @Test
    void look() {
        np.look();
    }

    @Test
    void take() {
        np.take(h);
        assertTrue(h.getObjs().containsValue(np));
        assertFalse(h.getPlace().getItems().containsValue(np));
    }

    @Test
    void use() {
        np.use(h);
        assertEquals(Hero.DEFAULT_HP-10, h.getHP());
    }

    @Test
    void testUse() {
        np.use(h, "Test");
    }

    @Test
    void toStringTest() {
        System.out.println(np.toString());
    }
}