package intellispaces.framework.core.guide.n1;

import intellispaces.framework.core.exception.TraverseException;
import intellispaces.framework.core.traverse.DeclarativePlan;
import intellispaces.framework.core.traverse.TraverseExecutor;

/**
 * One-parametrized automatic mapper of moving.
 *
 * <p>Automatic guide builds the traverse plan itself.
 *
 * @param <S> source object handle type.
 * @param <T> target object handle type.
 * @param <Q> qualifier handle type.
 */
public class AutoMapperOfMoving1<S, T, Q> implements AbstractMapperOfMoving1<S, T, Q> {
  private final String tid;
  private final TraverseExecutor traverseExecutor;
  private final DeclarativePlan declarativeTaskPlan;

  public AutoMapperOfMoving1(String tid, DeclarativePlan declarativeTaskPlan, TraverseExecutor traverseExecutor) {
    this.tid = tid;
    this.declarativeTaskPlan = declarativeTaskPlan;
    this.traverseExecutor = traverseExecutor;
  }

  @Override
  public String tid() {
    return tid;
  }

  @Override
  @SuppressWarnings("unchecked")
  public T traverse(S source, Q qualifier) throws TraverseException {
    return (T) declarativeTaskPlan.execute(source, qualifier, traverseExecutor);
  }
}