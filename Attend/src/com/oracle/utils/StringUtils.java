package com.oracle.utils;

import java.util.regex.Pattern;

public class StringUtils {
	public static boolean isEmpty(String str) {
		if (str==null || str.trim().isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	/*
	  * �ж��Ƿ�Ϊ���� 
	  * @param str ������ַ��� 
	  * @return ����������true,���򷵻�false 
	*/


	  public static boolean isInteger(String str) {  
	    Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
	    return pattern.matcher(str).matches();  
	  }


}
