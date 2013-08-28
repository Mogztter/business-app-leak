package org.yuzutech.business.app;

import javax.annotation.Resource;
import javax.ejb.Stateless;

import org.infinispan.manager.EmbeddedCacheManager;

@Stateless
public class CacheService {

	@Resource(lookup = "java:jboss/infinispan/container/local-app")
	private EmbeddedCacheManager localAppCacheContainer;

	public void clear(String cacheName) {
		if (localAppCacheContainer.cacheExists(cacheName) && localAppCacheContainer.isRunning(cacheName)) {
			localAppCacheContainer.getCache(cacheName).clear();
		}
	}
}
