package testJunit;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestJunit1 {
   @Test
   public void testAdd() {
	   System.out.println("testAdd");
      //test data
      int num = 5;
      String temp = null;
      String str = "Junit is working fine";

      //check for equality
      assertEquals("Junit is working fine", str);
      
      //check for false condition
      assertFalse(num > 6);

      //check for not null value
      assertNotNull(str);

      //check for not null value
      assertNull(temp);
   }
}