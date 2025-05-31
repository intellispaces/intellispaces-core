package tech.intellispaces.core;

import java.util.Arrays;

class RidImpl extends AbstractRid {
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
}
