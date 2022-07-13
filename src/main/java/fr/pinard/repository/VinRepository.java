package fr.pinard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.pinard.model.Vin;
import fr.pinard.model.VinPK;

/**
 * @author Philippe
 *
 */
@Repository
public interface VinRepository extends JpaRepository<Vin, VinPK> {

}
