
#include <RH_ASK.h>
#include <SPI.h>

RH_ASK driver;
const int sensorTrigPin = 10;
const int sensorEchoPin = 11;
long duration;
double distance;
const char *msg = "STOP";

void setup() {
  Serial.begin(9600); 
  pinMode(sensorTrigPin , OUTPUT);
  pinMode(sensorEchoPin , INPUT);
}

void loop() {
  digitalWrite(sensorTrigPin , LOW);
  delayMicroseconds(2);
  
  digitalWrite(sensorTrigPin ,HIGH);
  delayMicroseconds(10);
  digitalWrite(sensorTrigPin , LOW);
  
  duration = pulseIn(sensorEchoPin , HIGH);
  Serial.print(duration);

  if(duration > 1176){
    distance = duration*(0.034/2);
    Serial.print(distance);
    Serial.print("\n");
    driver.send((uint8_t *)msg, strlen(msg));
    driver.waitPacketSent();
  }
}
