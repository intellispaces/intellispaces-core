package intellispaces.framework.core.traverse.plan;

import intellispaces.framework.core.exception.TraverseException;

public interface TraverseExecutor {

  Object execute(CallGuide0Plan plan, Object source) throws TraverseException;

  Object execute(CallGuide1Plan plan, Object source, Object qualifier) throws TraverseException;

  Object execute(CallGuide2Plan plan, Object source, Object qualifier1, Object qualifier2) throws TraverseException;

  Object execute(CallGuide3Plan plan, Object source, Object qualifier1, Object qualifier2, Object qualifier3) throws TraverseException;

  Object execute(MapObjectHandleThruChannel0Plan plan, Object source) throws TraverseException;

  Object execute(MapObjectHandleThruChannel1Plan plan, Object source, Object qualifier) throws TraverseException;

  Object execute(MapObjectHandleThruChannel2Plan plan, Object source, Object qualifier1, Object qualifier2) throws TraverseException;

  Object execute(MapObjectHandleThruChannel3Plan plan, Object source, Object qualifier1, Object qualifier2, Object qualifier3) throws TraverseException;

  Object execute(MoveObjectHandleThruChannel0Plan plan, Object source) throws TraverseException;

  Object execute(MoveObjectHandleThruChannel1Plan plan, Object source, Object qualifier) throws TraverseException;

  Object execute(MoveObjectHandleThruChannel2Plan plan, Object source, Object qualifier1, Object qualifier2) throws TraverseException;

  Object execute(MoveObjectHandleThruChannel3Plan plan, Object source, Object qualifier1, Object qualifier2, Object qualifier3) throws TraverseException;

  Object execute(MapOfMovingObjectHandleThruChannel0Plan plan, Object source) throws TraverseException;

  Object execute(MapOfMovingObjectHandleThruChannel1Plan plan, Object source, Object qualifier) throws TraverseException;

  Object execute(MapOfMovingObjectHandleThruChannel2Plan plan, Object source, Object qualifier1, Object qualifier2) throws TraverseException;

  Object execute(MapOfMovingObjectHandleThruChannel3Plan plan, Object source, Object qualifier1, Object qualifier2, Object qualifier3) throws TraverseException;

}