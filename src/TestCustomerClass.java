import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestCustomerClass {
   
    @Test
    public void testGetUsername1(){
        Customer customer1 = new Customer();
        customer1.setUsername("Username123");
        assertEquals(customer1.getUsername(), "Username123");
    }

    @Test
    public void testGetUsername2(){
        Customer customer1 = new Customer();
        customer1.setUsername("MinerAir");
        assertEquals(customer1.getUsername(), "MinerAir");
    }

    @Test
    public void testGetMoney1(){
        Customer customer1 = new Customer();
        customer1.setMoney(2001.12);
        assertEquals(customer1.getMoney(),2001.12,1);
    }

    @Test
    public void testGetMoney2(){
        Customer customer1 = new Customer();
        customer1.setMoney(0);
        assertEquals(customer1.getMoney(),0,1);
    }

    @Test
    public void testGetPassword1(){
        Customer customer1 = new Customer();
        customer1.setPassword("Password123");
        assertEquals(customer1.getPassword(), "Password123");
    }

    @Test
    public void testGetPassword2(){
        Customer customer1 = new Customer();
        customer1.setPassword(" ");
        assertEquals(customer1.getPassword(), " ");
    }

    
}
