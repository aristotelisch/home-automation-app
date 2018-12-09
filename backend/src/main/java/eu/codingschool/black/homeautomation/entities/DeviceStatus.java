package eu.codingschool.black.homeautomation.entities;

public class DeviceStatus {
  private Long deviceId;
  private Boolean status;

  public DeviceStatus (Long deviceId, Boolean status) {
    this.deviceId = deviceId;
    this.status = status;
  }

  public Long getDeviceId () {
    return deviceId;
  }

  public void setDeviceId (Long deviceId) {
    this.deviceId = deviceId;
  }

  public Boolean getStatus () {
    return status;
  }

  public void setStatus (Boolean status) {
    this.status = status;
  }
}
