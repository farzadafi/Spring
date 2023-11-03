// package name ends with "extensions." + extended class name
package extensions.java.lang.String;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

@SuppressWarnings("unused")
@Extension
public class MyStringExtension {
  public static void print(@This String thiz) {
    System.out.println(thiz);
  }
}