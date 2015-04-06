package com.Seavus.Library.Controller;

import org.hibernate.SessionFactory;

import com.Seavus.Library.Service.HibernatePublicationService;
import com.Seavus.Library.Service.Impl.HibernatePublicationServiceImpl;
import com.Seavus.Library.UI.InputBookUI;
import com.Seavus.Library.UI.InputMagazineUI;
import com.Seavus.Library.UI.OutputUI;
import com.Seavus.Library.UI.Impl.InputBookImpl;
import com.Seavus.Library.UI.Impl.InputMagazineImpl;
import com.Seavus.Library.UI.Impl.OutputImpl;
import com.Seavus.Library.UI.Impl.OutputMagazineImpl;
import com.Seavus.Library.UI.Impl.OutputPublicationImpl;

public class HibernatePublicationController {

	public HibernatePublicationService service = new HibernatePublicationServiceImpl();
	public InputBookUI input = new InputBookImpl();
	public InputMagazineUI inputMagazine = new InputMagazineImpl();
	public OutputUI output = new OutputImpl();
	public OutputUI outputMagazine = new OutputMagazineImpl();
	public OutputUI outputPublication = new OutputPublicationImpl();
	
	
	public void registerBook() {
		service.register(input.RegisterInput());
	}
	
	public void setFactory(SessionFactory factory) {
		service.setFactory(factory);
	}
	
	public void appBookInfo() {
		output.appInfo();
	}
	
	public void registerMagazine() {
		service.register(inputMagazine.RegisterInput());
	}

	public void listAllMagazines() {
		outputMagazine.list(service.list());
	}
	
	public void listAllBooks() {
		output.list(service.list());
	}

	public void listAllPublications() {
		outputPublication.list(service.list());
	}
	
	public void updateBook() {
		service.update(input.UpdateInput());
	}

	public void updateMagazine() {
		service.update(inputMagazine.UpdateInput());
	}
	
	public void unregisterBook() {
		service.unregister(input.UnregisterInput());
	}

	public void unregisterMagazine() {
		service.unregister(inputMagazine.UnregisterInput());
	}
	
	public void appInfo() {
		outputPublication.appInfo();
	}
	
	public void appMagazineInfo() {
		outputMagazine.appInfo();
	}
	

	public void closeFactory() {
		service.closeSession();
	}
	
}
