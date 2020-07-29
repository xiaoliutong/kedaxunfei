package com.kedaxunfei.dao;

import com.kedaxunfei.entity.PublicTxYwclZxxx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TxYwclZxxxDao  extends JpaRepository<PublicTxYwclZxxx,String> {
    @Override
    <S extends PublicTxYwclZxxx> S saveAndFlush(S s);
}
