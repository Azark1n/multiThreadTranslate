# multiThreadTranslate

## Introduction

`multiThreadTranslate` is a multi-threaded REST client that showcases parallel HTTP requests for text translation. This project is split into two services:

- **mockTranslate**: Handles transliteration between English (en) and Russian (ru).
- **main**: The primary service that interacts with `mockTranslate` to demonstrate the translation process.

The system uses a configurable thread pool (default is 5 threads) to send translation requests in parallel, optimizing performance for intensive I/O operations such as HTTP requests in a Java Spring Boot environment.

## Features

- Multi-threaded translation requests for enhanced performance.
- Parallel processing of translation tasks.
- In-memory H2 database to log:
  - Timestamp of the translation request.
  - Input parameters (source text, source and target languages).
  - Client's IP address.

## Examples

#### 1. Transliteration from English to Russian:

```bash
curl -L 'http://localhost:8080/translate' \
-H 'Content-Type: application/json' \
-d '{
"text": "Once the application is running, you can use any HTTP client",
"from": "en",
"to": "ru"
}'
```

Output:

```json
[
"ОНcЭ",
"ТХЭ",
"АППЛИcАТИОН",
"ИС",
"РУННИНГ",
"ЁУ",
"cАН",
"УСЭ",
"АНЫ",
"ХТТП",
"cЛИЭНТ"
]
```

#### 2. Fetching Translation Record:

```bash
curl -L 'http://localhost:8080/translate'
```

Output:

```json
[
  {
    "id": 1,
    "text": "Once the application is running, you can use any HTTP client",
    "from": "en",
    "to": "ru",
    "createdDate": "2024-05-05T12:50:45.260221Z",
    "ip": "172.31.0.1"
  }
]
```

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
* Git
* JDK 17 or later
* Gradle
* Docker

### Installation and running
```bash
git clone https://github.com/Azark1n/multiThreadTranslate.git
cd multiThreadTranslate
./gradlew bootJar
docker compose up -d
```
