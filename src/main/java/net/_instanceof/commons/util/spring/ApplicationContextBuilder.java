/*
 * Copyright(C) 2014 syuu256\gmail.com. All Rights Reserved.
 */
package net._instanceof.commons.util.spring;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Springのコンテキストのユーティリティ.
 * JNDIにバインドして取得するので、スコープはアプリレベルです
 */
public class ApplicationContextBuilder {

    private static Logger log = LoggerFactory.getLogger(ApplicationContextBuilder.class);

    /** コンテキストファイルの-Dパラメータ名 */ // -Dnet.tsi_web.commons.spring.xml
    private static final String DEFAULT_APPLICATION_CONTEXT_XML_KEY = ApplicationContextBuilder.class.getPackage().getName() + ".xml";

    /** ディフォルトファイル名 */
    private static final String DEFAULT_APPLICATION_CONTEXT_XML = "applicationContext.xml";

    /** バインドする名称 */
    public static final String CONTEXT_NAME = "java:/comp/env/spring_context";

    /** インスタンス */
    private ApplicationContext applicationContext = null;

    /** コンテキスト生成 */
    public synchronized ApplicationContextBuilder createContext() {

        if (applicationContext != null) {
            return this;
        }

        lookupJNDI();
        if (applicationContext != null) {
            return this;
        }

        final String jndi = System.getProperty("java.naming.provider.url");
        final String xml_path = System.getProperty(DEFAULT_APPLICATION_CONTEXT_XML_KEY, DEFAULT_APPLICATION_CONTEXT_XML);
        if (log.isInfoEnabled()) {
            log.info("[Spring] ApplicationContext[" + xml_path + "]jndi[" + jndi + "]");
        }
        AbstractApplicationContext abstractApplicationContext;
        try {
            abstractApplicationContext = new ClassPathXmlApplicationContext(xml_path);
        } catch (BeansException e) {
            final String message_jp = "システムパラメータでclasspath上の正しいSpringContext.xmlを指定してください"
                    + "(例):-D" + DEFAULT_APPLICATION_CONTEXT_XML_KEY + "=foo.xml\n"
                    + "現在の参照パス[" + xml_path + "]";
            System.err.println(message_jp);
            throw e;
        }
        abstractApplicationContext.registerShutdownHook();
        applicationContext = abstractApplicationContext;

        return this;
    }

    /** JDNIにコンテキストをバインドする */
    public synchronized ApplicationContextBuilder bindJNDI() {
        try {
            if (isBindJNDI())return this;
            final Context context = createInitialContext();
            context.bind(CONTEXT_NAME, applicationContext);
            context.close();
        } catch (NamingException e) {
            log.error("jndi bind error");
            throw new RuntimeException(e);
        }
        return this;
    }

    protected boolean isBindJNDI() {
        try {
            final Context context = createInitialContext();
            context.lookup(CONTEXT_NAME);
            context.close();
        } catch (NamingException e) {
            return false;
        }
        return true;
    }

    /** JNDIよりコンテキストを取得する */
    public synchronized ApplicationContextBuilder lookupJNDI() {

        if (applicationContext != null) return this;
        try {
            final Context context = createInitialContext();
            final Object o = context.lookup(CONTEXT_NAME);
            context.close();
            applicationContext = ApplicationContext.class.cast(o);
        } catch (NamingException e) {
            //log.error("jndi lookup error");
            //throw new RuntimeException(e);
            applicationContext = null;
        }
        return this;
    }

    private Context createInitialContext() {

        Context context;
        try {
            context = new InitialContext();
        } catch (BeanDefinitionStoreException e) {
            final String jndi = System.getProperty("java.naming.provider.url");
            final String message_jp = "システムパラメータでclasspath上の正しいjndi.xmlを指定してください\n"
                    + "もしくは classpath上の[jndi.properties]を確認してください\n"
                    + "(例):-Djava.naming.provider.url=jndi.xml\n"
                    + "現在の参照パス[" + jndi + "]";
            System.err.println(message_jp);
            if (log.isErrorEnabled()) {
                log.error(message_jp, e);
            }
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return context;
    }

    /** コンテキストを取得する */
    public synchronized ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * コンテナからBeanを取得する.
     * @param name 名称
     * @param clazz 型
     * @return　インスタンス
     */
    public static <T> T getBean(final String name, final Class<T> clazz) {
        return lookupBeanFactory().getBean(name, clazz);
    }

    /**
     * コンテナからBeanを取得する.
     * @param clazz 型(インターフェース等)
     * @return　インスタンス
     */
    public static <T> T getBean(final Class<T> clazz) {
        return lookupBeanFactory().getBean(clazz);
    }

    private static BeanFactory lookupBeanFactory() {
        return new ApplicationContextBuilder()
            .lookupJNDI()
            .getApplicationContext();
    }
}
