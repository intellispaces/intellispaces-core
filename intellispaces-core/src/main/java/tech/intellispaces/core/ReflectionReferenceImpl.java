package tech.intellispaces.core;

import org.jetbrains.annotations.Nullable;

class ReflectionReferenceImpl implements ReflectionReference {
  private final @Nullable Rid rid;
  private final @Nullable String reflectionName;

  ReflectionReferenceImpl(@Nullable Rid rid, @Nullable String reflectionName) {
    this.rid = rid;
    this.reflectionName = reflectionName;
  }

  @Override
  public @Nullable Rid rid() {
    return rid;
  }

  @Override
  public @Nullable String alias() {
    return reflectionName;
  }
}
