package org.dcm4che.sample.osgi.echo;

import org.dcm4che.net.DimseRQHandler;
import org.dcm4che.net.service.BasicCEchoSCP;
import org.dcm4che.net.service.DicomServiceRegistry;
import org.dcm4che.sample.osgi.DeviceServiceInterface;

public class EchoService extends BasicCEchoSCP implements DimseRQHandler
{
	private DeviceServiceInterface deviceService;
	
	public void setDeviceService(DeviceServiceInterface deviceService) 
	{
		System.out.println("adding to the Registry:" + this);
		
		this.deviceService = deviceService;
		((DicomServiceRegistry)deviceService.getDevice().getDimseRQHandler()).addDicomService(this);	
	}
}