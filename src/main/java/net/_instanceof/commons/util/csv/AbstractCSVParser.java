/*
 * Copyright(C) 2014 syuu256\gmail.com. All Rights Reserved.
 */
package net._instanceof.commons.util.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 *
 */
abstract class AbstractCSVParser implements CSVParser {

    /** 無指定の場合のデフォルト値 */
    private static final String DEFAULT_ENCODE = "Windows-31J";

    /** 無指定の場合のデフォルト値 */
    private static final char DEFAULT_VALUE_SP = '\t';

    /** 無指定の場合のデフォルト値 */
    private static final String DEFAULT_LINE_SP = "\r\n";

    // =========================================================================

    /** Mapのキーを保持する. */
    private List<String> headers = new ArrayList<>();

    /** trueの場合はヘッダを解析して、Mapのキーにする */
    private boolean isHeaderParse = false;

    /** エンコードを設定する */
    private String encode = DEFAULT_ENCODE;

    /** 値区切り文字 */
    private char valueSparator = DEFAULT_VALUE_SP;

    /** 行区切り文字. */
    private String lineSparator = DEFAULT_LINE_SP;

    // =========================================================================

    /**
     * コンストラクタ.<br />
     */
    public AbstractCSVParser() {

        super();
    }

    /**
     * 返却値のMapキーに使用する値を設定する.
     *
     * <pre>
     * setHeaderParseをtrueにした場合は無視されます
     * setHeaderParseをfalseの場合は本値が使用されます
     * setHeaderParseをfalseで本値がnullの場合は数値文字列が入ります
     * </pre>
     *
     * @param headers Mapのキー値
     */
    public void setHeaders(final List<String> headers) {

        this.headers = new ArrayList<String>();

        if (headers != null) {
            this.headers.addAll(headers);
            return;
        }

        return;
    }

    /**
     * 1行目をヘッダ項目としてMapキー値とする.
     * <pre>
     * falseの場合はsetHeadersが使用されます
     * falseでsetHeadersがnullの場合は数値文字列が設定されます
     * ※ ヘッダ有り無し自動判定は行いません
     *    ファイル1行目が項目であってもキー値として使用します
     *    trueの場合は1行目は値として取得しません
     * </pre>
     * @param headerParse true = 解析してMapのキーにする
     */
    public void setHeaderParse(final boolean headerParse) {

        this.isHeaderParse = headerParse;

        return;
    }

    /**
     * 入力ファイルの文字コードを指定します.
     *
     * <pre>
     * バイナリ以外の場合に使用します
     * nullまたはサイズ0の場合はWindows-31Jとする
     * </pre>
     * @param encode 文字コード(Javaで通用するIANA定義の指定値 UTF-8など)
     */
    public void setEncode(final String encode) {

        this.encode = encode;

        if (this.encode == null || this.encode.length() == 0) {
            this.encode = DEFAULT_ENCODE;
        }
    }

    /**
     * 項目の区切り文字を設定します.
     * <pre>
     * 例は以下
     * CSV = {,}
     * TSV = {\t}
     * </pre>
     * @param valueSparator 項目区切り文字
     */
    public void setValueSparator(final char valueSparator) {

        this.valueSparator = valueSparator;
    }

    /**
     * 行区切り文字.
     * <pre>
     * \r\n or \n or \r or \r\rなど
     * nullまたはサイズ0の場合は{\r\n}とする
     * </pre>
     * @param lineSparator 指定する値の改行コードを指定してください
     */
    public void setLineSparator(final String lineSparator) {

        this.lineSparator = lineSparator;

        if (this.lineSparator == null || this.lineSparator.length() == 0) {
            this.lineSparator = DEFAULT_LINE_SP;
        }
    }

    /**
     * 設定を一気に行う.
     * @param headers ヘッダキー
     * @param headerParse ヘッダ解析フラグ
     * @param encode エンコード
     * @param valueSparator 値区切り文字
     * @param lineSparator 行区切り文字
     */
    public void build(final List<String> headers, final boolean headerParse,
            final String encode, final char valueSparator,
            final String lineSparator) {

        setHeaders(headers);
        setHeaderParse(headerParse);
        setEncode(encode);
        setValueSparator(valueSparator);
        setLineSparator(lineSparator);
    }

    // =========================================================================

    /**
     * 解析を行う. <br />
     * <pre>
     * </pre>
     * @param value 解析するファイル
     * @return 解析結果
     */
    public List<Map<String, String>> parse(final File value) {

        try {
            return parse(value.toURI().toURL());
        } catch (MalformedURLException e) {
            throw new RuntimeException("CSVParser:FileOpenError", e);
        }
    }

    /**
     * 解析を行う. <br />
     * @param value 解析するファイル
     * @return 解析結果
     * @throws BaseApplicationException 不正の場合
     */
    public List<Map<String, String>> parse(final URL value) {

        try {
            return parse(value.openStream());
        } catch (IOException e) {
            throw new RuntimeException("CSVParser:URLOpenError", e);
        }
    }

    /**
     * 解析を行う. <br />
     * @param value 解析するファイル
     * @return 解析結果
     * @throws Exception 不正の場合
     */
    public List<Map<String, String>> parse(final InputStream value) {

        try {
            return parse(new InputStreamReader(value, encode));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("CSVParser:InputStream Read Error", e);
        }
    }

    /**
     * 解析を行う. <br />
     *
     * <pre>
     * </pre>
     *
     * @param value
     *            解析するファイル
     * @return 解析結果
     * @throws BaseApplicationException
     *             不正の場合
     */
    public List<Map<String, String>> parse(final Reader value) {

        final StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(value);) {
            final int BUF_SIZE = 1024;
            final char[] buf = new char[BUF_SIZE];
            int len = 0;
            while ((len = reader.read(buf)) != -1) {
                sb.append(buf, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException("CSVParser:Reader Read Error", e);
        }

        return parse(sb.toString());
    }

    /**
     * 解析を行う. <br />
     *
     * <pre>
     * </pre>
     *
     * @param value
     *            解析するファイル
     * @return 解析結果
     * @throws BaseApplicationException
     *             不正の場合
     */
    public List<Map<String, String>> parse(final byte[] value) {

        try {
            return parse(new String(value, encode));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("CSVParser:getByte Encode Error", e);
        }
    }

    /**
     * 解析を行う. <br />
     *
     * <pre>
     * </pre>
     *
     * @param value
     *            解析するファイル
     * @return 解析結果
     * @throws BaseApplicationException
     *             不正の場合
     */
    public List<Map<String, String>> parse(final String value) {

        return parseImpl(value);
    }

    // =========================================================================

    /**
     * ファイル解析の実装.
     *
     * @param value
     *            解析する値
     * @param offset
     *            解析位置
     * @return 項目MapのList
     * @throws BaseApplicationException
     */
    protected List<Map<String, String>> parseImpl(final String value) {

        if (value == null || value.length() == 0) {
            return Collections.emptyList();
        }

        int offset = 1; // 1行目から戻す
        // ヘッダ解析あり
        if (isHeaderParse) {
            headers = readHeders(value);
            offset = 2; // 2行目から戻す
        }

        //System.out.println("readRowset-start");

        // 行の解析を行い、行配列を取得する 1 or 2行目から全部戻す
        final List<String> rowset = readRowset(value, offset, Integer.MAX_VALUE);

        //System.out.println("readRowset-end");

        // 行単位に解析してMapのListを作成する
        final List<Map<String, String>> ret = new ArrayList<Map<String, String>>();

        int i = 0;
        for (final String line : rowset) {
            i++;
            //System.out.println(i);
            final List<String> items = parseRow(line);
            ret.add(toMapValue(items, i));
        }

        return ret;
    }

    /**
     * 1行目のみ解析する.<br />
     *
     * <pre>
     * </pre>
     *
     * @param value
     *            解析する値
     * @return 1行目の値リスト
     * @throws BaseApplicationException
     *             ファイルが空の場合
     */
    protected List<String> readHeders(final String value) {

        // 1行目から1行戻す
        final List<String> rowSet = readRowset(value, 1, 1);

        if (rowSet.size() != 1) {
            throw new RuntimeException("CSVParser:Header Empty");
        }

        final String line = rowSet.get(0);

        return parseRow(line);
    }

    /**
     * 行単位に分解して戻す
     *
     * <pre>
     * 行文字列のList
     * 引数により戻す。値の開始行と開始行からのサイズを指定可能
     * 例 ヘッダを読み飛ばす場合 1, Integer.MAX_VALUE
     * </pre>
     *
     * @param value
     *            すべての文字列
     * @param offset
     *            戻す値の開始行 1オリジン
     * @param size
     *            開始行からの行サイズ (2ならば List#sizeは2です)
     * @return 行セット（RowSet)
     * @throws BaseApplicationException
     *             例外
     */
    protected abstract List<String> readRowset(final String value,
            final int offset, final int size);

    /**
     * 1行を解析して項目単位のListにして戻す.
     *
     * @param recordValue
     *            行の文字列
     * @return 行を項目単位に分割した値
     * @throws BaseApplicationException
     *             例外
     */
    protected abstract List<String> parseRow(final String recordValue);

    /**
     * 項目をMapに変換する.
     *
     * <pre>
     * Listのindexとheadersからキー値を取り出して
     * Mapを生成する
     * </pre>
     *
     * @param items
     *            項目のリスト
     * @return Map値
     * @throws BaseApplicationException
     *             例外
     */
    protected Map<String, String> toMapValue(final List<String> items, final int line) {

        // ヘッダが空の場合は数値を設定
        if (headers.isEmpty()) {
            for (int i = 0; i < items.size(); i++) {
                headers.add(String.valueOf(i));
            }
        }

        if (headers.size() != items.size()) {
            final Exception e =  new IllegalArgumentException("headers size error line:" + line + "/header:"
                    + headers.size() + "/item:" + items.size() + "/data:" + items.toString());
            throw new RuntimeException("", e);
        }

        final Map<String, String> m = new HashMap<String, String>();

        // indexが必要なのでforeachは使わない
        for (int i = 0; i < items.size(); i++) {

            // 同一のindexのヘッダ名を取得
            final String key = headers.get(i);
            final String value = items.get(i);
            final String old = m.put(key, value);

            if (old != null) {
                throw new RuntimeException("CSVParser:headers key Unique error header");
            }
        }

        return m;
    }

    /**
     * 項目区切り文字を取得.
     *
     * @return 項目区切り文字
     */
    protected char getValueSparator() {

        return valueSparator;
    }

    /**
     * 行区切り文字をchar配列で戻す
     *
     * @return
     */
    protected char[] getLineSpChars() {

        return lineSparator.toCharArray();
    }

}
