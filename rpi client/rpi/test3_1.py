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


# 센서 데이터 값 받아오는 주소
global url
url = 'http://192.168.0.100:8383/sensor'

#라즈베리파이 온도 측정후 웹으로 데이터값을 보낸다.
def ondoData():
        
    h, t = Adafruit_DHT.read_retry(sensor, pin) # 온습도 값 저장할 변수
    now = datetime.datetime.now()               # 현재 날짜 시간을 now 저장
    nowDate = now.strftime('%Y-%m-%d %H:%M:%S') #현재 날짜 시간을 %Y-%m-%d %H:%M:%S형식으로 nowDate에 저장

    # 온습도값이 정상적으로 들어오면
    if h is not None and t is not None :
        # 온습도를 소수점 첫째자리까지(둘째 짜리에서 반올림) 출력
        print("Temperature = {0:0.2f}*C Humidity = {1:0.2f}%".format(t, h))
        print(nowDate)
        temperature = str(t)         #문자열 형식으로 저장
        humidity = str(h)            #문자열 형식으로 저장
        nowDatetime = str(nowDate)   #문자열 형식으로 저장
        # 저장된 데이터를 웹으로 보냄
        data = requests.get('http://192.168.0.100:8383/raspberryInsert?&temperature=' 
        + temperature + '&humidity=' + humidity + '&nowDatetime=' +nowDatetime)
        print(data.text)

    else :
        print('Read error')


# 웹에서 센서데이터 읽음
def sensorData():
    #json 형식으로된 데이터를 파싱
    json_data = urllib.request.urlopen(url).read()
    text_data = json.loads(json_data)

    #센서 데이터가 저장된 시간을 키값으로 설정(최근에 들어온 센서값을 뽑아오기위해서)
    sensorDate = sorted(text_data, key = lambda db_sensor: db_sensor['sensorDate'])

    for db_sensor in sensorDate:
        rs = db_sensor['sensor']
        
    print(rs)
        
    return rs
# 센서데이터 값에 따라 1이면 On 0이면 Off
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

#반복문을 따로 빼서 만들고 딜레이 설정
def test1():
    while True:
        ondoData()
        print('ondoData 딜레이 있는 함수')
        sleep(300)
#반복문을 따로 빼서 만들고 딜레이 설정
def test2():
    while True:
        sensorData()
        print('sensorData 딜레이 있는 함수')
        sleep(5)
#반복문을 따로 빼서 만들고 딜레이 설정
def test3():
    while True:
        LED_1()
        print('LED_1 딜레이 있는 함수')
        sleep(1)

# 멀티 스레딩( 세개가 돌아간다.)
if __name__ == '__main__':

    t1 = threading.Thread(target=test1)
    t2 = threading.Thread(target=test2)
    t3 = threading.Thread(target=test3) 

    t1.start()
    t2.start()
    t3.start()