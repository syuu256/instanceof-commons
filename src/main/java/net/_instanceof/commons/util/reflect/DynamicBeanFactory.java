/*
 * Copyright(C) 2014 syuu256\gmail.com. All Rights Reserved.
 */
package net._instanceof.commons.util.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * クラス文字列よりインスタンスを取得する.
 */
public final class DynamicBeanFactory {

	/**
	 * インスタンスを生成.<br />
	 * 
	 * @param <T> 生成する型
	 * @param clazzName 実装クラス名
	 * @param clazz 戻り値型
	 * @return clazzのインスタンス
	 */
	public static <T> T create(final String clazzName, final Class<T> clazz) {

		final Class<?> implClass = forName(clazzName, clazz.getClassLoader());
		final Object instance = loadInstance(implClass);

		if (!clazz.isInstance(instance)) {
			// キャストに失敗しました class[{0}] type[{1}]
			throw new RuntimeException("cast error:" + clazzName + ":" + clazz);
		}
		return clazz.cast(instance);
	}

	/**
	 * Classを取得する.<br />
	 * 
	 * @param clazzName クラス名
	 * @return Class型
	 */
	public static Class<?> forName(final String clazzName) {
		return forName(clazzName, null);
	}

	/**
	 * Classを取得する.<br />
	 * 
	 * @param clazzName クラス名
	 * @param classLoader クラスローダー
	 * @return Class型
	 */
	public static Class<?> forName(final String clazzName, final ClassLoader classLoader) {

		Class<?> implClass;
		try {
			if (classLoader == null)
				implClass = Class.forName(clazzName);
			else
				implClass = classLoader.loadClass(clazzName);
		} catch (ClassNotFoundException e) {
			// Classの取得に失敗しました [{0}]
			throw new RuntimeException("load error:" + clazzName, e);
		}
		return implClass;
	}

	/**
	 * インスタンスを生成する.
	 * 
	 * @param clazz 生成するクラス
	 * @return インスタンス
	 */
	public static Object loadInstance(final Class<?> clazz) {

		Object instance;
		try {
			final Constructor<?> constructor = clazz.getDeclaredConstructor();
			setAccessible(constructor);
			instance = constructor.newInstance();
		} catch (Exception e) {
			// Classのインスタンス生成に失敗しました [{0}]
			throw new RuntimeException("newInstance error:" + clazz, e);
		}
		return instance;
	}

	/**
	 * インスタンスを生成する.
	 * 
	 * @param clazz 生成するクラス
	 * @return インスタンス
	 */
	public static <T> T loadInstanceByType(final Class<T> clazz) {

		T instance;
		try {
			final Constructor<T> constructor = clazz.getDeclaredConstructor();
			setAccessible(constructor);
			instance = constructor.newInstance();
		} catch (Exception e) {
			// Classのインスタンス生成に失敗しました [{0}]
			throw new RuntimeException("newInstance error:" + clazz, e);
		}
		return instance;
	}

	/**
	 * 特権モードに切り替える.
	 * 
	 * @param oAccessibleObject リフレクション対象
	 * @return 引数値
	 */
	public static AccessibleObject setAccessible(final AccessibleObject oAccessibleObject) {

		// 特権モードにアクセス属性を設定
		AccessController.doPrivileged(new PrivilegedAction<Object>() {
			public Object run() {
				oAccessibleObject.setAccessible(true);
				return null;
			}
		});
		return oAccessibleObject;
	}
	
	/**
	 * 動的ラップする.
	 * @param instance インスタンス
	 * @param invocationHandler ハンドラ
	 * @return ラップインスタンス
	 */
	public static Object proxyWrap(final Object instance, final InvocationHandler invocationHandler) {
		
		final Class<?> clazz = instance.getClass();
		Object returnValue = null;
        try {
        	returnValue = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), invocationHandler);
        } catch (IllegalArgumentException e) {
            // Proxy.newProxyInstanceに失敗しました [{0}] clazzName
            throw new RuntimeException(e);
        }

		return returnValue;
	}
}
