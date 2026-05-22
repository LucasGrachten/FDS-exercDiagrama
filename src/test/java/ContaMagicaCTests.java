import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContaMagicaCTests {

    @Test
    public void CT1() {
        ContaMagica c = new ContaMagica("ct1","U");
        assertTrue(c.deposito(5000));
        assertEquals(5000.0, c.getSaldo(), 1e-9);
        assertEquals("Silver", c.getCategoria());
    }

    @Test
    public void CT2() {
        ContaMagica c = new ContaMagica("ct2","U");
        assertTrue(c.deposito(5000));
        assertTrue(c.saque(1000));
        assertEquals(4000.0, c.getSaldo(), 1e-9);
        assertEquals("Silver", c.getCategoria());
    }

    @Test
    public void CT3() {
        ContaMagica c = new ContaMagica("ct3","U");
        assertTrue(c.deposito(50000));
        assertEquals(50000.0, c.getSaldo(), 1e-9);
        assertEquals("Gold", c.getCategoria());
    }

    @Test
    public void CT4() {
        ContaMagica c = new ContaMagica("ct4","U");
        assertTrue(c.deposito(50000));
        assertTrue(c.deposito(1000));
        assertEquals(50000.0 + 1010.0, c.getSaldo(), 1e-9);
        assertEquals("Gold", c.getCategoria());
    }

    @Test
    public void CT5() {
        ContaMagica c = new ContaMagica("ct5","U");
        assertTrue(c.deposito(50000));
        assertTrue(c.deposito(1000));
        assertTrue(c.saque(1000));
        assertEquals(50010.0, c.getSaldo(), 1e-9);
        assertEquals("Gold", c.getCategoria());
    }

    @Test
    public void CT6() {
        ContaMagica c = new ContaMagica("ct6","U");
        assertTrue(c.deposito(50000));
        assertTrue(c.deposito(1000));
        assertTrue(c.saque(50000));
        assertEquals(1010.0, c.getSaldo(), 1e-9);
        assertEquals("Silver", c.getCategoria());
    }

    @Test
    public void CT7() {
        ContaMagica c = new ContaMagica("ct7","U");
        assertTrue(c.deposito(300000));
        assertEquals(300000.0, c.getSaldo(), 1e-9);
        assertEquals("Gold", c.getCategoria());
    }

    @Test
    public void CT8() {
        ContaMagica c = new ContaMagica("ct8","U");
        assertTrue(c.deposito(300000));
        assertTrue(c.deposito(1000));
        assertEquals(300000.0 + 1010.0, c.getSaldo(), 1e-9);
        assertEquals("Platinum", c.getCategoria());
    }

    @Test
    public void CT9() {
        ContaMagica c = new ContaMagica("ct9","U");
        assertTrue(c.deposito(300000));
        assertTrue(c.deposito(1000));
        assertTrue(c.deposito(1000));
        assertEquals(300000.0 + 1010.0 + 1025.0, c.getSaldo(), 1e-9);
        assertEquals("Platinum", c.getCategoria());
    }

    @Test
    public void CT10() {
        ContaMagica c = new ContaMagica("ct10","U");
        assertTrue(c.deposito(300000));
        assertTrue(c.deposito(1000));
        assertTrue(c.deposito(1000));
        assertTrue(c.saque(200000));
        assertEquals(300000.0 + 1010.0 + 1025.0 - 200000.0, c.getSaldo(), 1e-9);
        assertEquals("Platinum", c.getCategoria());
    }

    @Test
    public void CT11() {
        ContaMagica c = new ContaMagica("ct11","U");
        assertTrue(c.deposito(300000));
        assertTrue(c.deposito(1000));
        assertTrue(c.deposito(1000));
        assertTrue(c.saque(300000));
        assertEquals(300000.0 + 1010.0 + 1025.0 - 300000.0, c.getSaldo(), 1e-9);
        assertEquals("Gold", c.getCategoria());
    }

    @Test
    public void CT12() {
        ContaMagica c = new ContaMagica("ct12","U");
        assertTrue(c.deposito(300000));
        assertTrue(c.deposito(1000));
        assertTrue(c.deposito(1000));
        assertTrue(c.saque(300000));
        assertTrue(c.saque(1000));
        assertEquals(300000.0 + 1010.0 + 1025.0 - 300000.0 - 1000.0, c.getSaldo(), 1e-9);
        assertEquals("Silver", c.getCategoria());
    }
}
