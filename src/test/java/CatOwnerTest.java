
import org.example.Cat;
import org.example.CatOwner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CatOwnerTest {
    @Test
    public void testAddAndFindCat() {
        CatOwner owner = new CatOwner();
        Cat tom = new Cat("Tom", 3);

        owner.addCat(tom);
        Cat foundCat = owner.findCatByName("Tom");

        assertNotNull(foundCat);
        assertEquals(tom, foundCat);
    }

    @Test
    public void testRemoveCat() {
        CatOwner owner = new CatOwner();
        owner.addCat(new Cat("Tom", 3));

        assertTrue(owner.removeCat("Tom"));
        assertNull(owner.findCatByName("Tom"));
    }

    @Test
    public void testRemoveNonExistingCat() {
        CatOwner owner = new CatOwner();

        assertFalse(owner.removeCat("NonExisting"));
    }
}
