package tech.intellispaces.core.traverse;

import tech.intellispaces.core.Channel;

/**
 * The traverse transition "THRU channel".
 */
public interface TraverseTransitionThru extends TraverseTransition {

  Channel channel();
}
