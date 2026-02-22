// Physics & State
let batteryVoltage = 11.5;
let isCharging = false;
let carPosition = 0;
const carSpeed = 0.5;

// DOM Elements
const evCar = document.getElementById('evCar');
const rxCoil = document.getElementById('rxCoil');
const voltageVal = document.getElementById('voltageVal');
const batteryStatus = document.getElementById('batteryStatus');
const roadWays = document.getElementById('roadWays');
const coils = document.querySelectorAll('.coil-tx');

// Intersection Observer for animations
const observer = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            entry.target.classList.add('appear');
        }
    });
}, { threshold: 0.1 });

document.querySelectorAll('.animate-on-scroll').forEach(el => observer.observe(el));

// Simulation Loop
function mainLoop() {
    // 1. Move the Car
    carPosition += carSpeed;
    if (carPosition > 100) carPosition = -20;
    evCar.style.left = carPosition + "%";

    // 2. Coil Proximity Detection (Induction Physics)
    let chargingCurrentReceived = false;

    coils.forEach(coil => {
        const coilPos = parseFloat(coil.style.left);
        const distance = Math.abs(carPosition - (coilPos - 5)); // Center alignment

        // If car receiver is within 8% of coil position, activate induction
        if (distance < 6) {
            coil.classList.add('active');
            const arc = coil.querySelector('.power-arc');
            if (arc) arc.style.opacity = "1";
            chargingCurrentReceived = true;
        } else {
            coil.classList.remove('active');
            const arc = coil.querySelector('.power-arc');
            if (arc) arc.style.opacity = "0";
        }
    });

    // 3. Logic: Update Battery Voltage
    if (chargingCurrentReceived) {
        batteryVoltage += 0.005;
        isCharging = true;
        rxCoil.classList.add('charging');
        batteryStatus.textContent = "CHARGING";
        batteryStatus.style.color = "var(--primary)";
    } else {
        batteryVoltage -= 0.002;
        isCharging = false;
        rxCoil.classList.remove('charging');
        batteryStatus.textContent = "DISCHARGING";
        batteryStatus.style.color = "#ff4d4d";
    }

    // Safety Bounds
    if (batteryVoltage > 12.6) batteryVoltage = 12.6;
    if (batteryVoltage < 9.0) batteryVoltage = 9.0;

    // 4. Update UI
    voltageVal.textContent = batteryVoltage.toFixed(2) + "V";

    requestAnimationFrame(mainLoop);
}

// Start the engine
mainLoop();
