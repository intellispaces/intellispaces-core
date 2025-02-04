package tech.intellispaces.core.base.traverse;

import tech.intellispaces.core.base.Channel;

/**
 * The traverse transition "THRU channel".
 */
public interface TraverseTransitionThru extends TraverseTransition {

  Channel channel();
}
