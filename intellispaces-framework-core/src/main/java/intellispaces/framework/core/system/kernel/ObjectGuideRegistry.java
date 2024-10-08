package intellispaces.framework.core.system.kernel;

import intellispaces.framework.core.guide.Guide;
import intellispaces.framework.core.guide.GuideFunctions;
import intellispaces.framework.core.guide.GuideKind;
import intellispaces.framework.core.object.ObjectFunctions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

class ObjectGuideRegistry {
  private final Map<Class<?>, HandleDescription> handleDescriptions = new WeakHashMap<>();

  public Guide<?, ?> getGuide(GuideKind kind, Class<?> objectHandleClass, String cid) {
    HandleDescription description = handleDescriptions.computeIfAbsent(
        objectHandleClass, this::createHandleDescription);
    return description.getGuide(kind, cid);
  }

  private HandleDescription createHandleDescription(Class<?> objectHandleClass) {
    HandleDescription handleDescription = new HandleDescription(objectHandleClass);
    Class<?> actualObjectHandleClass = ObjectFunctions.defineObjectHandleClass(objectHandleClass);
    if (actualObjectHandleClass == null) {
      return handleDescription;
    }
    List<Guide<?, ?>> objectGuides = GuideFunctions.loadObjectGuides(actualObjectHandleClass);
    objectGuides.forEach(handleDescription::addGuide);
    return handleDescription;
  }

  private final class HandleDescription {
    private final Class<?> objectHandleClass;
    private final Map<String, Guide<?, ?>> mapperGuides = new HashMap<>();
    private final Map<String, Guide<?, ?>> moverGuides = new HashMap<>();
    private final Map<String, Guide<?, ?>> mapperOfMovingGuides = new HashMap<>();

    HandleDescription(Class<?> objectHandleClass) {
      this.objectHandleClass = objectHandleClass;
    }

    Class<?> getObjectHandleClass() {
      return objectHandleClass;
    }

    Guide<?, ?> getGuide(GuideKind kind, String cid) {
      if (kind.isMapper()) {
        return mapperGuides.get(cid);
      } else if (kind.isMover()) {
        return moverGuides.get(cid);
      } else if (kind.isMapperOfMoving()) {
        return mapperOfMovingGuides.get(cid);
      }
      return null;
    }

    void addGuide(Guide<?, ?> guide) {
      if (guide.kind().isMapper()) {
        mapperGuides.put(guide.cid(), guide);
      } else if (guide.kind().isMover()) {
        moverGuides.put(guide.cid(), guide);
      } else if (guide.kind().isMapperOfMoving()) {
        mapperOfMovingGuides.put(guide.cid(), guide);
      }
    }
  }
}
