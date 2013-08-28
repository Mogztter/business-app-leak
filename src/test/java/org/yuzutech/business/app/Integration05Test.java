package org.yuzutech.business.app;

import javax.inject.Inject;

import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

public class Integration05Test extends IntegrationTest {

	@Inject
	StoreBeanLocal storeBean;

	@Test
	public void getEntityManagerByClassName() throws Exception {
		assertNotNull(storeBean);
	}
}
