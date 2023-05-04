package com.edwborges.repositories;

import com.edwborges.dtos.response.CartaoResponse;
import com.edwborges.models.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {

    List<CartaoResponse> findByRendaLessThanEqual(BigDecimal renda);
}
