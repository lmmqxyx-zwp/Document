package com.by.utils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * 解析request、session参数情况
 *
 * @author zwp
 */
public class RequestSessionUtil {

    public static final int _1M = 1024;

    private Principal principal;

    /**
     * 输出request相关信息
     *
     * @param request
     * @param detailFlg true 详细显示 | false 主要信息显示
     */
    public static void requestParamsDisplay(HttpServletRequest request, boolean detailFlg) {
        System.out.println("+++++++ REQUEST START +++++++");
        int count = 0;
//request Parameter
        System.out.println("request.getParameterMap() ... ");
        System.out.println("-----------------------------------------------------------------------------");
        Map<String, Object> paramsMap = request.getParameterMap();
        Set<String> keySet = paramsMap.keySet();
        for (String key: keySet
             ) {
            System.out.println("key : " + key + " - " + "value : " + paramsMap.get(key));
            count ++;
        }
        System.out.println("===");
        System.out.println("= : " + count);
        System.out.println("-----------------------------------------------------------------------------");

//request Attribute
        System.out.println("request.getAttributeNames() ... ");
        count = 0;
        System.out.println("-----------------------------------------------------------------------------");
        Enumeration<String> enumeration = request.getAttributeNames();
        while (enumeration.hasMoreElements()) {
            String attributeName = enumeration.nextElement();
            System.out.println("attributeName : " + attributeName + " - " + "value : " + request.getAttribute(attributeName));
            count ++;
        }
        System.out.println("===");
        System.out.println("= : " + count);
        System.out.println("-----------------------------------------------------------------------------");

//request Header
        System.out.println("request.getHeaderNames() ... ");
        count = 0;
        System.out.println("-----------------------------------------------------------------------------");
        enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String headerName = enumeration.nextElement();
            System.out.println("headerName : " + headerName + " - " + "value : " + request.getHeader(headerName));
            count ++;
        }
        System.out.println("===");
        System.out.println("= : " + count);
        System.out.println("-----------------------------------------------------------------------------");

//cookie
        Cookie[] cookies = request.getCookies();
        System.out.println("request.getCookies() ... ");
        System.out.println("-----------------------------------------------------------------------------");
        for (Cookie cookie: cookies
             ) {
            String cookieName = cookie.getName();
            String cookieValue = cookie.getValue();
            int cookieVersion = cookie.getVersion();
            System.out.println("cookieName : " + cookieName + " - " + "cookieValue : " + cookieValue + " - " + "cookieVersion : " + cookieVersion);
        }
        System.out.println("===");
        System.out.println("= : " + cookies == null ? 0 : cookies.length);
        System.out.println("-----------------------------------------------------------------------------");

//detailFlg = true
        if(detailFlg) {
            String authType = request.getAuthType();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("authType : " + authType);
            System.out.println("-----------------------------------------------------------------------------");


            String contextPath = request.getContextPath();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("contextPath : " + contextPath);
            System.out.println("-----------------------------------------------------------------------------");

            System.out.println("-----------------------------------------------------------------------------");
            int contentLength = request.getContentLength();
            System.out.println("contentLength : " + contentLength);
            System.out.println("-----------------------------------------------------------------------------");

            System.out.println("-----------------------------------------------------------------------------");
            String contentType = request.getContentType();
            System.out.println("contentType : " + contentType);
            System.out.println("-----------------------------------------------------------------------------");

            String methodType = request.getMethod();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("methodType : " + methodType);
            System.out.println("-----------------------------------------------------------------------------");

            String pathInfo = request.getPathInfo();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("pathInfo : " + pathInfo);
            System.out.println("-----------------------------------------------------------------------------");

            String pathTranslated = request.getPathTranslated();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("pathTranslated : " + pathTranslated);
            System.out.println("-----------------------------------------------------------------------------");

            String queryString = request.getQueryString();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("queryString : " + queryString);
            System.out.println("-----------------------------------------------------------------------------");

            String requestedSessionId = request.getRequestedSessionId();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("requestedSessionId : " + requestedSessionId);
            System.out.println("-----------------------------------------------------------------------------");

            String requestUri = request.getRequestURI();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("requestUri : " + requestUri);
            System.out.println("-----------------------------------------------------------------------------");

            StringBuffer requestURL = request.getRequestURL();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("requestURL : " + requestURL);
            System.out.println("-----------------------------------------------------------------------------");

            String servletPath = request.getServletPath();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("servletPath : " + servletPath);
            System.out.println("-----------------------------------------------------------------------------");

            String serverName = request.getServerName();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("serverName : " + serverName);
            System.out.println("-----------------------------------------------------------------------------");

            int serverPort = request.getServerPort();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("serverPort : " + serverPort);
            System.out.println("-----------------------------------------------------------------------------");

            String scheme = request.getScheme();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("scheme : " + scheme);
            System.out.println("-----------------------------------------------------------------------------");

            String remoteUser = request.getRemoteUser();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("remoteUser : " + remoteUser);
            System.out.println("-----------------------------------------------------------------------------");

            String remoteAddr = request.getRemoteAddr();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("remoteAddr : " + remoteAddr);
            System.out.println("-----------------------------------------------------------------------------");

            String remoteHost = request.getRemoteHost();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("remoteHost : " + remoteHost);
            System.out.println("-----------------------------------------------------------------------------");

            int remotePort = request.getRemotePort();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("remotePort : " + remotePort);
            System.out.println("-----------------------------------------------------------------------------");

            String protocol = request.getProtocol();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("protocol : " + protocol);
            System.out.println("-----------------------------------------------------------------------------");

            System.out.println("request.getReader() ... ");
            System.out.println("-----------------------------------------------------------------------------");
            try {
                BufferedReader reader = request.getReader();
                String line;
                count = 0;
                while ((line = reader.readLine()) != null) {
                    System.out.println("line : " + (count + 1) + " - " + line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("-----------------------------------------------------------------------------");

            System.out.println("request.getInputStream() ... ");
            System.out.println("-----------------------------------------------------------------------------");
            try {
                ServletInputStream servletInputStream = request.getInputStream();
                byte[] bytes = new byte[_1M];
                servletInputStream.read(bytes);
                int i = 0;
                count = 0;
                while ((i = servletInputStream.read(bytes)) != -1) {
                    System.out.println("count ++ : " + count + " - " + "string : " + new String(bytes));
                }
            } catch (Exception e) {
                System.out.println("");
            }
            System.out.println("-----------------------------------------------------------------------------");
            String localAddr = request.getLocalAddr();
            System.out.println("localAddr : " + localAddr);
            System.out.println("-----------------------------------------------------------------------------");

            System.out.println("-----------------------------------------------------------------------------");
            Locale locale = request.getLocale();
            System.out.println("locale : " + locale);
            System.out.println("-----------------------------------------------------------------------------");

            System.out.println("-----------------------------------------------------------------------------");
            String localName = request.getLocalName();
            System.out.println("localName : " + localName);
            System.out.println("-----------------------------------------------------------------------------");

            System.out.println("-----------------------------------------------------------------------------");
            int localPort = request.getLocalPort();
            System.out.println("localPort : " + localPort);
            System.out.println("-----------------------------------------------------------------------------");


            System.out.println("request.getLocales() ... ");
            System.out.println("-----------------------------------------------------------------------------");
            Enumeration<Locale> locales = request.getLocales();
            count = 0;
            while (locales.hasMoreElements()) {
                Locale tempLocale = locales.nextElement();
                String displayName = tempLocale.getDisplayName();
                String language = tempLocale.getLanguage();
                String displayCountry = tempLocale.getDisplayCountry();
                System.out.println("displayName : " + displayName + " - " +
                                   "language : " + language + " - " +
                                   "displayCountry : " + displayCountry);
                count ++;
            }
            System.out.println("===");
            System.out.println("= : " + count);
            System.out.println("-----------------------------------------------------------------------------");

            System.out.println("-----------------------------------------------------------------------------");
            java.security.Principal principal = request.getUserPrincipal();
            System.out.println("principalName : " + (principal == null ? "[ NULL ]" : principal.getName()));
            System.out.println("-----------------------------------------------------------------------------");

            System.out.println("-----------------------------------------------------------------------------");
            String characterEncoding = request.getCharacterEncoding();
            System.out.println("characterEncoding : " + characterEncoding);
            System.out.println("-----------------------------------------------------------------------------");
        }
        System.out.println("+++++++ REQUEST E N D +++++++");
    }

    /**
     * 输出session中的相关信息
     *
     * @param request
     */
    public static void sessionParamsDisplay(HttpServletRequest request) {
        System.out.println("+++++++ SESSION START +++++++");
        HttpSession session = request.getSession();
        int count = 0;
        if (session != null) {
            System.out.println("session.getAttributeNames() ... ");
            count = 0;
            System.out.println("-----------------------------------------------------------------------------");
            Enumeration<String> enumeration = session.getAttributeNames();
            while (enumeration.hasMoreElements()) {
                String attributeName = enumeration.nextElement();
                System.out.println("attributeName : " + attributeName + " - " + "value : " + session.getAttribute(attributeName));
                count ++;
            }
            System.out.println("===");
            System.out.println("= : " + count);
            System.out.println("-----------------------------------------------------------------------------");
        }
        System.out.println("+++++++ SESSION E N D +++++++");
    }

}
