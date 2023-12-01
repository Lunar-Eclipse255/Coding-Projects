use std::io::prelude::*;
use std::fs::File;

fn main() {
    let mut file = File::open("src/input/6_2022.txt").expect("Unable to open the file");
    let mut contents = String::new();
    let mut check: i32=0;
    let mut num: i32=0;
    let mut char1: char = ' ';
    let mut char2: char = ' ';
    let mut char3: char = ' ';
    let mut char4: char = ' ';

    file.read_to_string(&mut contents).expect("Unable to read the file");
    'outer: for i in contents.chars(){
        num+=1;
        if check == 0{
            char1 =i;
            check+=1;
        }
        else if check == 1{
            char2 =i;
            check+=1;
        }
        else if check == 2{
            char3 =i;
            check+=1;
        }
        else if check == 3{
            char4 =i;
            check=0;
            if(char1 != char2)&&(char1 != char3)&&(char1 != char4)&&(char2 != char3)&&(char2 != char4)&&(char3 != char4){
                break 'outer;
            }

        }
    }
    println!("{}",num);

    
}