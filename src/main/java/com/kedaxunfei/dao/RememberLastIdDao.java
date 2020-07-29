
package com.kedaxunfei.dao;

import com.kedaxunfei.entity.RememberLastId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RememberLastIdDao extends JpaRepository<RememberLastId,String> {
    @Override
    <S extends RememberLastId> S save(S s);
}

