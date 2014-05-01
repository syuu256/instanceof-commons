/*
 * Copyright(C) 2014 syuu256\gmail.com. All Rights Reserved.
 */
package net._instanceof.commons.util.collect;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * Listを作る.<br />
 * @param <T> 型
 */
public class ListMaker<T> {

    /** 値 */
    private List<T> list = Lists.newArrayList();

    /** 呼出不可 */
    protected ListMaker() {
    }

    /**
     * 追加する.<br />
     * @param value 追加値
     * @return this
     */
    public ListMaker<T> add(final T value) {
        list.add(value);
        return this;
    }

    /**
     * 取り出す
     * @return 成果物
     */
    public List<T> getList() {
        return list;
    }

    /**
     * 取り出す
     * @return 成果物
     */
    @SuppressWarnings("unchecked")
	public T[] getArray() {
        return (T[])list.toArray();
    }

// =============================================================================

    /**
     * ジェネリックスサポート.<br />
     * 戻り値型推論
     * @param <X> 生成型
     * @return インスタンス
     */
    public static <X> ListMaker<X> newMaker() {
        return new ListMaker<X>();
    }

    /**
     * ジェネリックスサポート.<br />
     * 戻り値の型推論が使えない場合に使う
     * @param <X> 生成型
     * @param clazz 生成型
     * @return インスタンス
     */
    public static <X> ListMaker<X> newMaker(final Class<X> clazz) {
        return newMaker();
    }
}