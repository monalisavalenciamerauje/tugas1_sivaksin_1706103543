package tugas1.sivaksin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import tugas1.sivaksin.model.VaksinModel;
import tugas1.sivaksin.model.FakesModel;
import tugas1.sivaksin.service.VaksinService;
import tugas1.sivaksin.service.FakesService;

@Controller
public class SivaksinController {
	@Autowired
	private SivaksintService sivaksintService;
	
	@Autowired
	private FakesService fakesService;
	
	@RequestMapping(value = "/vaksin/add/{licenseNumber}", method = RequestMethod.GET)
	private String add(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
		VaksinModel vaksin = new VaksinModel();
		FakesModel fakes = fakesService.getFakesDetailByLicenseumber(licenseNumber);
		vaksin.setFakes(fakes);
		model.addAttribute("vaksin", vaksin);
		return "addVaksin";
	}
	
	@RequestMapping(value = "/vaksin/add", method = RequestMethod.POST)
	private String addVaksinSubmit(@ModelAttribute VaksinModel vaksin) {
		vaksinService.addVaksin(vaksin);
		return "add";
	}
	
}