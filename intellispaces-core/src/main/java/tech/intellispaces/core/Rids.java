package tech.intellispaces.core;

import java.util.UUID;

import tech.intellispaces.commons.data.Base64Functions;
import tech.intellispaces.commons.data.UuidFunctions;
import tech.intellispaces.commons.exception.UnexpectedExceptions;

public class Rids {

  public static Rid create(byte[] bytes, String sting) {
    return new RidImpl(bytes, sting);
  }

  public static Rid create(byte[] bytes) {
    return new RidImpl(bytes);
  }

  public static Rid create(UUID uuid) {
    return new UuidRid(uuid);
  }

  public static Rid create(String string) {
    if (UuidFunctions.isUuid(string)) {
      return fromUuid(string);
    } else if (Base64Functions.isUrlBase64(string)) {
      return fromBase64(string);
    }
    throw UnexpectedExceptions.withMessage("Invalid RID: {0}", string);
  }

  public static Rid fromUuid(String uuid) {
    return create(UUID.fromString(uuid));
  }

  public static Rid fromBase64(String base64) {
    return new Base64Rid(base64);
  }

  public static Rid undefined() {
    return UNDEFINED_RID;
  }

  private static final Rid UNDEFINED_RID = create(new byte[0]);

  private Rids() {}
}
