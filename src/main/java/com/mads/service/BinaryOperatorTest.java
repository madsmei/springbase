package com.mads.service;

import lombok.Data;

import java.util.function.BinaryOperator;

/**
 * 这种函数方法 是要结合lamda表达式用的。
 *
 * 表示对两个相同类型的操作数的操作。产生与操作数相同类型的结果。
 * 这是BiFunction的一个特殊例子，它的结果和操作数都是相同的数据类型。
 * @Author Mads
 * @Date 2020/10/10 11:14
 */
public interface BinaryOperatorTest  extends BinaryOperator<BinaryOperatorTest.User> {

    /****
     *  执行
     * @Author Mads
     * @Date 2020/10/10
    **/
    @Override
    default User apply(User user, User user2) {
        return null;
    }

    //通过比较器Comparator来比较两个元素中较小的一个作为返回值返回。
//    static <T> BinaryOperator<T> minBy(Comparator<? super T> comparator)

    //通过比较器Comparator来比较两个元素中较大的一个作为返回值返回
//    static <T> BinaryOperator<T> maxBy(Comparator<? super T> comparator)

    @Data
    static class User {
        String username;

        String password;
    }
}
