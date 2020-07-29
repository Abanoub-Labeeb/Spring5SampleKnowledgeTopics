package org.spring5sampledemos.helpers;

public class StringHelper {
	public static boolean isNullOrEmpty(String str) {
        if(str != null && !str.trim().isEmpty())
            return false;
        return true;
    }
}
