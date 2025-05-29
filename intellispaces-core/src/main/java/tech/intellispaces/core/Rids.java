package tech.intellispaces.core;

import java.util.UUID;

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

  public static Rid fromBase64(String base64) {
    return new Base64Rid(base64);
  }

  public static Rid undefined() {
    return UNDEFINED_RID;
  }

  private static final Rid UNDEFINED_RID = create(new byte[0]);

  private Rids() {}
}
