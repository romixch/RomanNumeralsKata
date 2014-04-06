
package ch.romix.junit;

import java.lang.reflect.Method;

import org.junit.runners.model.FrameworkMethod;

public class ParameterizedMethod extends FrameworkMethod {

  private Parameter parameterAnotations;
  private Object[] parameters;

  public ParameterizedMethod(Method method, Parameter parameter) {
    super(method);
    parameters = new Object[method.getParameterTypes().length];
    Class<?>[] parameterTypes = method.getParameterTypes();
    for (int i = 0; i < parameterTypes.length; i++) {
      Class<?> paramType = parameterTypes[i];
      if (paramType.equals(String.class)) {
        parameters[i] = parameter.value()[i];
      } else if (paramType.getName().equals("int")) {
        parameters[i] = Integer.valueOf(parameter.value()[i]);
      }
    }
    this.parameterAnotations = parameter;
  }

  @Override
  public String getName() {
    String name = super.getMethod().getName();
    for (String param : parameterAnotations.value()) {
      name = name + '_' + param;
    }
    return name;
  }

  public Object[] getParameters() {
    return parameters;
  }

  @Override
  public int hashCode() {
    return super.hashCode() + parameterAnotations.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof ParameterizedMethod) {
      return super.equals(obj) && parameterAnotations.equals(ParameterizedMethod.class.cast(obj).parameterAnotations);
    } else {
      return false;
    }
  }
}
