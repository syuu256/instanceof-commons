/*
 * Copyright(C) 2014 syuu256\gmail.com. All Rights Reserved.
 */
package net._instanceof.commons.util.csv;

import java.util.List;
import java.util.ArrayList;

/**
 *　Excel [alt+Enter]　colmas 
 */
class CSVParserImpl extends AbstractCSVParser {

    /** クウォート */
    private static final char QT = '"';

    /**
     * 行単位に分解して戻す
     * <pre>
     * 行文字列のList
     * 引数により戻す。値の開始行と開始行からのサイズを指定可能
     * 例 ヘッダを読み飛ばす場合 1, Integer.MAX_VALUE
     * </pre>
     * @param value すべての文字列
     * @param offset 戻す値の開始行 1オリジン
     * @param size 開始行からの行サイズ (2ならば List#sizeは2です)
     * @return 行セット（RowSet)
     */
    @java.lang.Override
    protected List<String> readRowset(final String value, final int offset, final int size) {

        final List<String> list = new ArrayList<>();
        final StringBuilder sb = new StringBuilder();
        final int length = value.length(); // 文字数
        final char[] lineSP = getLineSpChars(); // 行区切り文字
        boolean charStart = false; // 文字の開始フラグ「ダブルコートの中」

        int lineCount = 0;

        // 1文字単位のループ
        for (int i = 0; i < length; i++) {

            final char ch0 = value.charAt(i);
            char ch1 = 0x00;

            // indexの次の値を取得
            if ((i + 1) < length) {
                ch1 = value.charAt(i + 1);
            }

            // 文字列の中のでは無い
            if ((!charStart) && ch0 == QT) {

                charStart = true;
                sb.append(ch0);
                continue; // もう一度
            }

            // 文字列の中の場合
            if (charStart && ch0 == QT) {

                if (ch1 == QT) {
                    sb.append(ch0);
                    sb.append(ch1);
                    i++;
                    continue;
                }

                charStart = false; // 文字列の終了と認識
                sb.append(ch0);
                continue;
            }

            // 文字列です
            if (charStart) {
                sb.append(ch0);
                continue;
            }

            // 文字列の中では無い
            // 改行コードは2バイトの場合も判定する
            boolean lineEnd = false;
            if (lineSP.length >= 2 && ch0 == lineSP[0] && ch1 == lineSP[1]) {
                lineEnd = true;
            } else if (ch0 == lineSP[0]) {
                lineEnd = true;
            } else if (ch1 == 0x00) {
                sb.append(ch0);
                lineEnd = true;
            }

            // 行が終わった
            if (lineEnd) {

                lineCount++; // 実際の行数
                i += (lineSP.length - 1);

                // 読み飛ばし判定
                if (lineCount < offset) {
                    sb.setLength(0); // バッファの破棄
                    continue;
                }

                if (sb.length() != 0) {
                    list.add(sb.toString()); // レコードを保存
                }

                sb.setLength(0); // バッファの破棄

                // 読み取りサイズ判定
                if (list.size() >= size) {
                    break;
                }

                continue;
            }

            sb.append(ch0); // 値は保持する
        } // for-end

        // 最後に改行が無い場合も１行とする "9,0000,{EOF}
        // 読み捨ての場合は無視する
        if (sb.length() != 0 && list.size() <= size && lineCount > offset) {
            list.add(sb.toString());
        }

        return list;
    }

    /**
     * 1行を解析して項目単位のListにして戻す.
     * @param recordValue 行の文字列
     * @return 行を項目単位に分割した値
     */
    @java.lang.Override
    protected List<String> parseRow(final String recordValue) {

        final char[] chArr = recordValue.toCharArray();
        final List<String> list = new ArrayList<String>();
        final int length = chArr.length;
        final char SP = getValueSparator();
        int i = 0;

        while (true) {

            final StringBuilder sb = new StringBuilder();

            if (i >= length) {

                if ((i - 1) == length) {
                    break; // {あ\0}の場合
                }

                if ((i - 1) == -1) {
                    break; // {}の場合
                }

                if (chArr[i - 1] == SP) {
                    sb.append(""); // 終端が{"あ",\0}で終わる場合
                    list.add(sb.toString());
                }

                break; // 終わり
            }

            if (chArr[i] != QT) {

                while (true) { // 次のカンマまでループする

                    // ファイル終端判定
                    if (i >= length) {
                        break;
                    }

                    final char ch0 = chArr[i];
                    char ch1 = 0x00;

                    // 次の文字を取得(エスケープ判定) EOF判定含む
                    if ((i + 1) < length) {
                        ch1 = chArr[i + 1];
                    }

                    // エスケープ文字 or EOFならば
                    if (ch1 == 0x00 || ch1 == SP) {

                        // エスケープ判定
                        if (ch0 != SP) {
                            sb.append(ch0);
                            i++;
                        }

                        i++;
                        list.add(sb.toString());
                        break;
                    }

                    if (ch0 == SP) {
                        list.add(sb.toString());
                        i++;
                        break;
                    }

                    sb.append(ch0);
                    i++;
                }

                continue;
            }

            i++;

            // ダブルコードのエスケープ、{,}の文字認識
            while (true) {

                // ファイル終端判定
                if (i >= length) {
                    break;
                }

                final char ch0 = chArr[i];
                char ch1 = 0x00;

                // 次の文字を取得(エスケープ判定) EOF判定含む
                if ((i + 1) < length) {
                    ch1 = chArr[i + 1];
                }

                // 次の文字がEOFならば
                if (ch1 == 0x00) {
                    list.add(sb.toString());
                    break;
                }

                // エスケープ判定
                if (ch0 == QT) {
                    i++;

                    if (ch1 != QT) {
                        list.add(sb.toString());
                        i++;
                        break;
                    }
                }

                sb.append(ch0);
                i++;
            }

        } // while-end

        return list;
    }
}
