package samples;

import intellispaces.framework.core.annotation.Module;
import intellispaces.framework.core.annotation.Startup;
import intellispaces.framework.core.annotation.validator.Sample;

import java.io.File;

@Sample
@Module
public class ModuleWithStartupMethodAndFileParameter {

  @Startup
  public void startup(File value) {
  }
}
