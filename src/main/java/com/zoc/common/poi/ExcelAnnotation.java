/**   
* @Title: ExcelAnnotation.java
* @Package com.zoc.common.poi
* @Description: TODO
* @author superzoc@gmail.com   
* @date May 1, 2013 12:29:40 AM
* @version   
*/
package com.zoc.common.poi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Administrator
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelAnnotation {
	public abstract int cellIndex() default 0;

}
