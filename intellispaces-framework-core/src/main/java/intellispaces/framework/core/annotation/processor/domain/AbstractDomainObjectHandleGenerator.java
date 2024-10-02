package intellispaces.framework.core.annotation.processor.domain;

import intellispaces.common.javastatement.customtype.CustomType;
import intellispaces.common.javastatement.customtype.InterfaceType;
import intellispaces.common.javastatement.customtype.Interfaces;
import intellispaces.common.javastatement.method.MethodStatement;
import intellispaces.common.javastatement.reference.CustomTypeReference;
import intellispaces.common.javastatement.reference.CustomTypeReferences;
import intellispaces.common.javastatement.reference.NamedReference;
import intellispaces.common.javastatement.reference.NotPrimitiveReference;
import intellispaces.common.javastatement.reference.ReferenceBound;
import intellispaces.framework.core.annotation.processor.AbstractObjectHandleGenerator;
import intellispaces.framework.core.annotation.processor.AnnotationProcessorFunctions;
import intellispaces.framework.core.annotation.processor.ArtifactTypes;
import intellispaces.framework.core.object.ObjectFunctions;
import intellispaces.framework.core.space.domain.DomainFunctions;

import javax.annotation.processing.RoundEnvironment;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

abstract class AbstractDomainObjectHandleGenerator extends AbstractObjectHandleGenerator {

  public AbstractDomainObjectHandleGenerator(CustomType initiatorType, CustomType domainType) {
    super(initiatorType, domainType);
  }

  protected Stream<MethodStatement> getObjectHandleMethods(
      CustomType customType, RoundEnvironment roundEnv
  ) {
    return customType.actualMethods().stream()
        .filter(m -> DomainFunctions.isDomainType(m.owner()));
  }

  protected String typeConverter(String className) {
    String handleCanonicalName = ObjectFunctions.getObjectHandleTypename(className, getObjectHandleType());
    return context.addToImportAndGetSimpleName(handleCanonicalName);
  }

  protected List<MethodStatement> getAdditionalOMethods(CustomType customType, RoundEnvironment roundEnv) {
    List<MethodStatement> methods = new ArrayList<>();
    List<CustomType> artifactAnnexes = AnnotationProcessorFunctions.findArtifactAnnexes(
        customType, ArtifactTypes.ObjectHandle, roundEnv
    );
    for (CustomType artifactAnnex : artifactAnnexes) {
      methods.addAll(artifactAnnex.declaredMethods());
    }
    return methods;
  }

  protected CustomType buildActualType(CustomType domain, RoundEnvironment roundEnv) {
    InterfaceType domainInterface = domain.asInterfaceOrElseThrow();

    var builder = Interfaces.build(domainInterface);
    getAdditionalOMethods(domainInterface, roundEnv).forEach(builder::addDeclaredMethod);

    var parentInterfaces = new ArrayList<CustomTypeReference>();
    for (CustomTypeReference parent : domainInterface.extendedInterfaces()) {
      parentInterfaces.add(
          CustomTypeReferences.get(buildActualType(parent.targetType(), roundEnv), parent.typeArguments())
      );
    }
    builder.extendedInterfaces(parentInterfaces);
    return builder.get();
  }

  protected String buildDomainType(CustomType domainType, List<NotPrimitiveReference> typeQualifiers) {
    StringBuilder sb = new StringBuilder();
    sb.append("Types.of(");
    sb.append(context.addToImportAndGetSimpleName(domainType.canonicalName())).append(".class");
    for (NotPrimitiveReference typeQualifier : typeQualifiers) {
      sb.append(", ");
      analyzeDomainType(typeQualifier, sb);
    }
    sb.append(");");
    return sb.toString();
  }

  private void analyzeDomainType(NotPrimitiveReference typeReference, StringBuilder sb) {
    if (typeReference.isCustomTypeReference()) {
      CustomTypeReference customTypeReference = typeReference.asCustomTypeReferenceOrElseThrow();
      sb.append("Types.of(");
      sb.append(context.addToImportAndGetSimpleName(customTypeReference.targetType().canonicalName())).append(".class");
      for (NotPrimitiveReference typeArg : customTypeReference.typeArguments()) {
        sb.append(", ");
        analyzeDomainType(typeArg, sb);
      }
      sb.append(")");
    } else if (typeReference.isNamedReference()) {
      NamedReference namedReference = typeReference.asNamedReferenceOrElseThrow();
      if (namedReference.extendedBounds().isEmpty()) {
        sb.append("Types.of(");
        sb.append(context.addToImportAndGetSimpleName(Object.class)).append(".class");
        sb.append(")");
      } else {
        ReferenceBound extendedBound = namedReference.extendedBounds().get(0);
        analyzeDomainType(extendedBound, sb);
      }
    }
  }
}