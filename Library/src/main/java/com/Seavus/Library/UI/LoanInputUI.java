package com.Seavus.Library.UI;

import com.Seavus.Library.Model.Loan;
import com.Seavus.Library.Service.HibernateMemberService;
import com.Seavus.Library.Service.HibernatePublicationService;

public interface LoanInputUI {

	public Loan registerLoan(HibernatePublicationService pubService, HibernateMemberService memService);
	
}
