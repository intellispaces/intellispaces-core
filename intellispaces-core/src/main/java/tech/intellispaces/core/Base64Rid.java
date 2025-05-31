package tech.intellispaces.core;

import tech.intellispaces.commons.data.Base64Functions;

class Base64Rid extends AbstractRid {
  private final byte[] bytes;
  private final String value;

  Base64Rid(String value) {
    this.value = value;
    this.bytes = Base64Functions.convertUrlNoPaddingBase64ToBytes(value);
  }

  @Override
  public byte[] raw() {
    return bytes;
  }

  @Override
  public String toString() {
    return value;
  }
}
