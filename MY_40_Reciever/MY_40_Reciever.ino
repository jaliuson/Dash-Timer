#include <RH_ASK.h>
#include <SPI.h> // Not actualy used but needed to compile

#include<SoftwareSerial.h>
#define TxD 10
#define RxD 9

RH_ASK driver;
//boolean Q;
SoftwareSerial bluetoothSerial(TxD, RxD);

void setup() {
  Serial.begin(9600);  // Debugging only
    //if (!driver.init())
         //Serial.println("init failed");
   bluetoothSerial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
  uint8_t buf[1];
  uint8_t buflen = sizeof(buf);
  if (driver.recv(buf, &buflen)){ // Non-blocking
    int i;
    // Message with a good checksum received, dump it.
    //Serial.print("Message: ");
    //Serial.println((char*)buf); 
    if((char*)buf == 1){
      //Q = true;
      bluetoothSerial.write("1");
    }
    else{
      //Q = false;
    }
  }
}
