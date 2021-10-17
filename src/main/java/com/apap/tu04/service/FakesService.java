package tugas1.sivaksin.service;

import java.util.List;


import tugas1.sivaksin.model.FakesModel;

public interface FaksesService {
	FakesModel getFakesDetailByLicenseumber(String licenseNumber);
	void addFakes(FakesModel fakes);
	List<FakesModel> getAllFakes();
	void deleteFakes(FakesModel fakes);
}