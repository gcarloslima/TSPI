package com.relgs.mensageria.mensagemcorpo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensagemCorpoRepository extends JpaRepository<MensagemCorpo, Long> {
}
