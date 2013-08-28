package org.yuzutech.business.app;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;


@WebService(name = "StoreBeanWS", serviceName = "Store")
@Stateless
public class StoreBeanWS implements StoreBeanRemote {

	@Inject
	private StoreBeanLocal storeBean;

	@Override
	public void save(Store store) {
		storeBean.save(store);
	}
}
