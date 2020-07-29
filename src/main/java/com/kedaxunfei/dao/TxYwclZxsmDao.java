package com.kedaxunfei.dao;

import com.kedaxunfei.entity.PublicTxYwclZxsm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TxYwclZxsmDao extends JpaRepository<PublicTxYwclZxsm,String> {
    @Override
    <S extends PublicTxYwclZxsm> S saveAndFlush(S s);

}
