package com.github.study.demo.mapstruct;

import io.protostuff.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Target {
    @Tag(1)
    private int state;
}