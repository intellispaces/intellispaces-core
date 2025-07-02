package tech.intellispaces.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link SpaceFunctions}.
 */
public class SpaceFunctionsTest {

  @Test
  public void testGetSpaceName() {
    assertThat(SpaceFunctions.getSpaceName("a")).isEqualTo("a");
    assertThat(SpaceFunctions.getSpaceName("a.b")).isEqualTo("a");
    assertThat(SpaceFunctions.getSpaceName("a.b.c")).isEqualTo("a");
  }
}
