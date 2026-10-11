package org.example.pagoyaservicioreclamos.repository;
import org.example.pagoyaservicioreclamos.entity.Reclamo;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ReclamoRepository extends JpaRepository<Reclamo, Long> {
}