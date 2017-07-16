package testJunit;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import junit.framework.AssertionFailedError;
import junit.framework.TestResult;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestJunit3 extends TestResult {
   // add the error
   public synchronized void addError(Test test, Throwable t) {
      super.addError((junit.framework.Test) test, t);
   }

   // add the failure
   public synchronized void addFailure(Test test, AssertionFailedError t) {
      super.addFailure((junit.framework.Test) test, t);
   }
   
   @Test
   public void testAddZ() {
	   assert(true);
      // add any test
   }
   
   @Test
   public void testAddA() {
      // add any test
   }
   
   @Test
   public void testAdd1() {
      // add any test
   }
   
   // Marks that the test run should stop.
   public synchronized void stop() {
      //stop the test here
   }
}
