package tech.intellispaces.core;

import java.util.List;

public interface FuzzyProjection extends Projection {

  LikelyProjection mostLikelyProjection();

  List<LikelyProjection> likelyProjection();

  Reflection collectiveTarget();
}
