package com.util;
import java.lang.reflect.Field;
import java.util.HashMap;

@SuppressWarnings("unchecked")
public class ResultUtils {
	public static String toJSON(Object obj) {
		HashMap<String, String> map = new HashMap<String, String>();
		Class c = obj.getClass();
		Field[] fields = c.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			String name = fields[i].getName();
			try {fields[i].setAccessible(true);
			Object o = fields[i].get(obj);
				if (o instanceof Number) {
					map.put("\"" + name + "\"", o.toString());
				} else if (o instanceof String) {
					map.put("\"" + name + "\"", "\"" + o.toString() + "\"");
				}
			} catch (IllegalArgumentException e) {
			
			} catch (IllegalAccessException e) {
			
			}
		}
		String s = map.toString();
		String str = s.replaceAll("\"=", "\":");
		return str;
	}
	/**    * 将一个对象数组转换成JSON字符串    
	 * 
	 *    
	 * @param objs    
	 *           要转换的对象数组    
	 * @return 转换后得到的字符串    
	 * */
	public static String toJSON(Object[] objs) {
		String[] strs = new String[objs.length];
		for (int i = 0; i < objs.length; i++) {
			strs[i] = toJSON(objs[i]);
		}
			return toJSONArray(strs);
	}
	/**    * 将多个JSON字符串转换成一个JSON字符串，并加入一个标识长度的属性length    * 
	 *     * @param strs    *          要转换的多个JSON字符串    
	 * * @return 完整的一个JSON字符串    */
	public static String toJSONArray(String[] strs) {
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		for (int i = 0; i < strs.length; i++) {
			sb.append("\"");
			sb.append(i);sb.append("\":");
			sb.append(strs[i]);sb.append(",");
		}
		sb.append("\"length\":");
		sb.append(strs.length);
		sb.append("}");
		return sb.toString();
	}
}