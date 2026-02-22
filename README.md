# Wireless Dynamic Charging System for Electric Vehicles

[![Licence](https://img.shields.io/github/license/mashape/apistatus.svg)](https://opensource.org/licenses/MIT)
[![Software](https://img.shields.io/badge/Software-Java-red.svg)](https://www.oracle.com/java/)
[![Hardware](https://img.shields.io/badge/Hardware-Simulation%20%2F%20Embedded-green.svg)](https://www.java.com/)

## 🚀 Project Overview
The **Wireless Dynamic Charging System** is a cutting-edge technological solution designed to charge electric vehicles (EVs) while they are in motion. Traditionally, EVs require long stationary charging periods. This project proposes an infrastructure where the road itself acts as a charging pad, transferring energy to the vehicle via electromagnetic induction.

### Core Concepts
- **Wireless Power Transfer (WPT):** The transmission of electrical energy from a power source to an electrical load without the use of physical cables.
- **Dynamic Charging:** Charging the vehicle's battery while it is moving over a specialized track, effectively providing "unlimited" range as long as the vehicle stays on the charging lane.
- **Electromagnetic Induction:** Using two coils (Primary/Transmitter and Secondary/Receiver) to transfer power through an oscillating magnetic field.

---

## 🏗️ System Architecture
The system is divided into two main segments: the **Stationary Road Side** and the **Mobile Vehicle Side**.

### 1. Road Infrastructure (Transmitter)
- **Power Supply:** Converts AC Grid power to the required DC level.
- **Inverter System:** Converts DC to High-Frequency AC (HFAC) to create an oscillating magnetic field in the coils.
- **Copper Transmitter Coils:** Embedded beneath the road surface at regular intervals.

### 2. Vehicle System (Receiver)
- **Receiver Coil:** Mounted on the undercarriage of the EV.
- **Rectifier Circuit:** Converts the received HFAC back into stable DC.
- **Battery Management System (BMS):** Monitors battery levels and controls the charging flow.
- **Microcontroller / CPU:** Runs Java logic for system orchestration (Simulation or Embedded JRE).

---

## 🛠️ Hardware Components
| Component | Description |
| :--- | :--- |
| **Copper Coils** | 20AWG or 18AWG copper wire wound into flat spiral coils (Litz wire preferred). |
- **Arduino Uno / Nano** | Used for physical sensor interfacing (translated from Java logic). |
| **Java Environment** | JDK 11+ to run the monitoring and simulation controller. |
| **Rechargeable Battery** | Li-ion or Li-Po pack (e.g., 12V 2200mAh). |
| **Rectifier Circuit** | High-speed diodes (e.g., UF4007) for HFAC to DC conversion. |
| **Voltage Regulator** | Buck/Boost converter (e.g., LM2596) to stabilize charging voltage. |
| **MOSFET / Inverter** | IRFZ44N or similar for generating HF oscillations on the TX side. |
| **Sensors** | IR/Ultrasonic sensors for vehicle detection; Voltage sensor for battery monitoring. |
| **OLED Display** | To show battery percentage and charging status. |

---

## 💻 Software Logic
The software logic is implemented in **Java**, handling the battery state machine and automation.

- **Battery Monitoring:** Constantly evaluates simulated or real voltage levels.
- **Auto-Switching:** Activates "Charging Mode" when the battery falls below a threshold (e.g., 20%) AND a transmitter field is detected.
- **Safety Protocols:**
    - **Overvoltage Protection:** Cuts off charging if voltage exceeds safe limits.
    - **Exception Handling:** Robust Java error handling for sensor failures.
- **Status Console:** Real-time logging of the system status.

---

## ⚡ Working Principle
1. **Power Oscillation:** The transmitter circuit on the road generates a high-frequency magnetic field using the copper coils.
2. **Induction:** When the EV (with its receiver coil) passes over the road coil, a voltage is "induced" in the receiver coil due to Faraday's Law.
3. **Rectification:** The induced AC voltage is converted to DC using a bridge rectifier.
4. **Regulation:** The voltage is stabilized to match the battery's charging requirements (e.g., 12.6V for a 3S Li-ion pack).
5. **Charging:** The battery begins to charge. The Arduino monitors this and displays the real-time status.

---

## 🌟 Advantages
- **Infinite Range:** Potential to eliminate range anxiety by charging during travel.
- **Smaller Batteries:** EVs could function with smaller (lighter/cheaper) batteries because charging is frequent.
- **Convenience:** No need to stop at charging stations or plug in cables manually.
- **Automated Infrastructure:** Syncs perfectly with autonomous driving technology.

---

## ⚠️ Limitations & Challenges
- **Efficiency:** Power loss due to the air gap between road and vehicle.
- **Infrastructure Cost:** High initial cost for embedding coils in hundreds of miles of highway.
- **Alignment:** The car must be properly aligned over the coils for maximum efficiency.

---

## 🔮 Future Improvements
- **Smart Highways:** Roads that detect specific vehicles and bill them automatically for the energy consumed.
- **Solar Integration:** Using solar panels along the highway to power the charging coils.
- **AI Optimization:** Machine learning to predict vehicle paths and activate only the coils the car is about to pass over.

---

## 📝 Setup & Installation
1. **Circuit Assembly:** Refer to the [Circuit Diagram](docs/circuit_design.md).
2. **Software Setup:** Compile and run the Java program:
   ```bash
   javac software/EVChargingSystem.java
   java software/EVChargingSystem
   ```
3. **Coil Alignment:** Ensure the TX and RX coils are parallel and within 1-2 cm for the best demonstration.

---

*This project is for educational purposes and is a prototype of a large-scale industrial concept.*
