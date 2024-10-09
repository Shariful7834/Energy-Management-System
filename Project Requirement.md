# Project Requirements

## Project: Energy Management System

### Overview

The **Energy Management System** is a Java-based program designed to manage log files for an energy system, including charging stations, energy sources, and the entire system. The program simulates data exchange using byte and character streams, performs file operations such as creating, moving, deleting, and archiving log files, and provides functionality for searching and opening log files based on equipment name or date.

---

### Functional Requirements

1. **Log Creation**
   - The system should create log files for each piece of equipment (charging station, energy source, and the overall system) daily.
   - The log files should be named in the format: `<equipment_type>_YYYY-MM-DD.log`.

2. **File Operations**
   - The system must support the following file operations:
     - **Move** log files from one directory to another.
     - **Delete** specific log files.
     - **Archive** log files into a zip format for storage and backup purposes.

3. **Data Simulation**
   - The system must simulate data exchange by writing messages into log files using character streams.

4. **Log Search**
   - The system should provide functionality for searching and opening log files based on the following criteria:
     - **Equipment name** (e.g., ChargingStation, EnergySource).
     - **Date** in the format `YYYY-MM-DD`.

5. **Log Viewing**
   - Users should be able to open and view the content of a log file after it has been found via a search.

---

### Non-Functional Requirements

1. **Usability**
   - The system should be easy to use, with clear prompts and outputs in the console for user actions.

2. **Performance**
   - File operations (creation, moving, deleting, archiving) should be performed efficiently with minimal latency.

3. **Portability**
   - The system should be platform-independent and run on any machine with a compatible Java Runtime Environment (JRE).

4. **Error Handling**
   - The system must handle errors such as missing directories or file I/O exceptions gracefully.

---

### Technical Requirements

1. **Programming Language**
   - The project must be implemented in **Java**.

2. **Libraries**
   - Use the following Java standard libraries:
     - `java.io` for file I/O operations.
     - `java.nio.file` for file path management.
     - `java.util.regex` for regular expressions.

3. **Version Control**
   - The project should be managed using Git.

4. **Documentation**
   - Provide a README file with clear setup instructions and project structure.

---

### Future Enhancements

1. **GUI Implementation**
   - The system could be extended to have a graphical user interface (GUI) for easier interaction and visualization of logs.

2. **Database Integration**
   - Logs could be stored in a database for better scalability and management, especially for large-scale energy systems.

3. **Real-time Monitoring**
   - Implement real-time monitoring of energy systems, with live updates being logged automatically.

---





# Security Policy

## Supported Versions

Use this section to tell people about which versions of your project are
currently being supported with security updates.

| Version | Supported          |
| ------- | ------------------ |
| 5.1.x   | :white_check_mark: |
| 5.0.x   | :x:                |
| 4.0.x   | :white_check_mark: |
| < 4.0   | :x:                |

## Reporting a Vulnerability

Use this section to tell people how to report a vulnerability.

Tell them where to go, how often they can expect to get an update on a
reported vulnerability, what to expect if the vulnerability is accepted or
declined, etc.
