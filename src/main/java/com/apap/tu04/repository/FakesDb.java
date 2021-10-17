package tugas1.sivaksin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tugas1.sivaksin.model.FakesModel;


@Repository
public interface FakestDb extends JpaRepository<FakesModel, Long> {
	FakesModel findByLicenseNumber(String licenseNumber);

}