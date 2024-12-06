#include <iostream>
#include <fstream>
#include <vector>

int main(){
    std::ifstream file;
    std::string temp_level;
    std::vector<std::vector<int>> safety_reports;
    file.open("day_two.txt");
    int line = 0;
    int is_pos = -1;
    int num_unsafe;
    int num_unsafe_per_section;
    int num_safe;
    int incr;
    while (true){
        std::getline(file, temp_level);
        if (file.fail()) break;
        safety_reports.push_back(std::vector<int>());
        while (temp_level.find(" ") != std::string::npos){
            safety_reports[line].push_back(std::stoi(temp_level.substr(0,temp_level.find(" "))));
            if (temp_level.find(" ") != std::string::npos){
                temp_level = temp_level.substr(temp_level.find(" ") + 1);
            }
        }
        safety_reports[line].push_back(std::stoi(temp_level));
        line++;
    }
    for (int i = 0; i < safety_reports.size(); i++) {
        for (int k = 0; k <= safety_reports[i].size(); k++) {
            for (int j = 0; j < safety_reports[i].size(); j++) {
                if ((j != k) && (j-1 != k)) {
                    if (j == incr && j!= 0){
                        if ((safety_reports[i].at(j) - safety_reports[i].at(j-1)) == 0){
                                incr++;
                                num_unsafe_per_section++;
                                is_pos = -1;
                        }
                        else {
                            is_pos = (safety_reports[i].at(j) - safety_reports[i].at(j-1)) > 0;
                        } 
                    }  
                    if (j == 0 && incr == 0){
                        if ((safety_reports[i].at(1) - safety_reports[i].at(0)) == 0){
                                num_unsafe_per_section++;
                                incr++;
                                is_pos = -1;
                        }
                        else {
                            is_pos = (safety_reports[i].at(1) - safety_reports[i].at(0)) > 0;
                        }
                    }
                    else {
                        if (std::abs((safety_reports[i].at(j) - safety_reports[i].at(j-1))) > 3){
                            num_unsafe_per_section++;
                        }
                        else if ((((safety_reports[i].at(j) - safety_reports[i].at(j-1)) > 0) && is_pos == 0) || (((safety_reports[i].at(j) - safety_reports[i].at(j-1)) < 0) && is_pos == 1)){
                            num_unsafe_per_section++;
                        }
                        else if ((safety_reports[i].at(j) - safety_reports[i].at(j-1)) == 0){
                            num_unsafe_per_section++;
                        }    
                    }
                }
                else if ((j-1 == k) && k != 0){
                    if (j == incr && j!= 0){
                        if ((safety_reports[i].at(j) - safety_reports[i].at(j-2)) == 0){
                                incr++;
                                num_unsafe_per_section++;
                                is_pos = -1;
                                k--;
                        }
                        else {
                            is_pos = (safety_reports[i].at(1) - safety_reports[i].at(0)) > 0;
                        } 
                    }   
                    if ((k==1) && (j==2)){
                            if ((safety_reports[i].at(j) - safety_reports[i].at(0)) == 0){
                                incr++;
                                num_unsafe_per_section++;
                                is_pos = -1;
                            }
                            else {
                            is_pos = (safety_reports[i].at(j) - safety_reports[i].at(0)) > 0;
                        } 
                    } 
                    if (j == 0 && incr == 0){
                        if ((safety_reports[i].at(1) - safety_reports[i].at(0)) == 0){
                                num_unsafe_per_section++;
                                incr++;
                                is_pos = -1;
                        }
                        else {
                            is_pos = (safety_reports[i].at(1) - safety_reports[i].at(0)) > 0;
                        }
                    }
                    else {
                        if (std::abs((safety_reports[i].at(j) - safety_reports[i].at(j-2))) > 3){
                            num_unsafe_per_section++;
                        }
                        else if ((((safety_reports[i].at(j) - safety_reports[i].at(j-2)) > 0) && is_pos == 0) || (((safety_reports[i].at(j) - safety_reports[i].at(j-2)) < 0) && is_pos == 1)){
                            num_unsafe_per_section++;
                        }
                        else if ((safety_reports[i].at(j) - safety_reports[i].at(j-2)) == 0){
                            num_unsafe_per_section++;
                        }    
                    }
                }
                else if(((j==0) || (j==1)) && (k==0)){
                    incr++;
                }
            }
            incr = 0;
            if ((num_unsafe_per_section == 0) && is_pos != -1){
                num_unsafe_per_section = 0;
                is_pos = -1;
                break;
            } 
            num_unsafe_per_section = 0;
            is_pos = -1;
            if (k == (safety_reports[i].size()-1)) {
                num_unsafe++; 
            }
        }
    }
    num_safe = 1000 - num_unsafe;
    std::cout << "Num Safe: " << num_safe << std::endl;
    return 0;
}