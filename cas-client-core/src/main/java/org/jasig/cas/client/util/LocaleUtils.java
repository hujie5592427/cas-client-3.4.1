/**
 * jhu Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package org.jasig.cas.client.util;

import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *                       
 * @Filename: LogonController.java
 *
 * @Description: 
 *
 * @Version: 1.0
 *
 * @Author: jhu
 *
 * @Email: 308165757@qq.com
 *
 *       
 * @History:<br>
 *<li>Author: jhu</li>
 *<li>Date: 2017-2-24</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class LocaleUtils {
    public static String getLocale(HttpServletRequest request, String cookieName) {
        Locale locale;
        String cookieLang = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for(Cookie cookie : cookies){
                if(cookieName.equals(cookie.getName())) {
                    cookieLang = cookie.getValue();
                    break;
                }
            }
        }
        
        if(cookieLang != null && cookieLang.length() > 0 && cookieLang.indexOf("_") > 0) {
            locale = new Locale(cookieLang.split("_")[0], cookieLang.split("_")[1]);
        } else {
            locale = request.getLocale();
        }
        
        return locale.toString();
    }
}
