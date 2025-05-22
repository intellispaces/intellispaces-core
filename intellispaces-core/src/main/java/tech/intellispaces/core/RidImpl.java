package tech.intellispaces.core;

import java.util.Arrays;
import java.util.Objects;

class RidImpl implements Rid {
  private final byte[] bytes;
  private final String string;

  RidImpl(byte[] bytes) {
    this.bytes = bytes;
    this.string = null;
  }

  RidImpl(byte[] bytes, String string) {
    this.bytes = bytes;
    this.string = string;
  }

  @Override
  public byte[] raw() {
    return bytes;
  }

  @Override
  public String toString() {
    return string != null ? string : Arrays.toString(bytes);
  }

  @Override
  public boolean equals(Object other) {
    if (other == null || !Rid.class.isAssignableFrom(other.getClass())) {
      return false;
    }
    Rid rid = (Rid) other;
    return Objects.deepEquals(bytes, rid.raw());
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(bytes);
  }
}
