package com.github.study.demo.mapstruct;

import io.protostuff.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class FooV2 {
    @Tag(1)
    private Padding state1;
    @Tag(2)
    private Padding state2;
}