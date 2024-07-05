package tech.intellispaces.framework.core.guide.n0;

import tech.intellispaces.framework.commons.exception.UnexpectedViolationException;
import tech.intellispaces.framework.core.exception.TraverseException;
import tech.intellispaces.framework.core.guide.GuideLogger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Attached to object handle mover guide.<p/>
 *
 * Attached guide can be used exclusively with this object handle only.
 *
 * @param <S> source object handle type.
 * @param <B> backward object handle type.
 */
public class AttachedMover0<S, B> implements BasicMover0<S, B> {
  private final Class<S> objectHandleClass;
  private final String tid;
  private final Method moverMethod;

  public AttachedMover0(String tid, Class<S> objectHandleClass, Method moverMethod) {
    if (moverMethod.getParameterCount() != 0) {
      throw UnexpectedViolationException.withMessage("Attached guide should not have parameters");
    }
    this.tid = tid;
    this.objectHandleClass = objectHandleClass;
    this.moverMethod = moverMethod;
  }

  @Override
  public String tid() {
    return tid;
  }

  @Override
  @SuppressWarnings("unchecked")
  public B move(S source) throws TraverseException {
    try {
      GuideLogger.logCallGuide(moverMethod);
      return (B) moverMethod.invoke(source);
    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
      throw TraverseException.withCauseAndMessage(e, "Failed to invoke mover method {} of object handle {}",
          moverMethod.getName(), objectHandleClass.getCanonicalName());
    }
  }
}