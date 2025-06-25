package tech.intellispaces.core;

import org.junit.jupiter.api.Test;

import tech.intellispaces.commons.exception.UnexpectedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests for {@link SpaceFunctions}.
 */
public class SpaceFunctionsTest {

  @Test
  public void testGetSpaceName() {
    assertThat(SpaceFunctions.getSpaceName("a.b")).isEqualTo("a");
    assertThat(SpaceFunctions.getSpaceName("a.b.c")).isEqualTo("a");
    assertThatThrownBy(() -> SpaceFunctions.getSpaceName("a"))
        .isExactlyInstanceOf(UnexpectedException.class)
        .hasMessage("Unable to extract a space name from qualified reflection name 'a'");
  }
}
