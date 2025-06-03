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
  public void testSpaceNameOfDomain() {
    assertThat(SpaceFunctions.spaceNameOfDomain("a.b")).isEqualTo("a");
    assertThat(SpaceFunctions.spaceNameOfDomain("a.b.c")).isEqualTo("a");
    assertThatThrownBy(() -> SpaceFunctions.spaceNameOfDomain("a"))
        .isExactlyInstanceOf(UnexpectedException.class)
        .hasMessage("Unable to extract a space name from domain name a");
  }
}
