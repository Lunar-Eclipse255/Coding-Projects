#include <iostream>
#include <fstream>
#include <vector>
int main(){
    std::ifstream file;
    file.open("day_one.txt");
    std::string temp_line;
    std::string temp_line_two;
    std::vector<std::string> list_one_ids;
    std::vector<std::string> list_two_ids; 
    std::vector<int> sorted_list_one_ids;
    std::vector<int> sorted_list_two_ids; 
    int diff_sum;
    int left_num;
    int num_appearances;
    int similarity_score;
    while (true) {
        std::getline(file, temp_line);
        if (file.fail()) break;
        temp_line_two = temp_line.substr(temp_line.rfind(' ')+1);
        temp_line = temp_line.substr(0, temp_line.find(' '));
        list_one_ids.push_back(temp_line);
        list_two_ids.push_back(temp_line_two);
    }
    for (int i = 0; i < list_one_ids.size(); i++) {
        for (int j = 0; j <= sorted_list_one_ids.size(); j++){
            if (sorted_list_one_ids.size() == 0){
                sorted_list_one_ids.push_back(std::stoi(list_one_ids[i]));
                break;
            }
            else if (j != sorted_list_one_ids.size()){
                if (std::stoi(list_one_ids[i]) < sorted_list_one_ids[j]){
                    sorted_list_one_ids.insert(sorted_list_one_ids.begin() + j,std::stoi(list_one_ids[i]));
                    break;
                }
            }
            else{
                sorted_list_one_ids.push_back(std::stoi(list_one_ids[i]));
                break;
            }
        }
        for (int j = 0; j <= sorted_list_two_ids.size(); j++){
            if (sorted_list_two_ids.size() == 0){
                sorted_list_two_ids.push_back(std::stoi(list_two_ids[i]));
                break;
            }
            else if (j != sorted_list_two_ids.size()){
                if (std::stoi(list_two_ids[i]) < sorted_list_two_ids[j]){
                    sorted_list_two_ids.insert(sorted_list_two_ids.begin() + j,std::stoi(list_two_ids[i]));
                    break;
                }
            }
            else{
                sorted_list_two_ids.push_back(std::stoi(list_two_ids[i]));
                break;
            }
        }
    }
    for (int i = 0; i < sorted_list_one_ids.size(); i++){
        diff_sum += std::abs(sorted_list_one_ids.at(i)-sorted_list_two_ids.at(i));
    }
    std::cout << "Total Distance: " << diff_sum << std::endl;
    for (int i = 0; i < sorted_list_one_ids.size(); i++){
        left_num = sorted_list_one_ids.at(i);
        for (int j = 0; j < sorted_list_two_ids.size(); j++){
            if (sorted_list_two_ids.at(j) == left_num){
                num_appearances++;
            }
        }
        similarity_score += (left_num * num_appearances);
        num_appearances = 0;
    }
    std::cout << "Similarity Score: " << similarity_score << std::endl;
    return 0;
}