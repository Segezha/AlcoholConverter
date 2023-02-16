```main:```
![badge](https://github.com/Segezha/AlcoholConverter/actions/workflows/test.yml/badge.svg?branch=main)
```develop:```
![badge](https://github.com/Segezha/AlcoholConverter/actions/workflows/test.yml/badge.svg?branch=develop)

# AlcoholConverter
It's the little service for alcohol conversion where some other features added

## Install
### Docker

    docker build -t alcohol-converter .     
    docker run -ti --rm -p 8080:8084 alcohol-converter

## REST API

### Request

`GET /convert?firstStrength=40&firstVolume=100&secondStrenght=5`

### Response

    800.0

### Request

`GET /amount?strength=40&volume=100&gender=male&weight=80`

### Response

    0,714‰

### Request

`GET /amountForTwo?firstStrength=40&firstVolume=100&secondStrength=4.5&secondVolume=900&gender=male&weight=80`

### Response

    1,438‰

### Request

`GET /elimination?strength=5&volume=450`

### Response

    3h:22m

### Request

`GET /Russia?strength=40&volume=500`

### Response

    28h:0m

### Request

`GET /Georgia?strength=40&volume=777`

### Response

    42h:37m
