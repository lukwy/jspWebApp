package pl.imsi;

class MyBean 
{
    private String device_name;
    public String getDevice_name() {
		return device_name;
	}
	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}
	public String getSystem_name() {
		return system_name;
	}
	public void setSystem_name(String system_name) {
		this.system_name = system_name;
	}
	public String getAlert_text() {
		return alert_text;
	}
	public void setAlert_text(String alert_text) {
		this.alert_text = alert_text;
	}
	public String getArrival_time() {
		return arrival_time;
	}
	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}
	public String getAck_time() {
		return ack_time;
	}
	public void setAck_time(String ack_time) {
		this.ack_time = ack_time;
	}
	public String getAck_status() {
		return ack_status;
	}
	public void setAck_status(String ack_status) {
		this.ack_status = ack_status;
	}
	private String system_name;
    private String alert_text;
    private String arrival_time;
    private String ack_time;
    private String ack_status;

    
}