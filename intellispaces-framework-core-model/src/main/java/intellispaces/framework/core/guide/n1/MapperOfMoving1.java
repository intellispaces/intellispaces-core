package intellispaces.framework.core.guide.n1;

import intellispaces.common.base.function.QuadFunction;
import intellispaces.common.base.function.TriFunction;
import intellispaces.framework.core.exception.TraverseException;
import intellispaces.framework.core.guide.MapperOfMoving;
import intellispaces.framework.core.guide.n2.MapperOfMoving2;
import intellispaces.framework.core.guide.n3.MapperOfMoving3;
import intellispaces.framework.core.guide.n4.MapperOfMoving4;
import intellispaces.framework.core.guide.n5.MapperOfMoving5;

import java.util.function.BiFunction;

/**
 * Mapper related to moving guide with one qualifier.
 *
 * @param <S> source object type.
 * @param <T> target object type.
 * @param <Q> qualifier type.
 */
public interface MapperOfMoving1<S, T, Q> extends
    Guide1<S, T, Q>,
    MapperOfMoving<S, T>,
    MapperOfMoving2<S, T, Q, Void>,
    MapperOfMoving3<S, T, Q, Void, Void>,
    MapperOfMoving4<S, T, Q, Void, Void, Void>,
    MapperOfMoving5<S, T, Q, Void, Void, Void, Void>
{
  BiFunction<S, Q, T> asBiFunction();

  @Override
  default TriFunction<S, Q, Void, T> asTriFunction() {
    return (source, qualifier1, qualifier2) -> map(source, qualifier1);
  }

  @Override
  default QuadFunction<S, Q, Void, Void, T> asQuadFunction() {
    return (source, qualifier1, qualifier2, qualifier3) -> map(source, qualifier1);
  }

  default T map(S source, Q qualifier) throws TraverseException {
    return traverse(source, qualifier);
  }

  @Override
  default T map(S source, Q qualifier1, Void qualifier2) throws TraverseException {
    return traverse(source, qualifier1);
  }

  @Override
  default T map(S source, Q qualifier1, Void qualifier2, Void qualifier3) throws TraverseException {
    return traverse(source, qualifier1);
  }

  @Override
  default T map(S source, Q qualifier1, Void qualifier2, Void qualifier3, Void qualifier4) throws TraverseException {
    return traverse(source, qualifier1);
  }

  @Override
  default T map(S source, Q qualifier1, Void qualifier2, Void qualifier3, Void qualifier4, Void qualifier5) throws TraverseException {
    return traverse(source, qualifier1);
  }

  @Override
  @SuppressWarnings("unchecked")
  default T traverse(S source, Object... qualifiers) throws TraverseException {
    return traverse(source, (Q) qualifiers[0]);
  }

  @Override
  default T traverse(S source, Q qualifier1, Void qualifier2) throws TraverseException {
    return traverse(source, qualifier1);
  }

  @Override
  default T traverse(S source, Q qualifier1, Void qualifier2, Void qualifier3) throws TraverseException {
    return traverse(source, qualifier1);
  }

  @Override
  default T traverse(S source, Q qualifier1, Void qualifier2, Void qualifier3, Void qualifier4) throws TraverseException {
    return traverse(source, qualifier1);
  }

  @Override
  default T traverse(S source, Q qualifier1, Void qualifier2, Void qualifier3, Void qualifier4, Void qualifier5) throws TraverseException {
    return traverse(source, qualifier1);
  }
}