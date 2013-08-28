package org.yuzutech.business.app;


import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(name = "ProcessMDB", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/ProcessQueue"),
		@ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")})
public class ProcessMDB implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			if (message.getBooleanProperty("kill")) {
				throw new RuntimeException("Boom! you are dead :/");
			}
		}
		catch (JMSException e) {
		}
	}
}