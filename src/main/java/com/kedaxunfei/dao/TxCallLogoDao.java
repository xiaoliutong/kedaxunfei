package com.kedaxunfei.dao;

import com.kedaxunfei.entity.PublicTxCallSecond;
import com.kedaxunfei.entity.TxCallLogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TxCallLogoDao extends JpaRepository<TxCallLogo,String> {
    @Override
    <S extends TxCallLogo> List<S> save(Iterable<S> iterable);
}
