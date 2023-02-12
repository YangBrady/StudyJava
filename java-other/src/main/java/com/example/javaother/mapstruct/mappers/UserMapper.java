package com.example.javaother.mapstruct.mappers;

import me.yangjun.study.common.po.EnglishUserPO;
import me.yangjun.study.common.po.UserPO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    /**
     * 从指定属性中转换
     *
     * @param englishUser 英语用户
     * @return {@link UserPO}
     */
    @Mapping(target = "name", source = "englishUser", qualifiedByName = "convertName")
    UserPO formEnglishUser1(EnglishUserPO englishUser);

    /**
     * 多入参转换
     * 根据指定方法转换
     *
     * @param user1 user1
     * @param user2 user2
     * @return {@link UserPO}
     */
    @Mapping(target = "name", source = "user1.firstName")
    @Mapping(target = "age", source = "user1.age")
    @Mapping(target = "sex", source = "user2.sex")
    @Mapping(target = "phoneNum", expression = "java(org.springframework.util.Base64Utils.encodeToString(user2.getPhoneNum().getBytes()))")
    UserPO formEnglishUser2(EnglishUserPO user1, EnglishUserPO user2);

    @Named("convertName")
    default String convertName(EnglishUserPO englishUser) {
        return englishUser.getFirstName() + " " + englishUser.getLastName();
    }
}
