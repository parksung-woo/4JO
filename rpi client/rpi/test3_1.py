from time import sleep
import requests 
import Adafruit_DHT
import datetime
import threading
import json
import urllib.request
import RPi.GPIO as GPIO

sensor = Adafruit_DHT.DHT11
#핀 번호 할당 방법은 커넥터 핀 번호로 설정
GPIO.setmode(GPIO.BOARD)

# 온습도 센서와 라즈베리 파이는 아래와 같이 다이렉트로 연결
 # Signal(녹색) - GPIO4 (Pin no. 7)
# Vcc(빨강) - 5V 전원 (Pin no. 2)
# Ground(검정) - GND (Pin no. 6)

pin = 4

#LED
LED = 11
#11번 핀을 출력 핀으로 설정, 초기 출력은 로우 레벨
GPIO.setup(LED, GPIO.OUT, initial=GPIO.LOW)



global url
url = 'http://192.168.0.100:8383/sensor'

def ondoData():
        
    h, t = Adafruit_DHT.read_retry(sensor, pin)
    now = datetime.datetime.now()
    nowDate = now.strftime('%Y-%m-%d %H:%M:%S')

    if h is not None and t is not None :
        print("Temperature = {0:0.2f}*C Humidity = {1:0.2f}%".format(t, h))
        print(nowDate)
        temperature = str(t)
        humidity = str(h)
        nowDatetime = str(nowDate)
        data = requests.get('http://192.168.0.100:8383/raspberryInsert?&temperature=' 
        + temperature + '&humidity=' + humidity + '&nowDatetime=' +nowDatetime)
        print(data.text)

    else :
        print('Read error')



def sensorData():
    
    json_data = urllib.request.urlopen(url).read()
    text_data = json.loads(json_data)
    sensorDate = sorted(text_data, key = lambda db_sensor: db_sensor['sensorDate'])

    for db_sensor in sensorDate:
        rs = db_sensor['sensor']
        
    print(rs)
        
    return rs
    
def LED_1():
    rs = sensorData()
    if rs == str(1) :
        print('작동: 1')
        try:
            GPIO.output(LED, GPIO.HIGH)
        except:
            print('작동 1 : 예외 발생')
            pass

    elif rs == str(0) :
        print('작동: 0')
        try:
            GPIO.output(LED, GPIO.LOW)

        except:
            print('작동 0 : 예외 발생')
            pass
        
    else :
        print('sensor값 error')

def test1():
    while True:
        ondoData()
        print('ondoData 딜레이 있는 함수')
        sleep(300)

def test2():
    while True:
        sensorData()
        print('sensorData 딜레이 있는 함수')
        sleep(5)

def test3():
    while True:
        LED_1()
        print('LED_1 딜레이 있는 함수')
        sleep(1)

if __name__ == '__main__':

    t1 = threading.Thread(target=test1)
    t2 = threading.Thread(target=test2)
    t3 = threading.Thread(target=test3) 

    t1.start()
    t2.start()
    t3.start()