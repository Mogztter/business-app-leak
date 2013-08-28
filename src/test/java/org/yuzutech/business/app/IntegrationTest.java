package org.yuzutech.business.app;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.resolver.api.Resolvers;
import org.jboss.shrinkwrap.resolver.api.maven.MavenResolverSystem;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertNotNull;

@RunWith(Arquillian.class)
public abstract class IntegrationTest {

	@Inject
	StoreBeanLocal storeBean;

	@Deployment
	public static EnterpriseArchive createDeployment() {
		return ShrinkWrap.create(EnterpriseArchive.class)
				.addAsManifestResource("META-INF/test-jboss-deployment-structure.xml", "jboss-deployment-structure.xml")
				.addAsLibraries(
						Resolvers.use(MavenResolverSystem.class).resolve(
								"org.mockito:mockito-all:1.9.0",
								"org.codehaus.jackson:jackson-core-asl:1.9.8",
								"org.codehaus.jackson:jackson-mapper-asl:1.9.8"
						).withoutTransitivity().asFile())
				.addAsModule(
						ShrinkWrap.create(JavaArchive.class)
								.addPackages(true, "org.yuzutech.business.app")
								.addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
								.addAsManifestResource("META-INF/beans.xml", "beans.xml")
				);
	}

	@Test
	public void getEntityManagerByClassName() throws Exception {
		assertNotNull(storeBean);
	}
}
