package me.yangjun.study.springtest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.yangjun.study.springtest.domain.UserVo;
import org.apache.ibatis.annotations.MapKey;

import java.util.Map;

/**
 * @author Brady
 * @description 针对表【user】的数据库操作Mapper
 * @createDate 2023-04-15 23:25:55
 * @Entity generator.domain.UserVo
 */
public interface UserMapper extends BaseMapper<UserVo> {
    /**
     * 根据age分组，重复数据会被后一条覆盖
     *
     * @return {@link Map}<{@link Integer}, {@link UserVo}>
     */
    @MapKey(UserVo.Fields.age)
    Map<Integer, UserVo> findUserMapByAge();
}




