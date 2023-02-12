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

    @Mapping(target = "name", source = "englishUser", qualifiedByName = "convertName")
    UserPO formEnglishUser(EnglishUserPO englishUser);

    @Named("convertName")
    default String convertName(EnglishUserPO englishUser) {
        return englishUser.getFirstName() + " " + englishUser.getLastName();
    }
}
