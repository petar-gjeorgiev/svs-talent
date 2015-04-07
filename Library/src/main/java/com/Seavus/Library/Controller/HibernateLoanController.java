package com.Seavus.Library.Controller;

import org.hibernate.SessionFactory;

import com.Seavus.Library.Factory.Factory;
import com.Seavus.Library.Model.Loan;
import com.Seavus.Library.Service.HibernateLoanService;
import com.Seavus.Library.Service.HibernateMemberService;
import com.Seavus.Library.Service.HibernatePublicationService;
import com.Seavus.Library.Service.Impl.HibernateLoanServiceImpl;
import com.Seavus.Library.Service.Impl.HibernateMemberServiceImpl;
import com.Seavus.Library.Service.Impl.HibernatePublicationServiceImpl;
import com.Seavus.Library.UI.LoanInputUI;
import com.Seavus.Library.UI.Impl.LoanInputImpl;

public class HibernateLoanController {

	public HibernateLoanService service = new HibernateLoanServiceImpl();
	public HibernatePublicationService pubService = new HibernatePublicationServiceImpl();
	public HibernateMemberService memService = new HibernateMemberServiceImpl();
	public LoanInputUI input = new LoanInputImpl();

	public void registerLoan() {
		pubService.setFactory(Factory.getFactory());
		memService.setFactory(Factory.getFactory());
		Loan loan = input.registerLoan(pubService, memService);
		service.register(loan);
	}

	public void closeFactory() {
		service.closeFactory();
	}

	public void setFactory(SessionFactory factory) {
		service.setFactory(factory);
	}

}
