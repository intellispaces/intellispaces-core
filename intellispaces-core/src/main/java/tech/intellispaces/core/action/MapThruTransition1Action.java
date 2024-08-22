package tech.intellispaces.core.action;

import tech.intellispaces.actions.AbstractAction2;
import tech.intellispaces.core.guide.n1.Mapper1;
import tech.intellispaces.core.space.transition.Transition1;
import tech.intellispaces.core.system.Modules;
import tech.intellispaces.javastatements.type.Type;

class MapThruTransition1Action<T, S, Q> extends AbstractAction2<T, S, Q> {
  private final Type<S> sourceType;
  private final Class<? extends Transition1> transitionClass;
  private final Mapper1<S, T, Q> autoMover;

  MapThruTransition1Action(
      Type<S> sourceType,
      Class<? extends Transition1> transitionClass
  ) {
    this.sourceType = sourceType;
    this.transitionClass = transitionClass;
    this.autoMover = Modules.current().autoMapperThruTransition1(sourceType, transitionClass);
  }

  @Override
  public T execute(S source, Q qualifier) {
    return autoMover.map(source, qualifier);
  }
}