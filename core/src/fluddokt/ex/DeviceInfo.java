package fluddokt.ex;


public class DeviceInfo {
	public static DeviceInfo info = new DeviceInfo();
	public String getInfo() {
		return "";
	}
	public String getDownloadDir() {
		return null;
	}
	// Android 10+: 앱 전용 외부 저장소 경로 반환 (scoped storage 대응)
	// 예: /storage/emulated/0/Android/data/fluddokt.opsu.android/files
	public String getDataDir() {
		return null;
	}
	public boolean shownNotification(String name){return false;}
	public boolean getHardReset(){return false;}
	public void setHardReset(boolean val){}

	public void setShownNotification(String name,boolean val){}
	public boolean isMusicPlaying(){return false;}
	public boolean isSynced(){return false;}
	public void setSynced(boolean in){}
	public void reportError(Throwable e){}
	public boolean hasPhysicalButtons(){return false;}
	public void restart(){}
}
