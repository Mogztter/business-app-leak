package org.yuzutech.business.app;


import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(StoreBeanRemote.class)
@Local(StoreBeanLocal.class)
public class StoreBean implements StoreBeanLocal {

	@Override
	public void update(Long id) {
	}

	@Override
	public void save(Store store) {
	}
}