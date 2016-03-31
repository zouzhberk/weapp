package com.github.zouzhberk.orm.dao;

import com.github.zouzhberk.orm.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by berk (zouzhberk@163.com)) on 3/31/16.
 */
public interface UserDAO extends Repository<UserEntity, Long>
{

    Optional<UserEntity> findOne(Long id);

    <S extends UserEntity> S save(S user);

    Optional<UserEntity> findByName(String name);

    @Query("select c from UserEntity c")
    Stream<UserEntity> streamAllCustomers();

    default <S extends UserEntity> S create(S user)
    {
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(user.getCreateTime());
        return save(user);
    }

    default <S extends UserEntity> S update(S user)
    {
        user.setUpdateTime(LocalDateTime.now());
        return save(user);
    }

}
