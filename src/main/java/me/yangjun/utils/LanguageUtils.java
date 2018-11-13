package me.yangjun.utils;

import java.util.Locale;

/**
 * 获取语言资源
 * 
 * @author yangjun
 */
public class LanguageUtils {
	public static final String get(String key) {
		return get(key, null, null);
	}

	public static final String get(String key, Object... args) {
		return get(key, args, null, Locale.CHINA);
	}

	public static final String get(String key, Object[] args, String defaultMsg) {
		return get(key, args, defaultMsg, Locale.CHINA);
	}

	public static final String get(String key, Object[] args, String defaultMsg, Locale locale) {
		// ResourceBundleMessageSource messageSource = (ResourceBundleMessageSource)
		// SpringContextUtils.getBean("messageSource");
		return get(key, args, defaultMsg, locale);
	}
}
