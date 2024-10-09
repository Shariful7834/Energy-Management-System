import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.*;
import java.util.zip.*;

public class LogManager {
    private static final String LOG_DIRECTORY = "logs/";

    // Simulate logging data using character streams
    public void logData(String equipmentType, String message, String logPrefix) throws IOException {
        // Check and create the logs directory if it does not exist
        File logDir = new File(LOG_DIRECTORY);
        if (!logDir.exists()) {
            logDir.mkdirs();  // Create the directory and any necessary subdirectories
            
        }

        String logFileName = LOG_DIRECTORY + logPrefix + getCurrentDate() + ".log";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFileName, true))) {
            writer.write(LocalDate.now() + " - " + equipmentType + ": " + message + "\n");
        }
        System.out.println("Log written to " + logFileName);
        System.out.println("Log directory absolute path: " + new File(LOG_DIRECTORY).getAbsolutePath()); // I have to delete this later

    }

    // Get current date in YYYY-MM-DD format
    public String getCurrentDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    // Move log file to another directory
    public void moveLogFile(String fileName, String destinationDir) throws IOException {
        Path source = Paths.get(LOG_DIRECTORY + fileName);
        Path destination = Paths.get(destinationDir + fileName);
        Files.createDirectories(Paths.get(destinationDir));
        Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Moved file to " + destinationDir);
    }

    // Delete log file
    public void deleteLogFile(String fileName) {
        File file = new File(LOG_DIRECTORY + fileName);
        if (file.delete()) {
            System.out.println("Deleted file: " + fileName);
        } else {
            System.out.println("Failed to delete file: " + fileName);
        }
    }

    // Archive log files into a zip file
    public void archiveLogs(String fileName) throws IOException {
        String zipFileName = "archived_logs/logs_archive_" + getCurrentDate() + ".zip";
        Files.createDirectories(Paths.get("archived_logs/"));

        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFileName))) {
            File fileToZip = new File(LOG_DIRECTORY + fileName);
            try (FileInputStream fis = new FileInputStream(fileToZip)) {
                ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                zipOut.putNextEntry(zipEntry);

                byte[] bytes = new byte[1024];
                int length;
                while ((length = fis.read(bytes)) >= 0) {
                    zipOut.write(bytes, 0, length);
                }
            }
        }
        System.out.println("Archived file to " + zipFileName);
    }

    // Search for log files using regular expressions
    public void searchLogs(String equipmentName, String date) {
        File logDir = new File(LOG_DIRECTORY);
        Pattern pattern = Pattern.compile(equipmentName.toLowerCase() + "_" + date + "\\.log");
        boolean found = false;

        for (File file : logDir.listFiles()) {
            Matcher matcher = pattern.matcher(file.getName().toLowerCase());
            if (matcher.find()) {
                found = true;
                System.out.println("Found log file: " + file.getName());
                openLogFile(file.getPath());
            }
        }

        if (!found) {
            System.out.println("No log file found for " + equipmentName + " on date " + date);
        }
    }

    // Open and display the content of a log file
    private void openLogFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error opening file: " + e.getMessage());
        }
    }
    
}
