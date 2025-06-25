package tech.intellispaces.core.id;

import java.util.HexFormat;

import tech.intellispaces.commons.collection.ArraysFunctions;

public interface IdentifierFunctions {

  static byte[] parseHexString(String id) {
    if (id == null) {
      return null;
    }
    return HexFormat.of().parseHex(id.replaceAll("-", ""));
  }

  static String convertToHexString(byte[] id) {
    String string = HexFormat.of().formatHex(id);
    if (string.length() == 32) {
      return string.substring(0, 8) + "-" +
          string.substring(8, 12) + "-" +
          string.substring(12, 16) + "-" +
          string.substring(16, 20) + "-" +
          string.substring(20);
    }
    return string;
  }

  static boolean equals(byte[] id1, byte[] id2) {
    return ArraysFunctions.isEqualArrays(id1, id2);
  }
}
