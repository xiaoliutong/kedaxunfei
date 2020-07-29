package com.kedaxunfei.dao;

import com.kedaxunfei.entity.TXtYh;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TXtYhDao extends JpaRepository<TXtYh,String> {
    @Override
    <S extends TXtYh> S findOne(Example<S> example);

     TXtYh getByYH_DM(String yhDm);
}
