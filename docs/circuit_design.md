# Circuit Design Explanation

The circuit is divided into two decoupled stages: the **Transmission Station** and the **Vehicle Charging Module**.

## 1. Transmission Circuit (Under Road)
- **DC Source:** 12V to 24V DC.
- **Oscillator:** A ZVS (Zero Voltage Switching) driver or a simple MOSFET-based H-bridge. This oscillates the current through the TX coil at high frequency.
- **TX Coil:** Connected in series/parallel with a capacitor to create a **Resonant LC Circuit**. Resonance is key to transferring power over air gaps.

## 2. Receiver Circuit (In Vehicle)
- **RX Coil:** Also part of a resonant LC circuit, tuned to the TX frequency.
- **Rectification:** The AC output of the RX coil goes into a Full-Bridge Rectifier.
- **Filtering:** Capacitor (e.g., 1000uF) smooths the ripple from the DC output.
- **Regulation:** An LM2596 DC-DC Buck converter steps down the voltage to the battery's specific charging voltage.
- **Monitoring:** The Arduino reads the voltage before the battery and controls a Relay or MOSFET switch to cut off charging once the battery is full.

## 3. Wiring Diagram Concept
1. **TX Side:** Power -> Inverter -> LC Tank (TX Coil + Cap).
2. **RX Side:** RX Coil + Cap -> Rectifier -> Filter -> Regulator -> Arduino/Relay -> Battery.

> *Note: For a student project, a 12V ZVS driver and 10-turn copper coils of 10cm diameter work best.*
