package samples;

import intellispaces.framework.core.annotation.Module;
import intellispaces.framework.core.annotation.Projection;
import intellispaces.framework.core.annotation.validator.Sample;

import java.io.File;

@Sample
@Module
public class ModuleWithProjectionAndFileParameter {

  @Projection
  public String projection(File value) {
    return "";
  }
}
