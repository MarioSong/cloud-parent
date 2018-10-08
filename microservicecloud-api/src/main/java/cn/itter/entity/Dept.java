package cn.itter.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Description: TODO
 * @Author: Mario.Song
 * @Date: Create in 2018/10/8 15:42
 */
@Data
@NoArgsConstructor
@Accessors(chain=true)
public class Dept {
    //主键
    private Long 	deptno;
    //部门名称
    private String 	dname;
    // 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
    private String 	db_source;
}
