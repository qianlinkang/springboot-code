package org.sboot.ssmp.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "书籍类")
@Data
public class Book {

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("书籍类型")
    private String type;

    @ApiModelProperty("书籍名称")
    private String name;

    @ApiModelProperty("书籍描述")
    private String description;
}
