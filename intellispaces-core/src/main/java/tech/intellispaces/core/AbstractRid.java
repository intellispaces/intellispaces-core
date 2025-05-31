package tech.intellispaces.core;

import java.util.Arrays;
import java.util.Objects;

abstract class AbstractRid implements Rid {

  @Override
  public boolean equals(Object other) {
    if (other == null || !Rid.class.isAssignableFrom(other.getClass())) {
      return false;
    }
    Rid otherRid = (Rid) other;
    return Objects.deepEquals(this.raw(), otherRid.raw());
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(this.raw());
  }
}
