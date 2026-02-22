/**
 * Wireless Dynamic Charging System Simulation
 * -------------------------------------------
 * This Java program simulates the logic of an EV's battery monitoring
 * and automatic wireless charging activation.
 */

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class EVChargingSystem {

    // Constants
    private static final double VOLTAGE_THRESHOLD_LOW = 11.0;  // Threshold to start charging (Volts)
    private static final double VOLTAGE_THRESHOLD_FULL = 12.6; // Threshold for full battery
    private static final double DISCHARGE_RATE = 0.05;         // Simulating battery drain
    private static final double CHARGE_RATE = 0.15;           // Simulating wireless induction charging

    // State Variables
    private double currentVoltage = 12.0;
    private boolean isCharging = false;
    private boolean isNearCharger = true; // Simulates being over a road coil

    public static void main(String[] args) {
        EVChargingSystem system = new EVChargingSystem();
        system.runSimulation();
    }

    public void runSimulation() {
        System.out.println("==============================================");
        System.out.println("   EV WIRELESS DYNAMIC CHARGING SIMULATOR    ");
        System.out.println("==============================================");

        while (true) {
            updateLogic();
            displayStatus();

            try {
                TimeUnit.SECONDS.sleep(1); // Update every second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }

            // Simulate battery behavior
            if (isCharging) {
                currentVoltage += CHARGE_RATE;
            } else {
                currentVoltage -= DISCHARGE_RATE;
            }

            // Safety Cap
            if (currentVoltage > 13.0) currentVoltage = 12.6;
            if (currentVoltage < 9.0) {
                System.out.println("\n[ALERT] Battery Critically Low! Vehicle Stopped.");
                break;
            }
        }
    }

    private void updateLogic() {
        // Charging Activation Logic
        if (currentVoltage < VOLTAGE_THRESHOLD_LOW && !isCharging && isNearCharger) {
            startCharging();
        } else if (currentVoltage >= VOLTAGE_THRESHOLD_FULL && isCharging) {
            stopCharging();
        }
    }

    private void startCharging() {
        isCharging = true;
        System.out.println("\n[ACTION] Low Battery Detected. Wireless Induction Circuit ACTIVATED.");
    }

    private void stopCharging() {
        isCharging = false;
        System.out.println("\n[ACTION] Battery Full. Wireless Charging Circuit DEACTIVATED.");
    }

    private void displayStatus() {
        String status = isCharging ? "CHARGING..." : "DISCHARGING";
        System.out.printf("Battery Level: %.2fV | Mode: %s\r", currentVoltage, status);
    }
}
