package com.github.springbootparambinding.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 创建时间为 下午10:54 2020/5/2
 * 项目名称 spring-boot-param-binding
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResultDTO<T> {

    private Integer status;

    private T data;

    public static <T> ResultDTO<T> success(T t) {
        return ResultDTO.<T>builder().data(t).status(200).build();
    }

}
