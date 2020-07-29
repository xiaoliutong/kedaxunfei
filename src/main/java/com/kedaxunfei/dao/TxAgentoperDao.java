package com.kedaxunfei.dao;

import com.kedaxunfei.entity.PublicTxAgentoperate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TxAgentoperDao extends JpaRepository<PublicTxAgentoperate,String> {
    @Override
    <S extends PublicTxAgentoperate> S saveAndFlush(S s);

}
