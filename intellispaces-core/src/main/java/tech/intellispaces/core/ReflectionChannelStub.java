package tech.intellispaces.core;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import tech.intellispaces.commons.exception.UnexpectedExceptions;

class ReflectionChannelStub implements ReflectionChannelPoint {

  static final ReflectionChannelStub INSTANCE = new ReflectionChannelStub();

  private ReflectionChannelStub() {}

  @Override
  public @Nullable String localAlias() {
    throw createInvokeStubMethodException();
  }

  @Override
  public ReflectionDomain sourceDomain() {
    throw createInvokeStubMethodException();
  }

  @Override
  public ReflectionDomain targetDomain() {
    throw createInvokeStubMethodException();
  }

  @Override
  public ReflectionDomain domain() {
    throw createInvokeStubMethodException();
  }

  @Override
  public @Nullable String domainAlias() {
    throw createInvokeStubMethodException();
  }

  @Override
  public List<ReflectionPoint> primaryPoints() {
    throw createInvokeStubMethodException();
  }

  @Override
  public Projection projectionThru(Rid cid) {
    throw createInvokeStubMethodException();
  }

  @Override
  public Projection projectionThru(String channelAlias) {
    throw createInvokeStubMethodException();
  }

  @Override
  public Projection projectionTo(String domainAlias) {
    throw createInvokeStubMethodException();
  }

  @Override
  public Projection projectionTo(ReflectionDomain domain) {
    throw createInvokeStubMethodException();
  }

  @Override
  public List<Reflection> relatedReflections() {
    throw createInvokeStubMethodException();
  }

  @Override
  public boolean canBeRepresentedAsPoint() {
    throw createInvokeStubMethodException();
  }

  @Override
  public boolean canBeRepresentedAsDomain() {
    throw createInvokeStubMethodException();
  }

  @Override
  public boolean canBeRepresentedAsChannel() {
    throw createInvokeStubMethodException();
  }

  @Override
  public boolean canBeRepresentedAsSpace() {
    throw createInvokeStubMethodException();
  }

  @Override
  public ReflectionPoint asPoint() {
    throw createInvokeStubMethodException();
  }

  @Override
  public ReflectionDomain asDomain() {
    throw createInvokeStubMethodException();
  }

  @Override
  public ReflectionChannel asChannel() {
    throw createInvokeStubMethodException();
  }

  @Override
  public ReflectionSpace asSpace() {
    throw createInvokeStubMethodException();
  }

  @Override
  public @Nullable Rid rid() {
    throw createInvokeStubMethodException();
  }

  @Override
  public @Nullable String alias() {
    throw createInvokeStubMethodException();
  }

  private RuntimeException createInvokeStubMethodException() {
    return UnexpectedExceptions.withMessage("Attempt to invoke a method of the reflection stub");
  }
}
