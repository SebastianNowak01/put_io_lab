package put.io.patterns.implement;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

public class SystemMonitor {

    private SystemInfo si;

    private HardwareAbstractionLayer hal;

    private OperatingSystem os;

    private SystemState lastSystemState = null;

    private List<SystemStateObserver> observers = new ArrayList<SystemStateObserver>();
    public SystemMonitor(){
        si = new SystemInfo();
        hal = si.getHardware();
        os = si.getOperatingSystem();

    }
    public void addSystemStateObserver(SystemStateObserver observer){

    }
    public void removeSystemStateObserver(SystemStateObserver observer){

    }



    public SystemState getLastSystemState() {
        return lastSystemState;
    }
}
