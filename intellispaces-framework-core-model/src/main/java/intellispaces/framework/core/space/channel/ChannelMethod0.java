package intellispaces.framework.core.space.channel;

import java.util.function.Function;

@FunctionalInterface
public interface ChannelMethod0<S, R> extends Function<S, R> {

  R apply(S source);
}