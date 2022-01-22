# financial-IT-bootcamp

## 1. 해당 종목(삼성전자)의 테마 이름 

- **해당종목의 테마이름 조회**

| URL | finbootcamp.com/stock/theme?code={종목명} |
| --- | --- |
| Content-Type | None |
| Request Method | GET |

- **Query String**

| **파라미터명** | **타입** | **필수여부** | **설명** |
| --- | --- | --- | --- |
| codeName | String | Y | 조회하고자하는 종목명 |


- **Response body**

| **엘리먼트 명** | **타입** | **Depth** | **배열구분** | **설명** | **값 구분** |
| --- | --- | --- | --- | --- | --- |
| status | String | 1 | N | 응답 상태 코드 |
| Result | String | 1 | N | 응답 상태에 대한 결과값 | Success : 성공(정상)Fail : 실패(오류) |
| description | String | 1 | N | 응답 결과에 대한 설명 |
| theme | String | 1 | N | 요청된 종목코드 종목의 테마명 |
 

- **샘플 JSON예제**


| **실패할 경우 샘플** |
| --- |
|{&quot;status&quot;: &quot;400&quot;, &quot;result&quot;:&quot;fail&quot;,&quot;description&quot;:&quot;BAD REQUEST&quot;}|
|{&quot;status&quot;: &quot;404&quot;, &quot;result&quot;:&quot;fail&quot;,&quot;description&quot;:&quot;NOT FOUND&quot;}|

| **성공할 경우 샘플** |
| --- |
|{&quot;status&quot;: &quot;200&quot;, &quot;result&quot;: &quot;sucess&quot;, &quot;description&quot;: &quot;OK&quot;, &quot;theme&quot;: &quot;2차전지&quot;} |






## 2. 코스피/코스닥 상위 5종목 시총 합

| URL | finbootcamp.com/stock/sum?market={시장종류} |
| --- | --- |
| Content-Type | None |
| Request Method | GET |

- **Query String**

| **파라미터명** | **타입** | **필수여부** | **설명** |
| --- | --- | --- | --- |
| market | String | Y | 조회하고자하는 시장종류 |


- **Response body**

| **엘리먼트**** 명 **|** 타입 **|** Depth **|** 배열 ****구분** | **설명** | **값 구분** |
| --- | --- | --- | --- | --- | --- |
| status | String | 1 | N | 응답 상태 코드 |
| result | String | 1 | N | 응답 상태에 대한 결과값 | Success : 성공(정상)Fail : 실패(오류) |
| description | String | 1 | N | 응답 결과에 대한 설명 |
| sum | String | 1 | N | 요청된 시장의 상위 5종목의 시가총액 합 |


- **샘플 JSON예제**

| **실패할 경우 샘플** |
| --- |
|{&quot;status&quot;: &quot;400&quot;, &quot;result&quot;:&quot;fail&quot;,&quot;description&quot;:&quot;BAD REQUEST&quot;}|
|{&quot;status&quot;: &quot;404&quot;, &quot;result&quot;:&quot;fail&quot;,&quot;description&quot;:&quot;NOT FOUND&quot;}|

| **성공할 경우 샘플** |
| --- |
| {&quot;status&quot;: &quot;200&quot;, &quot;result&quot;: &quot;sucess&quot;, &quot;description&quot;: &quot;OK&quot;, &quot;sum&quot;:&quot;20041630&quot;} |




## 3. 코스피/코스닥 상위 30개 종목 코드 및 종목명

| URL | finbootcamp.com/stock/stockList?market={시장종류} |
| --- | --- |
| Content-Type | None |
| Request Method | GET |

**- Query String**

| **파라미터명** | **타입** | **필수여부** | **설명** |
| --- | --- | --- | --- |
| Market | String | **Y** | 조회하고자하는 시장종류 |


- **Response body**

| **엘리먼트**** 명 **|** 타입 **|** Depth **|** 배열 ****구분** | **설명** | **값 구분** |
| --- | --- | --- | --- | --- | --- |
| status | String | 1 | N | 응답 상태 코드 |
| result | String | 1 | N | 응답 상태에 대한 결과값 | Success : 성공(정상)Fail : 실패(오류) |
| description | String | 1 | N | 응답 결과에 대한 설명 |
| data | Array | 1 | Y | 요청된 시장의 상위 30종목의 종목코드와 종목명 |
| code | String | 2 | N | 종목코드 |
| codeName | String | 2 | N | 종목명 |

- **샘플 JSON예제**

| **실패할 경우 샘플** |
| --- |
|{&quot;status&quot;: &quot;400&quot;, &quot;result&quot;:&quot;fail&quot;,&quot;description&quot;:&quot;BAD REQUEST&quot;}|
|{&quot;status&quot;: &quot;404&quot;, &quot;result&quot;:&quot;fail&quot;,&quot;description&quot;:&quot;NOT FOUND&quot;}|

| **성공할 경우 샘플** |
| --- |
|{&quot;status&quot;: &quot;200&quot;, &quot;result&quot;: &quot;sucess&quot;, &quot;description&quot;: &quot;OK&quot;, &quot;data&quot;: [{&quot;code&quot; : &quot;005930&quot;, &quot;codeName&quot;: &quot;삼성전자&quot;}, {&quot;code&quot; : &quot;000660&quot;, &quot;codeName&quot;: &quot;SK하이닉스&quot;}, {&quot;code&quot; : &quot;035720&quot;, &quot;codeName&quot;: &quot;카카오&quot;}]} |


## 4. 종목코드로 기업 종합 정보 조회
| URL | finbootcamp.com/stock/stockInfo?market={시장종류}&amp;code={종목코드} |
| --- | --- |
| Content-Type | None |
| Request Method | GET |

- **Query String**

| **파라미터명** | **타입** | **필수여부** | **설명** |
| --- | --- | --- | --- |
| market | String | **Y** | 조회하고자하는 시장종류 |
| code | String | **Y** | 조회하고자하는 종목코드 |


- **Response body**

| **엘리먼트명 ** | **타입** | **Depth** | **배열구분** | **설명** | **값 구분** |
| --- | --- | --- | --- | --- | --- |
| status | String | 1 | N | 응답 상태 코드 |
| result | String | 1 | N | 응답 상태에 대한 결과값 | Success : 성공(정상)Fail : 실패(오류) |
| description | String | 1 | N | 응답 결과에 대한 설명 |
| data | Object | 1 | N | 응답 결과 데이터 |
| code | String | 2 | N | 종목코드 |
| codeName | String | 2 | N | 종목명 |
| price | String | 2 | N | 가격 |
| diffRate | String | 2 | N | 전일대비 |
| volume | String | 2 | N | 거래량 |
| marketCap | String | 2 | N | 시가총액 |
| capitalStock | String | 2 | N | 자본금 |
| PER | String | 2 | N | PER |
| PBR | String | 2 | N | PBR |
| ROE | String | 2 | N | ROE |
| isCaution | Boolean | 2 | N | 주의종목 여부 |
| isDanger | Boolean | 2 | N | 위험종목 여부 |

- **샘플 JSON예제**


| **실패할 경우 샘플** |
| --- |
|{&quot;status&quot;: &quot;400&quot;, &quot;result&quot;:&quot;fail&quot;,&quot;description&quot;:&quot;BAD REQUEST&quot;}|
|{&quot;status&quot;: &quot;404&quot;, &quot;result&quot;:&quot;fail&quot;,&quot;description&quot;:&quot;NOT FOUND&quot;}|

| **성공할 경우 샘플** |
| --- |
|{&quot;status&quot;: &quot;200&quot;, &quot;result&quot;: &quot;sucess&quot;, &quot;description&quot;: &quot;OK&quot;, &quot;data&quot;: { &quot;code&quot; : &quot;005930&quot;, &quot;codeName&quot;: &quot;삼성전자&quot;,&quot;price&quot;: &quot;83000&quot;, &quot;diffRate:: 2.47,&quot;volume&quot;: &quot;38655276&quot;,&quot;marketCap&quot;: &quot;4948950&quot;,&quot;capitalStock&quot;: &quot;7780&quot;,&quot;PER&quot;: &quot;26.19&quot;,&quot;PBR&quot;: &quot;2.21&quot;,&quot;ROE&quot;: &quot;8.7&quot;,&quot;isCaution&quot;: false,&quot;isDanger&quot;: false}} |


## 5. 코스닥 종목 중 가장 높은 ROE를 가진 종목의 정보
| URL | finbootcamp.com/stock/maxRoe |
| --- | --- |
| Content-Type | None |
| Request Method | GET |

**- Query String**

| **파라미터명** | **타입** | **필수여부** | **설명** |
| --- | --- | --- | --- |
| | | |

- **Response body**

| **엘리먼트 명 ** | **타입** | **Depth** | **배열구분** | **설명** | **값 구분** |
| --- | --- | --- | --- | --- | --- |
| status | String | 1 | N | 응답 상태 코드 |
| result | String | 1 | N | 응답 상태에 대한 결과값 | Success : 성공(정상)Fail : 실패(오류) |
| description | String | 1 | N | 응답 결과에 대한 설명 |
| data | Object | 1 | N | 응답 결과 데이터 |
| code | String | 2 | N | 종목코드 |
| codeName | String | 2 | N | 종목명 |
| price | String | 2 | N | 가격 |
| diffRate | String | 2 | N | 전일대비 |
| volume | String | 2 | N | 거래량 |
| marketCap | String | 2 | N | 시가총액 |
| capitalStock | String | 2 | N | 자본금 |
| PER | String | 2 | N | PER |
| PBR | String | 2 | N | PBR |
| ROE | String | 2 | N | ROE |
| isCaution | Boolean | 2 | N | 주의종목 여부 |
| isDanger | Boolean | 2 | N | 위험종목 여부 |

- **샘플 JSON예제**
| **실패할 경우 샘플** |
| --- |
|{&quot;status&quot;: &quot;400&quot;, &quot;result&quot;:&quot;fail&quot;,&quot;description&quot;:&quot;BAD REQUEST&quot;}|
|{&quot;status&quot;: &quot;404&quot;, &quot;result&quot;:&quot;fail&quot;,&quot;description&quot;:&quot;NOT FOUND&quot;}|

| **성공할 경우 샘플** |
|{&quot;status&quot;: &quot;200&quot;, &quot;result&quot;: &quot;sucess&quot;, &quot;description&quot;: &quot;OK&quot;, &quot;data&quot;: { &quot;code&quot; : &quot;317690&quot;, &quot;codeName&quot;: &quot;퀀타매트릭스&quot;,&quot;price&quot;: &quot;29100&quot;, &quot;diffRate:: &quot;29.91&quot;,&quot;volume&quot;: &quot;5245346&quot;,&quot;marketCap&quot;: &quot;4565&quot;,&quot;capitalStock&quot;: &quot;73&quot;,&quot;PER&quot;: &quot;20.28&quot;,&quot;PBR&quot;: &quot;13.13&quot;,&quot;ROE&quot;: &quot;1165.6&quot;,&quot;isCaution&quot;: &quot;false&quot;,&quot;isDanger&quot;: &quot;false&quot;}} |


