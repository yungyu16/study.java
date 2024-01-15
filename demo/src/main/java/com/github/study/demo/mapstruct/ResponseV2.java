package com.github.study.demo.mapstruct;

import io.protostuff.Tag;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
class ResponseV2 {
    @Tag(2)
    private FooV2 foo;
    @Tag(5)
    private Target target1;
    @Tag(7)
    private Padding padding;
    @Tag(10)
    private Target target2;
}
