import java.io.IOException;

public class EnergyManagementSystem {
    public static void main(String[] args) throws IOException {
        LogManager logManager = new LogManager();

        // Simulating log creation for each equipment
        logManager.logData("ChargingStation", "Charging station operational", "charging_station_");
        logManager.logData("EnergySource", "Energy source operational", "energy_source_");
        logManager.logData("System", "System operational", "system_");

        // Example: Move, delete, and search logs using regular expressions
        logManager.moveLogFile("charging_station_" + logManager.getCurrentDate() + ".log", "archived_logs/");
        logManager.deleteLogFile("energy_source_" + logManager.getCurrentDate() + ".log");
        logManager.searchLogs("ChargingStation", logManager.getCurrentDate());
        
    }
}
