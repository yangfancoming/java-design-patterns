
package com.iluwatar.interpreter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Date: 12/14/15 - 12:08 PM
 *
 * @author Jeroen Meulemeester
 */
public class NumberExpressionTest extends ExpressionTest<NumberExpression> {

  /**
   * Create a new set of test entries with the expected result
   *
   * @return The list of parameters used during this test
   */
  @Override
  public Stream<Arguments> expressionProvider() {
    return prepareParameters((f, s) -> f);
  }

  /**
   * Create a new test instance using the given test parameters and expected result
   */
  public NumberExpressionTest() {
    super("number", (f, s) -> f);
  }

  /**
   * Verify if the {@link NumberExpression#NumberExpression(String)} constructor works as expected
   */
  @ParameterizedTest
  @MethodSource("expressionProvider")
  public void testFromString(NumberExpression first) throws Exception {
    final int expectedValue = first.interpret();
    final String testStringValue = String.valueOf(expectedValue);
    final NumberExpression numberExpression = new NumberExpression(testStringValue);
    assertEquals(expectedValue, numberExpression.interpret());
  }

}