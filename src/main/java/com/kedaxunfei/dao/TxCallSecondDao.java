package com.kedaxunfei.dao;

import com.kedaxunfei.entity.PublicTxCallSecond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TxCallSecondDao extends JpaRepository<PublicTxCallSecond,String> {
    @Override
    <S extends PublicTxCallSecond> S saveAndFlush(S s);



}
