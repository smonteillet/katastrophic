import name.lemerdy.eric.InvestPlan;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by monteillet on 09/12/2015.
 */
public class InvestPlanTest
{
	 @Test
	 public void testSimpleNumeralInputReturnEmptyString()
	 {
		  assertThat(InvestPlan.input("1").output()).isEmpty();
	 }

	 @Test
	 public void testBigSimpleNumeralInputReturnEmptyString()
	 {
		  assertThat(InvestPlan.input("123456").output()).isEmpty();
	 }

	 @Test(expected = NullPointerException.class)
	 public void testNullInputShallFail()
	 {
		  InvestPlan.input(null).output();
	 }

	 @Test(expected = NoSuchElementException.class)
	 public void testDoubleNumeralInputShallFail()
	 {
		  assertThat(InvestPlan.input("1 2").output()).isEmpty();
	 }

	 @Test(expected = NoSuchElementException.class)
	 public void testTripleNumeralInputShallFail()
	 {
		  assertThat(InvestPlan.input("1 2 3").output()).isEmpty();
	 }

	 @Test
	 public void testDozenNumeralInputReturnCase1Impossible()
	 {
		  assertThat(InvestPlan.input("0 0 1 2 3 4 5 6 7 8 9 10 11 12").output()).isEqualTo("Case #1: IMPOSSIBLE");
	 }

	 @Test
	 public void testDozenNumeralWithNegativeValuesInputReturnCase1Impossible()
	 {
		  assertThat(InvestPlan.input("0 0 1 -2 3 4 5 -6 7 8 -9 10 11 12").output()).isEqualTo("Case #1: IMPOSSIBLE");
	 }

	 @Test
	 public void testDoubleDozenNumeralInputReturnCase1Possible()
	 {
		  assertThat(
				  InvestPlan.input("0 10 1 2 3 4 5 6 7 8 9 10 11 12 10 10 20 30 40 50 60 70 80 90 100 110 120").output()).
				  isEqualTo("Case #1: 1 12 110\n"
						  + "Case #2: 1 12 110");
	 }

	 @Test
	 public void testTripleDozenNumeralInputReturnCase1Possible()
	 {
		  assertThat(
				  InvestPlan.input(
						  "0 10 1 2 3 4 5 6 7 8 9 10 11 12 10 10 20 30 40 50 60 70 80 90 100 110 120 1 5 8 7 4 2 9 4 55 1 2 33 12")
						  .output()).
				  isEqualTo("Case #1: 1 12 110\n"
						  + "Case #2: 1 12 110\n"
						  + "Case #3: 9 11 32");
	 }


}
