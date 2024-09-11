// Example program
#include <iostream>
#include <string>
#include <vector>
#include <utility>

typedef enum motor_fault_e {
      E_MOTOR_FAULT_NO_FAULTS = 0x00,
      E_MOTOR_FAULT_MOTOR_OVER_TEMP = 0x01,  // Analogous to motor_is_over_temp()
      E_MOTOR_FAULT_DRIVER_FAULT = 0x02,     // Indicates a motor h-bridge fault
      E_MOTOR_FAULT_OVER_CURRENT = 0x04,     // Analogous to motor_is_over_current()
      E_MOTOR_FAULT_DRV_OVER_CURRENT = 0x08  // Indicates an h-bridge over current
} motor_fault_e_t;




void motor_fault_log (int port_index, motor_fault_e motor_fault) {
  std::vector<std::pair<motor_fault_e_t, std::string> > pros_motor_faults;
pros_motor_faults.emplace_back(E_MOTOR_FAULT_MOTOR_OVER_TEMP, " over temperature: ");
pros_motor_faults.emplace_back(E_MOTOR_FAULT_DRIVER_FAULT, " driver fault (H-bridge fault): ");
pros_motor_faults.emplace_back(E_MOTOR_FAULT_OVER_CURRENT, " over current: ");
pros_motor_faults.emplace_back(E_MOTOR_FAULT_DRV_OVER_CURRENT, " H-bridge over current: ");
            bool faults[][5] = { };
    for (int i = 0; i < 6; ++i) {
                for (int j = 0; j <= 4; ++j) {
                    faults[i][j] = false;
                }
            }
            for (int i = 0; i < pros_motor_faults.size(); i++) {
                std::cout << static_cast<int>(motor_fault) <<" oc\n";
               std::cout << pros_motor_faults[2].first << " mf\n";
                //if (motor_fault & E_MOTOR_FAULT_OVER_CURRENT) {
                //if (E_MOTOR_FAULT_OVER_CURRENT & pros_motor_faults[2].first) {
                if (motor_fault & pros_motor_faults[2].first) {
                    std::cout << "hi";
                    if (!faults[port_index][i]){
                        std::cout << "Motor: " + std::to_string(abs(1)) + pros_motor_faults[i].second + "time" + "\n";
                        faults[port_index][i] = true;
                    }
                }
                else {
                    if (faults[port_index][i]){
                        std::cout << "Motor: " + std::to_string(abs(1)) + pros_motor_faults[i].second + "all clear: " + "time" + "\n";
                    }
                    faults[port_index][i] = false;
                }
            }
            
        }
        
int main()
{
// std::cout << E_MOTOR_FAULT_OVER_CURRENT <<" oc\n";
// std::cout << pros_motor_faults[2].first << " mf\n";

motor_fault_log(1, E_MOTOR_FAULT_OVER_CURRENT);

}