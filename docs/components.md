# Hardware Components Deep Dive

This document provides a detailed list and explanation of the components used in the Wireless Dynamic Charging System.

## 1. Primary Transmitter (TX) Side
- **Power Inverter Module:**
  - Converts DC power from the grid/battery to high-frequency AC.
  - Frequency range: 20kHz to 100kHz (Standard for WPT).
- **Induction Coil (TX):**
  - Material: Copper (Litz wire is better for high frequency to reduce the "skin effect").
  - Shape: Flat spiral or circular to provide a uniform magnetic field.

## 2. Secondary Receiver (RX) Side
- **Induction Coil (RX):**
  - Must be tuned to the same resonant frequency as the TX coil for maximum efficiency.
- **Bridge Rectifier:**
  - Uses 4 high-speed Schottky diodes. 
  - Standard diodes like 1N4007 are too slow for high-frequency AC and will overheat.
- **Buck/Boost Converter (LM2596/XL6009):**
  - Stabilizes the variable induced voltage to a steady 12.6V or 14.4V for battery charging.

## 3. Control & Monitoring
- **Arduino Nano/Uno:**
  - Low-cost, easy to program, and sufficient I/O for sensors.
- **Voltage Sensor Module:**
  - A simple voltage divider circuit (R1=10k, R2=30k) to allow Arduino's 5V pins to read higher battery voltages safely.
- **16x2 I2C LCD or 0.96" OLED:**
  - Provides real-time visual feedback to the driver.

## 4. Energy Storage
- **Li-ion Battery Pack:**
  - High energy density.
  - Example: 3S (11.1V Nominal) or 4S (14.8V Nominal) configuration.
