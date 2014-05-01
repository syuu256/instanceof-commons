/*
 * Copyright(C) 2014 syuu256\gmail.com. All Rights Reserved.
 */
package net._instanceof.commons.util.csv;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import java.util.Map;

public interface CSVParser {

    /**
     * 返却値のMapキーに使用する値を設定する.
     * <pre>
     * setHeaderParseをtrueにした場合は無視されます
     * setHeaderParseをfalseの場合は本値が使用されます
     * setHeaderParseをfalseで本値がnullの場合は数値文字列が入ります
     * </pre>
     * @param headers Mapのキー値
     */
    void setHeaders(final List<String> headers);

    /**
     * 1行目をヘッダ項目としてMapキー値とする.
     * <pre>
     * falseの場合はsetHeadersが使用されます
     * falseでsetHeadersがnullの場合は数値文字列が設定されます
     *
     * ※ ヘッダ有り無し自動判定は行いません
     *    ファイル1行目が項目であってもキー値として使用します
     *    trueの場合は1行目は値として取得しません
     * </pre>
     * @param headerParse true = 解析してMapのキーにする
     */
    void setHeaderParse(final boolean headerParse);

    /**
     * 入力ファイルの文字コードを指定します.
     * <pre>
     * バイナリ以外の場合に使用します
     * nullまたはサイズ0の場合はWindows-31Jとする
     * </pre>
     * @param encode 文字コード(Javaで通用するIANA定義の指定値 UTF-8など)
     */
    void setEncode(final String encode);

    /**
     * 項目の区切り文字を設定します.
     * <pre>
     * 例は以下
     * CSV = {,}
     * TSV = {\t}
     * </pre>
     * @param valueSparator 項目区切り文字
     */
    void setValueSparator(final char valueSparator);

    /**
     * 行区切り文字.
     * <pre>
     * \r\n or \n or \r or \r\rなど
     * nullまたはサイズ0の場合は{\r\n}とする
     * </pre>
     * @param lineSparator 指定する値の改行コードを指定してください
     */
    void setLineSparator(final String lineSparator);

    /**
     * 設定を一気に行う.
     * @param headers ヘッダキー
     * @param headerParse ヘッダ解析フラグ
     * @param encode エンコード
     * @param valueSparator 値区切り文字
     * @param lineSparator 行区切り文字
     */
    void build(final List<String> headers, final boolean headerParse,
            final String encode, final char valueSparator,
            final String lineSparator);

    /**
     * 解析を行う. <br />
     * <pre>
     * </pre>
     * @param value 解析するファイル
     * @return 解析結果
     */
    List<Map<String, String>> parse(final URL value);

    /**
     * 解析を行う. <br />
     * <pre>
     * </pre>
     * @param value  解析するファイル
     * @return 解析結果
     */
    List<Map<String, String>> parse(final File value);

    /**
     * 解析を行う. <br />
     * <pre>
     * </pre>
     * @param value 解析するファイル
     * @return 解析結果
     */
    List<Map<String, String>> parse(final InputStream value);

    /**
     * 解析を行う. <br />
     * <pre>
     * </pre>
     * @param value 解析するファイル
     * @return 解析結果
     */
    List<Map<String, String>> parse(final byte[] value);

    /**
     * 解析を行う. <br />
     * <pre>
     * </pre>
     * @param value  解析するファイル
     * @return 解析結果
     */
    List<Map<String, String>> parse(final Reader value);

    /**
     * 解析を行う. <br />
     * <pre>
     * </pre>
     * @param value 解析するファイル
     * @return 解析結果
     */
    List<Map<String, String>> parse(final String value);

}
