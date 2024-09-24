package intellispaces.framework.core.guide.n0;

import intellispaces.framework.core.exception.TraverseException;
import intellispaces.framework.core.guide.MapperOfMoving;
import intellispaces.framework.core.guide.n1.MapperOfMoving1;
import intellispaces.framework.core.guide.n2.MapperOfMoving2;
import intellispaces.framework.core.guide.n3.MapperOfMoving3;
import intellispaces.framework.core.guide.n4.MapperOfMoving4;
import intellispaces.framework.core.guide.n5.MapperOfMoving5;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Mapper related to moving guide without qualifiers.
 *
 * @param <S> source object type.
 * @param <T> target object type.
 */
public interface MapperOfMoving0<S, T> extends
    Guide0<S, T>,
    MapperOfMoving<S, T>,
    MapperOfMoving1<S, T, Void>,
    MapperOfMoving2<S, T, Void, Void>,
    MapperOfMoving3<S, T, Void, Void, Void>,
    MapperOfMoving4<S, T, Void, Void, Void, Void>,
    MapperOfMoving5<S, T, Void, Void, Void, Void, Void>
{
  Function<S, T> asFunction();

  @Override
  default BiFunction<S, Void, T> asBiFunction() {
    return (source, qualifier) -> map(source);
  }

  default T map(S source) throws TraverseException {
    return traverse(source);
  }

  @Override
  default T map(S source, Void qualifier) throws TraverseException {
    return traverse(source);
  }

  @Override
  default T map(S source, Void qualifier1, Void qualifier2) throws TraverseException {
    return traverse(source);
  }

  @Override
  default T map(S source, Void qualifier1, Void qualifier2, Void qualifier3) throws TraverseException {
    return traverse(source);
  }

  @Override
  default T map(S source, Void qualifier1, Void qualifier2, Void qualifier3, Void qualifier4) throws TraverseException {
    return traverse(source);
  }

  @Override
  default T map(S source, Void qualifier1, Void qualifier2, Void qualifier3, Void qualifier4, Void qualifier5) throws TraverseException {
    return traverse(source);
  }

  @Override
  default T traverse(S source, Object... qualifiers) throws TraverseException {
    return traverse(source);
  }

  @Override
  default T traverse(S source, Void qualifier) throws TraverseException {
    return traverse(source);
  }

  @Override
  default T traverse(S source, Void qualifier1, Void qualifier2) throws TraverseException {
    return traverse(source);
  }

  @Override
  default T traverse(S source, Void qualifier1, Void qualifier2, Void qualifier3) throws TraverseException {
    return traverse(source);
  }

  @Override
  default T traverse(S source, Void qualifier1, Void qualifier2, Void qualifier3, Void qualifier4) throws TraverseException {
    return traverse(source);
  }

  @Override
  default T traverse(S source, Void qualifier1, Void qualifier2, Void qualifier3, Void qualifier4, Void qualifier5) throws TraverseException {
    return traverse(source);
  }
}