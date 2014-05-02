/*
 * Copyright(C) 2014 syuu256\gmail.com. All Rights Reserved.
 */
/**
 * logback Appender extends.
 * <pre>
 *   <appender name="FILE" class="jp.co.intellilink.cohepoc.logs.PIDNamingRollingFileAppender">
 *     <append>true</append>
 *     <file>/var/log/app-batch.log</file>
 *     <filter class="ch.qos.logback.classic.filter.ThresholdFilter">
 *       <level>TRACE</level>
 *     </filter>
 *     <!-- FixedWindowRollingPolicy -->
 *     <rollingPolicy class="jp.co.intellilink.cohepoc.logs.PIDNamingFixedWindowRollingPolicy">
 *       <FileNamePattern>/var/log/app-batch-%i.log</FileNamePattern>
 *       <MinIndex>1</MinIndex>
 *       <MaxIndex>13</MaxIndex>
 *     </rollingPolicy>
 *     <triggeringPolicy class="ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy">
 *       <MaxFileSize>100MB</MaxFileSize>
 *     </triggeringPolicy>
 *     <encoder>
 *       <charset>UTF-8</charset>
 *       <Pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%-5level] %logger{36} %thread - %msg%n</Pattern>
 *     </encoder>
 *   </appender>
 * </pre>
 */
package net._instanceof.commons.logs;

