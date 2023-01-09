package com.example.springdatajdbcsample.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;

@Data//クラスに付与することで、全フィールドに対して、getter/setterでアクセスできる
@NoArgsConstructor//クラスに付与することで、デフォルトコンストラクタが自動に生成される
@AllArgsConstructor//クラスに付与することで、全フィールドに対する初期化値を引数にとるコンストラクタを自動生成できる
public class Book {
    @Id
    private Integer id;
    private String name;
}
