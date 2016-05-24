package com.util;

/**   
 * @Title JSONUtils.java 
 * @Package com.fbtt.site.utils 
 * @author huangsm 
 * @email huangsanm@gmail.com 
 * @date 2011-7-22 下午02:50:42 
 * @remark 
 * @version V1.0
 */ 

import java.beans.PropertyDescriptor;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.sun.org.apache.commons.beanutils.PropertyUtils;

//import com.sun.org.apache.commons.beanutils.PropertyUtils;

/** 
 * @ClassName: JSONUtils 
 * @author huangsm
 * @date 2011-7-22 下午02:50:42 
 * @remark  
 */
@SuppressWarnings("all")
public class JSONUtils {

	public static String stringToJson(String s) {
        if (s == null) {
            return nullTOJson();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
            case '"':
                sb.append("\\\"");
                break;
            case '\\':
                sb.append("\\\\");
                break;
            case '\b':
                sb.append("\\b");
                break;
            case '\f':
                sb.append("\\f");
                break;
            case '\n':
                sb.append("\\n");
                break;
            case '\r':
                sb.append("\\r");
                break;
            case '\t':
                sb.append("\\t");
                break;
            case '/':
                sb.append("\\/");
                break;
            default:
                if (ch >= '\u0000' && ch <= '\u001F') {
                    String ss = Integer.toHexString(ch);
                    sb.append("\\u");
                    for (int k = 0; k < 4 - ss.length(); k++) {
                        sb.append('0');
                    }
                    sb.append(ss.toUpperCase());
                } else {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
	/***
	 * 对象转换成为json
	 * 这里是描述这个方法的作用
	 * @return
	 * @author Java  
	 * @date 2011-7-22 下午02:59:13
	 */
	public static String objectToJson(Object obj){
		StringBuffer json = new StringBuffer();
		if (obj == null) {
            json.append("\"\"");
        } else if (obj instanceof Integer) {
        	json.append("\"").append(numberToJson((Integer)obj)).append("\"");
        } else if (obj instanceof Boolean) {
        	json.append("\"").append(booleanToJson((Boolean)obj)).append("\"");
        } else if (obj instanceof String) {
            json.append("\"").append(stringToJson(obj.toString())).append("\"");
        } else if (obj instanceof Object[]) {
        	json.append("\"").append(arrayToJson((Object[])obj)).append("\"");
        } else if (obj instanceof List) {
        	json.append("\"").append(listToJson((List<?>)obj)).append("\"");
        } else if (obj instanceof Map) {
        	json.append("\"").append(mapToJson((Map<?, ?>)obj)).append("\"");
        } else if(obj instanceof java.sql.Date){
        	json.append("\"").append(dateToJson((Date)obj)).append("\"");
        } else if(obj instanceof java.util.Date){
        	json.append("\"").append(dateUtilToJson((java.util.Date)obj)).append("\"");
        } else {
        	json.append("\"").append(stringToJson(obj.toString())).append("\"");
        }
		return json.toString();
	}
	
	/**
	 * 这里是描述这个方法的作用
	 * @param obj
	 * @return {["pname":"val"],["pname":"val"]...}
	 * @author Java  
	 * @date 2011-7-22 下午03:02:49 
	 */ 
	public static String beanToJson(Object obj) {
		StringBuffer json = new StringBuffer("{");
		try {
			PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(obj);
			if(pds != null && pds.length > 0){
				for (PropertyDescriptor pd : pds) {
					if(pd.getName().equals("class"))
						continue;
					String pname = objectToJson(pd.getName());
					String val = objectToJson(pd.getReadMethod().invoke(obj));
					json.append(pname);
					json.append(":");
					json.append(val);
					json.append(",");
				}
				json.setCharAt(json.length() - 1, '}');
			}else{
				json.append("}");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json.toString();
	}
	
	public static String beanToJson(Object obj, String params) {
		StringBuffer json = new StringBuffer("{");
		try {
			PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(obj);
			if(pds != null && pds.length > 0){
				for (PropertyDescriptor pd : pds) {
					String pname = pd.getName();
					if(pname.equals("class"))
						continue;
					if(params.indexOf(pname) == -1)
						continue;
					pname = objectToJson(pname);
					String val = objectToJson(pd.getReadMethod().invoke(obj));
					json.append(pname);
					json.append(":");
					json.append(val);
					json.append(",");
				}
				json.setCharAt(json.length() - 1, '}');
			}else{
				json.append("}");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json.toString();
	}

	
	/**
	 * 这里是描述这个方法的作用
	 * @param obj
	 * @return
	 * @see 
	 * @author Java  
	 * @date 2011-7-22 下午03:02:27 
	 */ 
	public static String mapToJson(Map<?, ?> map) {
		StringBuilder json = new StringBuilder();
        json.append("{");
        if (map != null && map.size() > 0) {
            for (Object key : map.keySet()) {
                json.append("" + objectToJson(key) + "");
                json.append(":");
                json.append("" + objectToJson(map.get(key)) + "");
                json.append(",");
            }
            json.setCharAt(json.length() - 1, '}');
        } else {
            json.append("}");
        }
        return json.toString();
	}

	/**
	 * 这里是描述这个方法的作用
	 * @param obj
	 * @return
	 * @author Java  
	 * @date 2011-7-22 下午03:02:15 
	 */ 
	public static String listToJson(List<?> list) {
		StringBuffer json = new StringBuffer();
        json.append("[");
        if (list != null && list.size() > 0) {
            for (Object obj : list) {
            	if (obj != null) {
            		json.append(beanToJson(obj));
                    json.append(",");	
				}
                
            }
            json.setCharAt(json.length() - 1, ']');
        } else {
            json.append("]");
        }
        return json.toString();
	}
	public static String listToJsonCity(List<?> list) {
		StringBuffer json = new StringBuffer();
        json.append("[");
        if (list != null && list.size() > 0) {
            for (int i=0;i<list.size();i++) {
                json.append(list.get(i));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, ']');
        } else {
            json.append("]");
        }
        return json.toString();
	}
	public static String listToJson(List<?> list, String params) {
		StringBuffer json = new StringBuffer();
        json.append("[");
        if (list != null && list.size() > 0) {
            for (Object obj : list) {
                json.append(beanToJson(obj, params));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, ']');
        } else {
            json.append("]");
        }
        return json.toString();
	}

	/**
	 * 这里是描述这个方法的作用
	 * @param obj
	 * @return
	 * @see 
	 * @author Java  
	 * @date 2011-7-22 下午03:02:05 
	 */ 
	private static String arrayToJson(Object[] array) {
		 StringBuilder json = new StringBuilder();
        json.append("{");
        if (array != null && array.length > 0) {
            for (Object obj : array) {
                json.append(objectToJson(obj));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, '}');
        } else {
            json.append("}");
        }
        return json.toString();
	}

	public static String dateToJson(Date date){
		return date.toString();
	}
	
	public static String dateUtilToJson(java.util.Date date){
		return date.toString();
	}
	
	public static String numberToJson(Number number) {
        return number.toString();
    }

    public static String booleanToJson(Boolean bool) {
        return bool.toString();
    }
	
	public static String nullTOJson(){
		return "";
	}
	/**
	 * 非空验证
	 * 这里是描述这个方法的作用
	 * @param arg0
	 * @return
	 * @author Java  
	 * @date 2011-7-22 下午02:51:43
	 */
	public static Boolean isNull(Object arg0){
		if(arg0 == null) return true;
		String arg = (String) arg0;
		return ("".equals(arg.trim()) || "null".equals(arg)) ? true : false;
	}
	
	public static HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}
	
	
	public static void outJSONData(Object obj){
        PrintWriter out = null;
        try{
             getResponse().setContentType("text/javascript;charset=UTF-8");
             out = getResponse().getWriter();
             out.print(obj);
        }catch (Exception e) {
             e.printStackTrace();   
        }finally{
                if(out != null){
                   out.flush();
                   out.close();
                }
        }
	}
}
