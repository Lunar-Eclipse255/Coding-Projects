// basic file operations
#include <iostream>
#include <fstream>
using namespace std;

int main () {
  fstream myfile;
  myfile.open ("rtf.rtf");
  //long pos = myfile.tellp();
  myfile << "{\\rtf1\\ansi\\ansicpg1252\\cocoartf2761 \\cocoatextscaling0\\cocoaplatform0{\\fonttbl\\f0\\fnil\\fcharset0 Oxygen-Regular;}\n{\\colortbl;\\red255\\green255\\blue255;\\red255\\green0\\blue0;}\n{\\*\\expandedcolortbl;;\\csgenericrgb\\c100000\\c0\\c0;}\n\\margl1440\\margr1440\\vieww11520\\viewh8400\\viewkind0\n\\pard\\tx720\\tx1440\\tx2160\\tx2880\\tx3600\\tx4320\\tx5040\\tx5760\\tx6480\\tx7200\\tx7920\\tx8640\\pardirnatural\\partightenfactor0\n\n\\cf2 " << "[Warn]\n test" << " }" ;
  

  //myfile.seekp((long)myfile.tellp() - 1) << "hi";
  myfile.close();
  return 0;
}
