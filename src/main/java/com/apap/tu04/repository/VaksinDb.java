package ctugas1.sivaksin.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tugas1.sivaksin.model.VaksinModel;


@Repository
public interface VaksinDb extends JpaRepository<VaksinModel, Long> {
}