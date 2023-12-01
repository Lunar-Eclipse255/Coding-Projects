use std::fs::File;
use std::io::{BufRead, BufReader};

fn main() {
    let mut file = File::open("src/input/1.txt").expect("Unable to open the file");
    let reader = BufReader::new(file);
    let lines: Vec<String> = reader.lines().map(|line| line.unwrap()).collect();
    let mut check: usize = 0;
    let mut num: i32 =0;
    let mut holder = String::new();
    let mut string_sum = String::new();
    let mut full_sum = String::new();
    let mut sum: i32 = 0;
    let mut oneNum: i32 = 0;
    let mut twoNum: i32 = 0;
    let mut threeNum: i32 = 0;
    let mut fourNum: i32 = 0;
    let mut fiveNum: i32 = 0;
    let mut sixNum: i32 = 0;
    let mut sevenNum: i32 = 0;
    let mut eightNum: i32 = 0;
    let mut nineNum: i32 = 0;
    let one = "one";
    let two = "two";
    let three = "three";
    let four = "four";
    let five = "five";
    let six = "six";
    let seven = "seven";
    let eight = "eight";
    let nine = "nine"; // Change the type of sum to u64
    while check < 1000 {
        holder = lines.get(check).unwrap().to_string();
        for i in holder.chars() {
             oneNum = holder.chars().position(|c| c.to_string() == one).unwrap_or(0) as i32;
 twoNum = holder.chars().position(|c| c.to_string() == two).unwrap_or(0) as i32;
 threeNum = holder.chars().position(|c| c.to_string() == three).unwrap_or(0) as i32;
 fourNum = holder.chars().position(|c| c.to_string() == four).unwrap_or(0) as i32;
 fiveNum = holder.chars().position(|c| c.to_string() == five).unwrap_or(0) as i32;
 sixNum = holder.chars().position(|c| c.to_string() == six).unwrap_or(0) as i32;
 sevenNum = holder.chars().position(|c| c.to_string() == seven).unwrap_or(0) as i32;
eightNum = holder.chars().position(|c| c.to_string() == eight).unwrap_or(0) as i32;
nineNum = holder.chars().position(|c| c.to_string() == nine).unwrap_or(0) as i32;
            println!("Three:{}", threeNum);
            if num==oneNum{
                string_sum += "1";
            }
            else if num==twoNum{
                string_sum += "2";
            }
            else if num==threeNum{
                string_sum += "3";
            }
            else if num==fourNum{
                string_sum += "4";
            }
            else if num==fiveNum{
                string_sum += "5";
            }
            else if num==sixNum{
                string_sum += "6";
            }
            else if num==sevenNum{
                string_sum += "7";
            }
            else if num==eightNum{
                string_sum += "8";
            }
            else if num==nineNum{
                string_sum += "9";
            }
            else if i.is_digit(10) {
                string_sum += &i.to_string();
            }
            num+=1;
        }
        println!("{}", string_sum);
        if let (Some(first), Some(last)) = (string_sum.chars().next(), string_sum.chars().last()) {
            full_sum = first.to_string() + &last.to_string();
        sum += full_sum.parse::<i32>().expect("Failed to parse the string"); // Change the type of parse to u64
        }
       
    
        check += 1;
        string_sum.clear();
        
}
    println!("{}", sum);
}